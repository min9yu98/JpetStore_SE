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

<br>
<br>
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
							<td rowspan="2" style="text-align: center">
								<stripes:link class="Button"
											  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
											  event="insertAnimalInfoFormByAdmin" style="background-color: rgba(0,0,0,0)">
									<stripes:param name="username" value="${sessionScope.accountBean.account.username}" />
									<stripes:param name="productId" value="${products.productId}" />
									<br>
									ADD STANDARD
									<br>
								</stripes:link>
							</td>
						</tr>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoList}">
								<td style="text-align: center">
										${list.value}
								</td>
							</c:forEach>
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
										DELETE
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
							<th rowspan="3">${actionBean.productId}</th>
							<c:forEach var="productEnvList" items="${actionBean.productEnvList}">
								<th style="text-align: center">
										${productEnvList.envColumnName}
								</th>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="productEnvList" items="${actionBean.productEnvList}">
								<td style="text-align: center">
										${productEnvList.envItem}
								</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="productEnvList" items="${actionBean.productEnvList}">
								<td style="text-align: center">
									<stripes:link class="Button"
												  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
												  event="updateEnvItem">
										<stripes:param name="categoryId" value="${actionBean.product.categoryId}" />
										<stripes:param name="envColumnName" value="${productEnvList.envColumnName}" />
										<stripes:param name="envItem" value="${productEnvList.envItem}" />
										EDIT ENV
									</stripes:link>
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



