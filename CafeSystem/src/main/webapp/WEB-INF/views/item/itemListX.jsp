<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주품목관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/itemList">발주품목(전체리스트)</a>
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertItem">발주품목(등록)</a>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/itemListX">발주품목(금지리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주품목금지전체조회</h2>
						<div class="clearfix"></div>
					</div>
					<form action="./itemListX" method="post" name="searchX">
					</form>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">품목코드클릭-상세조회</p>
						<div align="right">전체행의 수 : ${itemCountX}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>품목코드</th>
									<th>품목카테고리명</th>
									<th>품목명</th>
									<th>품목가격</th>
									<th>품목이미지</th>
									<th>발주가능여부</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${itemListX}">
									<tr>
										<td><a
											href="${pageContext.request.contextPath}/itemDetail?itemCode=${item.itemCode}">${item.itemCode}</a></td>
										<td>${item.categorySmall}</td>
										<td>${item.itemName}</td>
										<td>${item.itemPrice}</td>
										<td>${item.itemImage}</td>
										<td>${item.itemAble}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/itemListX?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/itemListX?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
