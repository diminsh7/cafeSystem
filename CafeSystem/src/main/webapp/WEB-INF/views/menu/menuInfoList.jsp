<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>메뉴관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/menuInfoList">메뉴(전체리스트)</a>
				<a class="btn btn-success" href="${pageContext.request.contextPath}/insertMenuInfo">메뉴(등록)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴전체조회</h2>
						<div class="clearfix"></div>
					</div>
					<form action="./menuInfoList" method="post" name="search">
						<select name="searchOption">
							<option value="category_small"
								<c:out value="${map.searchOption == 'categorySmall'?'selected':''}"/>>메뉴카테고리명</option>
							<option value="menu_name"
								<c:out value="${map.searchOption == 'menuName'?'selected':''}"/>>메뉴명</option>
						</select>
						<input name="keyword" value="${keyword}">
						<input type="submit" value="조회">
					</form>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">메뉴코드클릭-상세조회</p>
						<div align="right">전체행의 수 : ${menuInfoCount}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>메뉴코드</th>
									<th>메뉴카테고리명</th>
									<th>메뉴명</th>
									<th>출시일</th>
									<!-- <th>메뉴이미지</th> -->
								</tr>
							</thead>
							<tbody>
								<c:forEach var="menuInfo" items="${menuInfoList}">
									<tr>
										<td><a
											href="${pageContext.request.contextPath}/menuInfoDetail?menuCode=${menuInfo.menuCode}">${menuInfo.menuCode}</a></td>
										<td>${menuInfo.categorySmall}</td>
										<td>${menuInfo.menuName}</td>
										<td>${menuInfo.menuStart}</td>
										<%-- <td>${menuInfo.menuImage}</td> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/menuInfoList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/menuInfoList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
