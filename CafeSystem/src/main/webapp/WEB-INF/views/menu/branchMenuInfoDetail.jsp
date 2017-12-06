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
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/branchMenuInfoList">메뉴(전체리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>메뉴코드</th>
									<th>메뉴카테고리명</th>
									<th>메뉴명</th>
									<th>출시일</th>
									<!-- <th>메뉴이미지</th>
									<th>레시피이미지</th> -->
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${menuInfo.menuCode}</td>
									<td>${menuInfo.categorySmall}</td>
									<td>${menuInfo.menuName}</td>
									<td>${menuInfo.menuStart}</td>
									<%-- <td>${menuInfo.menuImage}</td>
									<td>${menuInfo.menuRecipe}</td> --%>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
