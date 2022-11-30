<%--

       Copyright 2010-2022 the original author or authors.

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

          https://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.

--%>
<%@ include file="../common/IncludeTop.jsp"%>

<jsp:useBean id="catalog"
             class="org.mybatis.jpetstore.web.actions.CatalogActionBean" />

<div id="BackLink" style="text-align: left"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
        event="viewCategory">
    <stripes:param name="categoryId"
                   value="${actionBean.product.categoryId}" />
    Return to ${actionBean.product.categoryId}
</stripes:link></div>
<br>
<c:choose>
    <c:when test="${sessionScope.accountBean.account.admin}">
        <div id="Catalog">
            <h2 style="text-align: center">${actionBean.product.name}</h2>
    <table>
        <tr>
            <th>Item ID</th>
            <th>Product ID</th>
            <th>Description</th>
            <th>List Price</th>
            <th>&nbsp;</th>
            <th> </th>
        </tr>
        <c:forEach var="itemList" items="${actionBean.itemList}">
            <tr>
                <td><stripes:link
                        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                        event="viewItemByAdmin">
                    <stripes:param name="itemId" value="${itemList.itemId}" />
                    <stripes:param name="username" value="${sessionScope.accountBean.username}" />
                    ${itemList.itemId}
                </stripes:link></td>
                <td>${itemList.product.productId}</td>
                <td>${itemList.attribute1} ${itemList.attribute2} ${itemList.attribute3}
                        ${itemList.attribute4} ${itemList.attribute5} ${actionBean.product.name}</td>
                <td><fmt:formatNumber value="${itemList.listPrice}"
                                      pattern="$#,##0.00" /></td>
                <td>
                    <stripes:link class="Button"
                                  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                                  event="updateItemFormByAdmin">
                        <stripes:param name="itemId" value="${itemList.itemId}" />
                        UPDATE
                    </stripes:link>
                </td>
                <td>
                    <stripes:link class="Button"
                                  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                                  event="deleteItemByAdmin">
                        <stripes:param name="itemId" value="${itemList.itemId}" />
                        <stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
                        DELETE
                    </stripes:link>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
            </td>
        </tr>
    </table>
    <stripes:link class="Button"
                  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                  event="newItemFormByAdmin">
        <stripes:param name="productId" value="${actionBean.product.productId}" />
        ADD
    </stripes:link>
        </div>
    </c:when>
   <c:otherwise>
       <%@ include file="../common/AccessRestriction.jsp"%>
   </c:otherwise>
</c:choose>
<%@ include file="../common/IncludeBottom.jsp"%>





