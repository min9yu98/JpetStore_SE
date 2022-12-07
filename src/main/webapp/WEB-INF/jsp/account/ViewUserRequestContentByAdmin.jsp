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
             class="org.mybatis.jpetstore.web.actions.AccountActionBean"/>
<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"
        event="viewUserRequestListByAdmin">
    <stripes:param name="username" value="${sessionScope.accountBean.username}" />
    Return Back

    <link rel="StyleSheet" href="../css/bootstrap.css">
</stripes:link></div>
<br>
<br>
<c:choose>
    <c:when test="${sessionScope.accountBean.account.admin}">
        <div id="Catalog" class="container">

            <table class="tableboot table-striped" style="text-align: left;">
                <tr style="background-color: #aaaaaa">
                    <th>Writer</th>
                    <th>Parent Category</th>
                    <th>SubCategory</th>
                    <th style ="width:15%; ">Writing Date</th>
                </tr>
                <tr>
                    <td>
                            ${actionBean.writer}
                    </td>
                    <td>
                            ${actionBean.account.parentCategory}
                    </td>
                    <td>
                            ${actionBean.account.subCategory}
                    </td>
                    <td>
                            ${actionBean.account.writingDate}
                    </td>
                </tr>
            </table>
            <table class="tableboot table-striped" style="text-align: left;">
                <tr>
                    <th style="background-color: #aaaaaa">

                       Title
                    </th>
                </tr>
                <tr>
                    <td>
                            ${actionBean.account.title}
                    </td>
                </tr>
            </table>
            <table class="table table-striped" style="text-align: left;">
                <tr style="background-color: #aaaaaa">
                    <th>content</th>
                </tr>
                <tr>
                    <td>${actionBean.content}</td>
                </tr>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <%@ include file="../common/AccessRestriction.jsp"%>
    </c:otherwise>
</c:choose>


<%@ include file="../common/IncludeBottom.jsp"%>
