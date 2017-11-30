<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>발주관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/">발주신청</a>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>발주신청상세내역조회 <small></small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30"></p>
						상내역리스트
			
						<table id="datatable" class="table table-striped table-bordered">
								<tr>
									<th>전표번호</th>
									<td>1<td>
									<th>구분</th>
									<td>2<td>
								</tr>
								<tr>
									<th>품목명</th>
									<td>1<td>
									<th>수량</th>
									<td>2<td>
									<th>가격</th>
									<td>3<td>
									<th>발주금액</th>
									<td>4<td>
								</tr>
								<tr>
									<th>현 접수상태</th>	
									<td>1<td>						
									<th>배송상태</th>
									<td>2<td>						
									<th>신청일</th>
									<td>3<td>							
									<th>승인일</th>
									<td>4<td>							
									<th>출고일</th>
									<td>5<td>							
								</tr>
								<tr>
									<th>승인 담당자</th>
									<td>1<td>			
									<th>불량여부</th>
									<td>2<td>	
								</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
