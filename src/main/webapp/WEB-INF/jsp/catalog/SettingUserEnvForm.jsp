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
        <c:forEach var="p1" items="${actionBean.productEnvValueLists}">
          <stripes:form name="test" beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
            <table>
              <tr>
                <th style="text-align: center" colspan="${p1.size()}">
                    ${p1.get(0).envColumnName}
                </th>
              </tr>
              <tr>
                <c:forEach var="p2" items="${p1}">
                  <th style="text-align: center">
                      ${p2.envValue}
                  </th>
                </c:forEach>
              </tr>
              <tr>
                <c:forEach var="p2" items="${p1}">
                  <td style="text-align: center">
                    <stripes:radio name="envValue" value="${p2.envValue}" />
                  </td>
                </c:forEach>
              </tr>
            </table>
            <stripes:param name="categoryId" value="${actionBean.categoryId}" />
            <stripes:param name="envColumnName" value="${p1.get(0).envColumnName}"/>
            <stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
            <stripes:param name="envValue" value="${envValue}" />
            <stripes:submit name="settingUserEnv" value="Submit" />
          </stripes:form>
        </c:forEach>
      <br>
      <stripes:link
              class="Button"
              beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
              event="viewCategory">
        <stripes:param name="categoryId"
                       value="${actionBean.categoryId}" />
        Complete
      </stripes:link>
    </c:if>
  </c:if>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>





