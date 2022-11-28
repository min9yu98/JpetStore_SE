<%--
  Created by IntelliJ IDEA.
  User: gimjeong-won
  Date: 2022/11/27
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${sessionScope.accountBean != null}">
     <c:choose>
         <c:when test="${sessionScope.accountBean.authenticated}">
        <link rel="StyleSheet" href="../css/jpetstore.css" type="text/css"
              media="screen" />
        <SCRIPT LANGUAGE="JavaScript">
            function change(style) {
                if( style == "1" )
                {
                    view1.style.display = "block"
                    view1.style.display = "block"
                    view2.style.display = "none"
                    view3.style.display = "none"
                }
                if( style == "2" )
                {
                    view1.style.display = "none"
                    view2.style.display = "inline"
                    view3.style.display = "none"
                }
                if( style == "3" )
                {
                    view1.style.display = "none"
                    view2.style.display = "none"
                    view3.style.display = "none"
                }
            }
        </SCRIPT>
        <select onChange="change(this.options[this.selectedIndex].value)">
            <option>::: Catagory :::</option>
            <option value="1">Fish</option>
            <option value="2">Dog</option>
            <option value="3">Cats</option>
            <option value="4">Reptiles</option>
            <option value="5">Birds</option>
        </select>
        <table id=view1 width="500" border="0" cellpadding="0" cellspacing="0" style="display:none">
            <tr>
                <th> Species </th>
                <th> Temp </th>
                <th> PH </th>
                <th> port </th>
            </tr>
            <c:forEach var="product" items="${actionBean.productList}">
                <tr>
                    <td><stripes:link
                            beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                            event="viewProduct">
                        <stripes:param name="productId" value="${product.productId}" />
                        ${product.productId}
                    </stripes:link></td>
                    <td>${product.name}</td>
                </tr>
            </c:forEach>
        </table>
        <table id=view2 width="500" border="0" cellpadding="0" cellspacing="0" style="display:none">
            <tr>
                <td >dd</td>
                <td>22</td>
            </tr>
            <tr>
                <td >dd</td>
            </tr>
        </table>
        <table id=view3 width="500" border="0" cellpadding="0" cellspacing="0" style="display:none">
            <tr>
                <td >dd</td>
                <td>33</td>
            </tr>
            <tr>
                <td >dd</td>
            </tr>
        </table>
        </c:when>
         <c:otherwise>
             <%@ include file="../common/AccessRestriction.jsp" %>
         </c:otherwise>
    </c:choose>
    </c:when>
    <c:otherwise>
        <%@ include file="../common/AccessRestriction.jsp" %>
    </c:otherwise>
</c:choose>
<%@ include file="../common/IncludeBottom.jsp"%>
