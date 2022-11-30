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
            <h2 style="text-align: center">${actionBean.product.name}</h2>
            <table>
                <tr>
                    <th>New Standard</th>
                </tr>
                <tr>
                    <%@ page session="true" pageEncoding="UTF-8"%>
                    <td><stripes:text name="animalInfo.columname" /></td>
                </tr>
            </table>
            <stripes:param name="productId" value= "${actionBean.product.productId}" />
            <stripes:param name="categoryId" value="${actionBean.product.categoryId}" />
            <stripes:submit name="insertAnimalInfoByAdmin" value="Submit" /></stripes:form>
        </div>
    </c:when>
    <c:otherwise>
        <%@ include file="../common/AccessRestriction.jsp" %>
    </c:otherwise>
</c:choose>


<%@ include file="../common/IncludeBottom.jsp"%>