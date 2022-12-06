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
<stripes:errors/>
<c:choose>
    <c:when test="${sessionScope.accountBean.account.admin}">
        <div id="Catalog"><stripes:form
                beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
            <table>
                <tr>
                    <th>Product ID</th>
                    <th>Category</th>
                    <th>Name</th>
                    <th>description</th>
                </tr>
                <tr>
                    <td><stripes:text name="product.productId" /></td>
                    <td><stripes:text name="product.categoryId" /></td>
                    <td><stripes:text name="product.name" /></td>
                    <td><stripes:text name="product.description" /></td>
                </tr>
            </table>
            <stripes:param name="item.productId" value= "${actionBean.product.productId}" />
            <stripes:submit name="insertProductByAdmin" value="Submit" /></stripes:form>
        </div>
    </c:when>
    <c:otherwise>
        <%@ include file="../common/AccessRestriction.jsp" %>
    </c:otherwise>
</c:choose>


<%@ include file="../common/IncludeBottom.jsp"%>