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
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/faultyList">불량품목(전체리스트)</a>
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
					<form action="./faultyList" method="post" name="search">
						<select name="searchOption">
							<option value="item_name"
								<c:out value="${map.searchOption == 'itemName'?'selected':''}"/>>품목명</option>
							<option value="category_small"
								<c:out value="${map.searchOption == 'categorySmall'?'selected':''}"/>>불량카테고리명</option>
						</select>
						<input name="keyword" value="${keyword}">
						<input type="submit" value="조회">
					</form>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">불량품목관리코드클릭-상세조회</p>
						<div align="right">전체행의 수 : ${faultyCount}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>불량품목관리코드</th>
									<th>불량발생전표번호</th>
									<th>품목명</th>
									<th>불량카테고리명</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="faulty" items="${faultyList}">
									<tr>
										<td><a
											href="${pageContext.request.contextPath}/faultyDetail?faultyCode=${faulty.faultyCode}">${faulty.faultyCode}</a></td>
										<td>${faulty.statementNumber}</td>
										<td>${faulty.itemName}</td>
										<td>${faulty.categorySmall}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/faultyList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/faultyList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>	
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
