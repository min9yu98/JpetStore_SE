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
			 class="org.mybatis.jpetstore.web.actions.CatalogActionBean"/>
<div id="BackLink"><stripes:link
	beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
	event="viewProduct">
	<stripes:param name="productId" value="${actionBean.product.productId}" />
	Return to ${actionBean.product.productId}
</stripes:link></div>
<br>
<br>
<c:choose>
	<c:when test="${sessionScope.accountBean.account.admin}">
		<div id="Catalog">
			<table>
				<tr>
					<td>${actionBean.product.description}</td>
				</tr>
				<tr>
					<td>${actionBean.product.name}</td>
				</tr>
			</table>
			<br/>
			<h3>INFORMATION</h3>
			<c:choose>
				<c:when test="${actionBean.animalInfoList.isEmpty()}">
					<p style="color: deeppink">We're getting ready. We're sorry for the inconvenience..</p>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoList}">
								<th style="text-align: center">
										${list.columname}
								</th>
							</c:forEach>
							<th style="text-align: center">
								<stripes:link class="Button"
											  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
											  event="insertAnimalInfoFormByAdmin" style="background-color: rgba(0,0,0,0)">
									<stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
									<stripes:param name="productId" value="${products.productId}" />
									ADD STANDARD
								</stripes:link>
							</th>
						</tr>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoList}">
								<td style="text-align: center">
										${list.value}
								</td>
							</c:forEach>
							<td style="text-align: center">
								<stripes:link class="Button"
											  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
											  event="insertAnimalInfoFormByAdmin" style="background-color: rgba(0,0,0,0)">
									<stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
									<stripes:param name="productId" value="${products.productId}" />
									ADD VALUE
								</stripes:link>
							</td>
						</tr>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoList}">
								<td style="text-align: center">
									<stripes:link class="Button"
												  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
												  event="updateAnimalInfoValueFormByAdmin">
										<stripes:param name="productId" value="${list.productId}" />
										<stripes:param name="categoryId" value="${list.categoryId}" />
										<stripes:param name="columname" value="${list.columname}" />
										EDIT INFO
									</stripes:link>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoList}">
								<td style="text-align: center">
									<stripes:link class="Button"
												  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
												  event="deleteAnimalInfoByAdmin" style="background-color: rgba(0,0,0,0)">
										<stripes:param name="productId" value="${actionBean.product.productId}" />
										<stripes:param name="categoryId" value="${actionBean.product.categoryId}" />
										<stripes:param name="animalInfo" value="${actionBean.animalInfo}" />
										<stripes:param name="columname" value="${list.columname}" />
										<stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
										DELETE STANDARD
									</stripes:link>
								</td>
							</c:forEach>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			<br/>
			<c:if test="${sessionScope.accountBean != null}">
				<c:if test="${sessionScope.accountBean.authenticated}">
					<h3>ENVIRONMENT</h3>
					<table>
						<tr>
							<th></th>
							<c:forEach var="productEnvList" items="${actionBean.productEnvList}">
								<th style="text-align: center">
										${productEnvList.envColumnName}
								</th>
							</c:forEach>
						</tr>
						<tr>
							<th>${actionBean.productId}</th>
							<c:forEach var="productEnvList" items="${actionBean.productEnvList}">
								<td style="text-align: center">
										${productEnvList.envItem}
								</td>
							</c:forEach>
						</tr>
						<tr>
							<th>EDIT ITEM</th>
							<c:forEach var="productEnvList" items="${actionBean.productEnvList}" varStatus="loop">
								<td style="text-align: center">
									<stripes:select name="productEnvList[${loop.index}].envItem">
										<stripes:options-collection collection="${productEnvList}" value="$productEnvList.envItem}" />
									</stripes:select>
								</td>
							</c:forEach>
						</tr>
					</table>
				</c:if>
			</c:if>
		</div>
	</c:when>
	<c:otherwise>
		<%@ include file="../common/AccessRestriction.jsp"%>
	</c:otherwise>
</c:choose>

<%@ include file="../common/IncludeBottom.jsp"%>



