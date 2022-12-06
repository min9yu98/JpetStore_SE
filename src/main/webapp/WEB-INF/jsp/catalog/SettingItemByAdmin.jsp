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
					<th>${actionBean.product.description}</th>
				</tr>
				<tr>
					<th>${actionBean.product.name}</th>
				</tr>
			</table>
			<br/>
			<h3>INFORMATION</h3>
			<c:choose>
<%--				아직 동물에 대한 정보가 입력되지 않은 경우--%>
				<c:when test="${actionBean.animalInfoList.isEmpty()}">
					<table>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoColumnList}">
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
							<c:forEach var="list" items="${actionBean.animalInfoColumnList}">
								<td> </td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoColumnList}">
								<td style="text-align: center">
									<stripes:link class="Button"
												  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
												  event="updateAnimalInfoValueFormByAdmin">
										<stripes:param name="productId" value="${actionBean.product.productId}" />
										<stripes:param name="categoryId" value="${actionBean.product.categoryId}" />
										<stripes:param name="columname" value="${list.columname}" />
										EDIT INFO
									</stripes:link>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="list" items="${actionBean.animalInfoColumnList}">
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
							<c:forEach var="productEnvColumnList" items="${actionBean.environmentColumnByProductList}">
								<th style="text-align: center">
										${productEnvColumnList.envColumnName}
								</th>
							</c:forEach>
						</tr>
						<c:if test="${!actionBean.environmentByProductValueisNull}">
							<tr>
								<c:forEach var="productEnvList" items="${actionBean.productEnvList}">
									<td style="text-align: center">
											${productEnvList.envItem}
									</td>
								</c:forEach>
							</tr>
						</c:if>
						<tr>
							<c:forEach var="productEnvColumnList" items="${actionBean.environmentColumnByProductList}">
								<td style="text-align: center">
									<stripes:link class="Button"
												  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
												  event="updateEnvValueFormByAdmin">
										<stripes:param name="categoryId" value="${actionBean.product.categoryId}" />
										<stripes:param name="envColumnName" value="${productEnvColumnList.envColumnName}" />
										<stripes:param name="productId" value="${actionBean.product.productId}" />
										EDIT ENV
									</stripes:link>
								</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach var="productEnvColumnList" items="${actionBean.environmentColumnByProductList}">
								<td style="text-align: center">
									<stripes:link class="Button"
												  beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
												  event="deleteEnvColumnByAdmin">
										<stripes:param name="categoryId" value="${actionBean.product.categoryId}" />
										<stripes:param name="envColumnName" value="${productEnvColumnList.envColumnName}" />
										<stripes:param name="productId" value="${actionBean.product.productId}" />
										REMOVE
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



