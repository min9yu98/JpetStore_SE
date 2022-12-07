/*
 *    Copyright 2010-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.web.actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.service.AccountService;
import org.mybatis.jpetstore.service.CatalogService;

/**
 * The Class AccountActionBean.
 *
 * @author Eduardo Macarron
 */
@SessionScope
public class AccountActionBean extends AbstractActionBean {

  private static final long serialVersionUID = 5499663666155758178L;

  private static final String NEW_ACCOUNT = "/WEB-INF/jsp/account/NewAccountForm.jsp";
  private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";
  private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";
  private static final String INSERT_REQUEST_BY_USER = "/WEB-INF/jsp/account/InsertRequestFormByUser.jsp";
  private static final String VIEW_USER_REQUEST_LIST_BY_ADMIN = "/WEB-INF/jsp/account/ViewUserRequestListByAdmin.jsp";
  private static final String VIEW_USER_REQUEST_CONTENT_BY_ADMIN = "/WEB-INF/jsp/account/ViewUserRequestContentByAdmin.jsp";
  public static final String ACCESS_RESTRICTION = "/WEB-INF/jsp/common/AccessRestriction.jsp";


  private static final List<String> LANGUAGE_LIST;
  private static final List<String> CATEGORY_LIST;
  private static final List<String> REQUEST_PARENT_CATEGORY;
  private static final List<String> REQUEST_SUB_CATEGORY;

  @SpringBean
  private transient AccountService accountService;
  @SpringBean
  private transient CatalogService catalogService;

  private List<Account> userRequests;
  private Account account = new Account();
  private Account request = new Account();
  private List<Product> myList;
  private boolean authenticated;
  private boolean admin;
  private String username;
  private String writer;
  private String title;
  private String content;
  private String writingDate;

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Account getRequest() {
    return request;
  }

  public void setRequest(Account request) {
    this.request = request;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getWritingDate() {
    return writingDate;
  }

  public void setWritingDate(String writingDate) {
    this.writingDate = writingDate;
  }

  static {
    LANGUAGE_LIST = Collections.unmodifiableList(Arrays.asList("english", "japanese"));
    CATEGORY_LIST = Collections.unmodifiableList(Arrays.asList("FISH", "DOGS", "REPTILES", "CATS", "BIRDS"));
    REQUEST_PARENT_CATEGORY = Collections.unmodifiableList(Arrays.asList("동물 정보", "동물 환경", "기타"));
    REQUEST_SUB_CATEGORY = Collections.unmodifiableList(Arrays.asList("기준 수정 요청", "정보 수정 요청", "기타"));
  }
  public List<String> getRequestParentCategory() {return REQUEST_PARENT_CATEGORY;}
  public List<String> getRequestSubCategory() {return REQUEST_SUB_CATEGORY;}
  public List<Account> getUserRequests() {
    return userRequests;
  }

  public void setUserRequests(List<Account> userRequests) {
    this.userRequests = userRequests;
  }

  public Account getAccount() {
    return this.account;
  }

  public String getUsername() {
    return account.getUsername();
  }

  @Validate(required = true, on = { "signon", "newAccount", "editAccount" })
  public void setUsername(String username) {
    account.setUsername(username);
  }

  public String getPassword() {
    return account.getPassword();
  }

  @Validate(required = true, on = { "signon", "newAccount", "editAccount" })
  public void setPassword(String password) {
    account.setPassword(password);
  }

  public List<Product> getMyList() {
    return myList;
  }

  public void setMyList(List<Product> myList) {
    this.myList = myList;
  }

  public List<String> getLanguages() {
    return LANGUAGE_LIST;
  }

  public List<String> getCategories() {
    return CATEGORY_LIST;
  }

  public Resolution newAccountForm() {
    return new ForwardResolution(NEW_ACCOUNT);
  }

  /**
   * New account.
   *
   * @return the resolution
   */
  public Resolution newAccount() {
    accountService.insertAccount(account);
    account = accountService.getAccount(account.getUsername());
    myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
    authenticated = true;
    return new RedirectResolution(CatalogActionBean.class);
  }

  /**
   * Edits the account form.
   *
   * @return the resolution
   */
  public Resolution editAccountForm() {
    return new ForwardResolution(EDIT_ACCOUNT);
  }

  /**
   * Edits the account.
   *
   * @return the resolution
   */
  public Resolution editAccount() {
    accountService.updateAccount(account);
    account = accountService.getAccount(account.getUsername());
    myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
    return new RedirectResolution(CatalogActionBean.class);
  }

  /**
   * Signon form.
   *
   * @return the resolution
   */
  @DefaultHandler
  public Resolution signonForm() {
    return new ForwardResolution(SIGNON);
  }

  /**
   * Signon.
   *
   * @return the resolution
   */
  public Resolution signon() {

    account = accountService.getAccount(getUsername(), getPassword());

    if (account == null) {
      String value = "Invalid username or password.  Signon failed.";
      setMessage(value);
      clear();
      return new ForwardResolution(SIGNON);
    } else {
      account.setPassword(null);
      if (isAdmin()) {
        authenticated = true;
        admin = true;
        HttpSession s = context.getRequest().getSession();
        s.setAttribute("accountBean", this);
      } else {
        authenticated = true;
        admin = false;
        HttpSession s = context.getRequest().getSession();
        s.setAttribute("accountBean", this);
        myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
      }
      return new RedirectResolution(CatalogActionBean.class);
    }
  }

  /**
   * Signoff.
   *
   * @return the resolution
   */
  public Resolution signoff() {
    context.getRequest().getSession().invalidate();
    clear();
    return new RedirectResolution(CatalogActionBean.class);
  }

  /**
   * Checks if is authenticated.
   *
   * @return true, if is authenticated
   */
  public boolean isAuthenticated() {
    return authenticated && account != null && account.getUsername() != null;
  }

  public boolean isAdmin() {
    return admin && account != null && account.getUsername() != null;
  }

  public Resolution insertRequestByUser() {
    accountService.insertRequestByUser(account);
    return new RedirectResolution(CatalogActionBean.class, "viewItem");
  }

  public Resolution insertRequestFormByUser() {
    return new ForwardResolution(INSERT_REQUEST_BY_USER);
  }

  public ForwardResolution viewUserRequestListByAdmin() {
    if (accountService.isAdmin(account.getUsername())) {
      userRequests = accountService.viewUserRequestListByAdmin();
      return new ForwardResolution(VIEW_USER_REQUEST_LIST_BY_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }

  public ForwardResolution viewUserRequestContentByAdmin() {
    if (accountService.isAdmin(account.getUsername())) {
      writer = account.getWriter();
      title = account.getTitle();
      writingDate = account.getWritingDate();
      request = accountService.viewUserRequestContentByAdmin(writer, title, writingDate);
      content = request.getContent();
      return new ForwardResolution(VIEW_USER_REQUEST_CONTENT_BY_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }
  /**
   * Clear.
   */
  public void clear() {
    account = new Account();
    myList = null;
    authenticated = false;
  }

}
