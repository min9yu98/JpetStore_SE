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

<div id="Catalog"><stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"
        focus="">

    <h3>User Request</h3>
    <table>
        <tr>
            <td>User ID</td>
            <td>${actionBean.username}</td>
        </tr>
        <tr>
            <td>PARENT CATEGORY</td>
            <td>
                <stripes:select name="account.parentCategory">
                    <stripes:options-collection collection="${actionBean.requestParentCategory}" />
                </stripes:select></td>
        </tr>
        <tr>
            <td>SUBCATEGORY</td>
            <td><stripes:select name="account.subCategory">
                <stripes:options-collection collection="${actionBean.requestSubCategory}" />
            </stripes:select></td>
        </tr>
    </table>
    <div>
        <h3>Title</h3>
        <stripes:textarea cols="30" name="account.title"/>
    </div>
    <div>
        <h3>Content</h3>
        <stripes:textarea cols="30" rows="20" name="account.content"/>
    </div>
    <br>
    <stripes:param name="username" value="${actionBean.username}" />
    <stripes:submit name="insertRequestByUser" value="Submit" />
</stripes:form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>