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

import org.mybatis.jpetstore.domain.*;
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
  private static final String VIEW_USER_TABLE="/WEB-INF/jsp/catalog/UserTable.jsp";
  public static final String ACCESS_RESTRICTION = "/WEB-INF/jsp/common/AccessRestriction.jsp";
  private static final String UPDATE_ITEM_ADMIN = "/WEB-INF/jsp/catalog/UpdateItemFormByAdmin.jsp";
  private static final String SETTING_ITEM_BY_ADMIN = "/WEB-INF/jsp/catalog/SettingByAdmin.jsp";
  private static final String VIEW_ITEM_BY_ADMIN = "/WEB-INF/jsp/catalog/SettingItemByAdmin.jsp";
  private static final String UPDATE_ANIMAL_INFO_BY_ADMIN = "/WEB-INF/jsp/catalog/UpdateAnimalInfoFormByAdmin.jsp";
  private static final String INSERT_ANIMAL_INFO_BY_ADMIN = "/WEB-INF/jsp/catalog/InsertAnimalInfoByAdmin.jsp";
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

  private String columname;
  private String value;
  private AnimalInfo animalInfo;
  private List<AnimalInfo> animalInfoList;
  private String itemId;
  private Item item;
  private List<Item> itemList;
  private String username;
  private String envColumnName;
  private String envItem;
  private int animalinfovalueId;
  private int columnId;
  private EnvironmentByUser environmentByUser;
  private EnvironmentByProduct environmentByProduct;
  private List<EnvironmentByUser> userEnvList;
  private List<EnvironmentByProduct> productEnvList;

  public int getAnimalinfovalueId() {
    return animalinfovalueId;
  }
  public void setAnimalinfovalueId(int animalinfovalueId) {
    this.animalinfovalueId = animalinfovalueId;
  }

  public EnvironmentByProduct getEnvironmentByProduct() {
    return environmentByProduct;
  }

  public void setEnvironmentByProduct(EnvironmentByProduct environmentByProduct) {
    this.environmentByProduct = environmentByProduct;
  }

  public EnvironmentByUser getEnvironmentByUser() {
    return environmentByUser;
  }

  public void setEnvironmentByUser(EnvironmentByUser environmentByUser) {
    this.environmentByUser = environmentByUser;
  }

  public List<EnvironmentByProduct> getProductEnvList() {
    return productEnvList;
  }

  public void setProductEnvList(List<EnvironmentByProduct> productEnvList) {
    this.productEnvList = productEnvList;
  }

  public List<EnvironmentByUser> getUserEnvList() {
    return userEnvList;
  }

  public void setUserEnvList(List<EnvironmentByUser> userEnvList) {
    this.userEnvList = userEnvList;
  }

  public String getEnvColumnName() {
    return envColumnName;
  }

  public void setEnvColumnName(String envColumnName) {
    this.envColumnName = envColumnName;
  }

  public String getEnvItem() {
    return envItem;
  }

  public void setEnvItem(String envItem) {
    this.envItem = envItem;
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

  public String getColumname() {
    return columname;
  }

  public void setColumname(String columname) {
    this.columname = columname;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public AnimalInfo getAnimalInfo() {
    return animalInfo;
  }

  public void setAnimalInfo(AnimalInfo animalInfo) {
    this.animalInfo = animalInfo;
  }

  public List<AnimalInfo> getAnimalInfoList() {
    return animalInfoList;
  }

  public void setAnimalInfoList(List<AnimalInfo> animalInfoList) {
    this.animalInfoList = animalInfoList;
  }

  public List<ProductEnvItemList> getProductEnvItemList() {
    catalogService.getProductEnvItemList();
  }

  @DefaultHandler
  public ForwardResolution viewMain() {
    return new ForwardResolution(MAIN);
  }

  public Resolution newItemFormByAdmin() {
    clearForAddByAdmin();
    return new ForwardResolution(NEW_ITEM_ADMIN);
  }

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
  public ForwardResolution viewUserTable()
  {
    return new ForwardResolution(VIEW_USER_TABLE);
  }
  /**
   * View item.
   *
   * @return the forward resolution
   */
  public ForwardResolution viewItem() {
    item = catalogService.getItem(itemId);
    product = item.getProduct();
    categoryId = product.getCategoryId();
    animalInfoList = catalogService.getAnimalInfo(categoryId, productId);
    productEnvList = catalogService.getProductEnvList(categoryId, productId);
    userEnvList = catalogService.getUserEnvList(categoryId, username);
    return new ForwardResolution(VIEW_ITEM);
  }

  public ForwardResolution viewItemByAdmin() {
    if (accountService.isAdmin(username)) {
      product = catalogService.getProduct(productId);
      animalInfoList = catalogService.getAnimalInfo(categoryId, productId);
      productEnvList = catalogService.getProductEnvList(categoryId, productId);
      return new ForwardResolution(VIEW_ITEM_BY_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }

  public Resolution updateAnimalInfoValueByAdmin() {
    animalinfovalueId = catalogService.getAnimalInfoValueId(categoryId, productId, columname);
    animalInfo.setAnimalinfovalueId(animalinfovalueId);
    catalogService.updateAnimalInfoValueByAdmin(animalInfo);
    return new RedirectResolution(CatalogActionBean.class, "viewItemByAdmin");
  }

  public Resolution updateAnimalInfoValueFormByAdmin() {
    animalInfoList = catalogService.getAnimalInfo(categoryId, productId);

    HttpSession session = context.getRequest().getSession();
    session.setAttribute("catalogBean", this);
    CatalogActionBean catalogActionBean = (CatalogActionBean) session.getAttribute("/actions/Catalog.action");
    if (catalogActionBean == null) {
      return new RedirectResolution(ACCESS_RESTRICTION);
    } else {
      return new ForwardResolution(UPDATE_ANIMAL_INFO_BY_ADMIN);
    }
  }

  public Resolution insertAnimalInfoFormByAdmin() {
    return new ForwardResolution(INSERT_ANIMAL_INFO_BY_ADMIN);
  }

  public Resolution insertAnimalInfoByAdmin() {
    if (accountService.isAdmin(username)) {
      catalogService.insertAnimalInfoByAdmin(animalInfo);
      return new RedirectResolution(CatalogActionBean.class, "viewItemByAdmin");
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }

  public ForwardResolution deleteAnimalInfoByAdmin() {
    if (accountService.isAdmin(username)) {
      columnId = catalogService.getAnimalInfoColumnId(columname);
      animalInfo.setColumnId(columnId);
      catalogService.deleteAnimalInfoByAdmin(productId, categoryId, columnId);

      itemList = catalogService.getItemListByProduct(productId);
      product = catalogService.getProduct(productId);
      return new ForwardResolution(VIEW_ITEM_BY_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }
  /**
   * itemList(admin)
   *
   * @return the forward resolution
   */
  public ForwardResolution viewAdminTable()
  {
    if (accountService.isAdmin(username)) {
      productList = catalogService.getAllProductListByAdmin();
      return new ForwardResolution(SETTING_ITEM_BY_ADMIN);
    } else {
      return new ForwardResolution(ACCESS_RESTRICTION);
    }
  }
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

  public void clearForAddByAdmin() {
    keyword = null;

    categoryId = null;
    category = null;
    categoryList = null;

    itemId = null;
    item = null;
    itemList = null;
  }

}
