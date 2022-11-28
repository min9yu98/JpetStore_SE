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

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.Gson;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.service.AccountService;
import org.mybatis.jpetstore.service.CatalogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class CatalogActionBean.
 *
 * @author Eduardo Macarron
 */
@SessionScope
public class CatalogActionBean extends AbstractActionBean {

  private static final long serialVersionUID = 5849523372175050635L;

  private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
  private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
  private static final String VIEW_PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";
  private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
  private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
  private static final String VIEW_PRODUCT_LIST_ADMIN = "/WEB-INF/jsp/catalog/ProductListByAdmin.jsp";
  private static final String VIEW_ITEM_LIST_ADMIN = "/WEB-INF/jsp/catalog/ItemListByAdmin.jsp";
  private static final String NEW_ITEM_ADMIN = "/WEB-INF/jsp/catalog/InsertItemFormByAdmin.jsp";

  public static final String ACCESS_RESTRICTION = "/WEB-INF/jsp/common/AccessRestriction.jsp";
  private static final String UPDATE_ITEM_ADMIN = "/WEB-INF/jsp/catalog/UpdateItemFormByAdmin.jsp";

  @SpringBean
  private transient CatalogService catalogService;
  @SpringBean
  private transient AccountService accountService;

  private String keyword;

  private String categoryId;
  private Category category;
  private List<Category> categoryList;

  private String productId;
  private Product product;
  private List<Product> productList;

  private String itemId;
  private Item item;
  private List<Item> itemList;
  private String username;
  private BigDecimal listPrice;
  private String attribute1;
  private int quantity;

  public BigDecimal getListPrice() {
    return listPrice;
  }

  public void setListPrice(BigDecimal listPrice) {
    this.listPrice = listPrice;
  }

  public String getAttribute1() {
    return attribute1;
  }

  public void setAttribute1(String attribute1) {
    this.attribute1 = attribute1;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public List<Category> getCategoryList() {
    return categoryList;
  }

  public void setCategoryList(List<Category> categoryList) {
    this.categoryList = categoryList;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  @DefaultHandler
  public ForwardResolution viewMain() {
    return new ForwardResolution(MAIN);
  }

  public Resolution newItemFormByAdmin() {return new ForwardResolution(NEW_ITEM_ADMIN);}

  public Resolution updateItemFormByAdmin() {
    item = catalogService.getItem(getItemId());

    HttpSession session = context.getRequest().getSession();
    session.setAttribute("catalogBean", this);
    CatalogActionBean catalogActionBean = (CatalogActionBean) session.getAttribute("/actions/Catalog.action");
    if (catalogActionBean == null) {
      return new RedirectResolution(ACCESS_RESTRICTION);
    } else {
      item.initUpdateByAdmin(catalogActionBean.getItem());

      return new ForwardResolution(UPDATE_ITEM_ADMIN);
    }
//    return new ForwardResolution(UPDATE_ITEM_ADMIN);
  }

  /**
   * View category.
   *
   * @return the forward resolution
   */
  public ForwardResolution viewCategory() {
    if (categoryId != null) {
      productList = catalogService.getProductListByCategory(categoryId);
      category = catalogService.getCategory(categoryId);
    }
    return new ForwardResolution(VIEW_CATEGORY);
  }

  /**
   * View product.
   *
   * @return the forward resolution
   */
  public ForwardResolution viewProduct() {
    if (productId != null) {
      itemList = catalogService.getItemListByProduct(productId);
      product = catalogService.getProduct(productId);
    }
    return new ForwardResolution(VIEW_PRODUCT);
  }

  /**
   * view All Product(admin)
   *
   * @return
   *
   * */
  public ForwardResolution viewProductListByAdmin() {
    if (accountService.isAdmin(username)) {
      productList = catalogService.getAllProductListByAdmin();
      return new ForwardResolution(VIEW_PRODUCT_LIST_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }

  /**
   * View item.
   *
   * @return the forward resolution
   */
  public ForwardResolution viewItem() {
    item = catalogService.getItem(itemId);
    product = item.getProduct();
    return new ForwardResolution(VIEW_ITEM);
  }

  /**
   * itemList(admin)
   *
   * @return the forward resolution
   */
  public ForwardResolution viewItemListByAdmin() {
    if (productId != null && accountService.isAdmin(username)) {
      itemList = catalogService.getItemListByProduct(productId);
      product = catalogService.getProduct(productId);
      return new ForwardResolution(VIEW_ITEM_LIST_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }

  /**
   * Search products.
   *
   * @return the forward resolution
   */
  public ForwardResolution searchProducts() {
    if (keyword == null || keyword.length() < 1) {
      setMessage("Please enter a keyword to search for, then press the search button.");
      return new ForwardResolution(ERROR);
    } else {
      productList = catalogService.searchProductList(keyword.toLowerCase());
      return new ForwardResolution(SEARCH_PRODUCTS);
    }
  }

  public Resolution categoryAPI() {
    return new Resolution() {
      @Override
      public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String categoryId = httpServletRequest.getParameter("categoryId");
        if (categoryId != null) {
          productList = catalogService.getProductListByCategory(categoryId);
        }

        Gson gson = new Gson();
        String categoryJson = gson.toJson(productList);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(categoryJson);
      }
    };
  }

  /**
   * Item 삭제시 item list로 이동
   * @return
   * */
  public ForwardResolution deleteItemByAdmin() {
    if (productId != null && accountService.isAdmin(username)) {
      catalogService.deleteItemByAdmin(itemId);
      itemList = catalogService.getItemListByProduct(productId);
      product = catalogService.getProduct(productId);
      return new ForwardResolution(VIEW_ITEM_LIST_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }

  public Resolution insertItemByAdmin() {
    catalogService.insertItemByAdmin(item);
    return new RedirectResolution(CatalogActionBean.class, "viewItemListByAdmin");
  }

  public Resolution updateItemByAdmin() {
    catalogService.updateItemByAdmin(item);
    return new RedirectResolution(CatalogActionBean.class, "viewItemListByAdmin");
  }

  /**
   * Clear.
   */
  public void clear() {
    keyword = null;

    categoryId = null;
    category = null;
    categoryList = null;

    productId = null;
    product = null;
    productList = null;

    itemId = null;
    item = null;
    itemList = null;
  }

}
