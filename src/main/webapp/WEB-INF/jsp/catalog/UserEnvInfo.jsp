<%--&lt;%&ndash;--%>

<%--       Copyright 2010-2022 the original author or authors.--%>

<%--       Licensed under the Apache License, Version 2.0 (the "License");--%>
<%--       you may not use this file except in compliance with the License.--%>
<%--       You may obtain a copy of the License at--%>

<%--          https://www.apache.org/licenses/LICENSE-2.0--%>

<%--       Unless required by applicable law or agreed to in writing, software--%>
<%--       distributed under the License is distributed on an "AS IS" BASIS,--%>
<%--       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.--%>
<%--       See the License for the specific language governing permissions and--%>
<%--       limitations under the License.--%>

<%--&ndash;%&gt;--%>
<%--<%@ include file="../common/IncludeTop.jsp"%>--%>

<%--<div id="Catalog">--%>
<%--  <table style="margin: auto; text-align: center">--%>
<%--    <tr>--%>
<%--      <c:forEach var="list" items="${actionBean.animalInfoList}">--%>
<%--        <th style="text-align: center">--%>
<%--            ${list.columname}--%>
<%--        </th>--%>
<%--      </c:forEach>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--      <c:forEach var="list" items="${actionBean.animalInfoList}">--%>
<%--        <td style="text-align: center">--%>
<%--            ${list.value}--%>
<%--        </td>--%>
<%--      </c:forEach>--%>
<%--    </tr>--%>
<%--  </table>--%>

<%--  <c:if test="${sessionScope.accountBean != null}">--%>
<%--    <c:if test="${sessionScope.accountBean.authenticated}">--%>
<%--      <h3>MY ${actionBean.categoryId} ENVIRONMENT</h3>--%>
<%--      <table>--%>
<%--        <tr>--%>
<%--          <c:forEach var="productEnvList" items="${actionBean.productEnvList}">--%>
<%--            <th style="text-align: center">--%>
<%--                ${productEnvList.envColumnName}--%>
<%--            </th>--%>
<%--          </c:forEach>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <c:forEach var="userEnvList" items="${actionBean.userEnvList}">--%>
<%--            <th style="text-align: center">--%>
<%--                ${userEnvList.envItem}--%>
<%--            </th>--%>
<%--          </c:forEach>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <c:forEach var="productEnvList" items="${actionBean.productEnvList}">--%>
<%--            <td>--%>
<%--              <stripes:param name="envColumnName" value="productEnvList.envColumnName" />--%>
<%--              <stripes:link class="Button"--%>
<%--                            beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"--%>
<%--                            event="updateUserEnvValueForm">--%>
<%--                <stripes:param name="productId" value="${actionBean.product.productId}" />--%>
<%--                <stripes:param name="categoryId" value="${actionBean.product.categoryId}" />--%>
<%--                <stripes:param name="animalInfo" value="${actionBean.animalInfo}" />--%>
<%--                <stripes:param name="columname" value="${list.columname}" />--%>
<%--                <stripes:param name="username" value="${sessionScope.accountBean.account.username}" />--%>
<%--                UPDATE VALUE--%>
<%--              </stripes:link>--%>
<%--            </td>--%>
<%--          </c:forEach>--%>
<%--        </tr>--%>
<%--      </table>--%>
<%--    </c:if>--%>
<%--  </c:if>--%>
<%--</div>--%>

<%--<%@ include file="../common/IncludeBottom.jsp"%>--%>

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

<div id="Catalog">
  <c:if test="${sessionScope.accountBean != null}">
    <c:if test="${sessionScope.accountBean.authenticated}">
      <c:forEach var="productEnvList" items="${actionBean.productEnvList}">
        <h1>${productEnvList.envColumnName}</h1>
        <c:forEach var="list1" items="${actionBean.productEnvValueLists}" begin="0" end="${actionBean.cnt}">
          <c:forEach var="list2" items="${list1}" begin="0" end="${actionBean.cnt2}">
            ${list2.envItem}
          </c:forEach>
        </c:forEach>
      </c:forEach>
    </c:if>
  </c:if>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>





