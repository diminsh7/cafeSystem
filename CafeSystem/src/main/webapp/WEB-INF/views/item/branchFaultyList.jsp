<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>불량품목관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/branchFaultyList">불량품목(지점리스트)</a>
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertFaulty">불량품목(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>불량품목전체조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30"></p>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>불량품목관리코드</th>
									<th>불량발생전표번호</th>
									<th>품목명</th>
									<th>불량카테고리명</th>
									<th>불량수량</th>
									<!-- <th>불량이미지</th> -->
									<th>불량상세사유</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="faulty" items="${faultyList}">
									<tr>
										<td>${faulty.faultyCode}</td>
										<td>${faulty.statementNumber}</td>
										<td>${faulty.itemName}</td>
										<td>${faulty.categorySmall}</td>
										<td>${faulty.faultyAmount}</td>
										<%-- <td>${faulty.faultyImage}</td> --%>
										<td>${faulty.faultyReason}</td>
										<td><a class="btn btn-warning" href="${pageContext.request.contextPath}/updateFaulty?faultyCode=${faulty.faultyCode}">수정</a><td>
										<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteFaulty?faultyCode=${faulty.faultyCode}">삭제</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
