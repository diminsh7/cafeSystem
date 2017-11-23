<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>매장기초정보관리</h3>
				<%-- <a class="btn btn-default" href="${pageContext.request.contextPath}/shopList">매장(전체리스트)</a> --%> 
				<%-- <a class="btn btn-default" href="${pageContext.request.contextPath}/insertShop">매장(등록)</a> --%>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매장전체조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">점포명클릭-상세조회</p>

						<%-- <%@ include file="../shop/shopSearchForm.jsp"%> --%>

						<div align="right">전체행의 수 : ${shopCount}</div>
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>점포명</th>
									<th>소유자이름</th>
									<th>점포주소</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="shop" items="${list}">
									<tr>
										<td><%-- <a
											href="${pageContext.request.contextPath}/shopDetail?contractCode=${shop.contractCode}"> --%>${shop.shopName}<!-- </a> --></td>
										<td>${shop.contractOwnerName}</td>
										<td>${shop.shopAddress}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/shopList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage <= lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/shopList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
