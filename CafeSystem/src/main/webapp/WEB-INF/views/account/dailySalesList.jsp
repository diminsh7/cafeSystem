<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					매출 <small>Sales</small>
				</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							일 매출 조회 <small>Daily Sales</small>
						</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-group" style="float: right;">
							<form action="${pageContext.request.contextPath}/dailySalesSearch" method="get">
								<select class="input-sm" style="float: left;">
									<option value="">dd</option>
									<option value="">ff</option>
								</select>
								<input type="search" name="search" class="input-sm" style="text-align: center; float: left;" placeholder="검색어 입력" aria-controls="datatable">
								&nbsp; &nbsp;
								<button type="submit" class="btn btn-primary btn-sm" id="loginButton" style="float: right; padding: 0.75mm 1.2mm 0.75mm 1.2mm;"> 검색 </button>
							</form>
						</div>
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>일매출 관리코드</th>
									<th>전표번호</th>
									<th>지역코드</th>
									<th>매장코드</th>
									<th>날짜</th>
									<th>일매출액</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${fn:length(dailySalesList) > 0}">
										<c:forEach items="${dailySalesList}" var="resultList">
											<tr>
												<th><a href="#">${resultList.dailySalesCode}</a></th>
												<th><a href="#">${resultList.statementNum}</a></th>
												<td>${resultList.localCode}</td>
												<td>${resultList.shopCode}</td>
												<td>${resultList.dailySalesDate}</td>
												<td>${resultList.dailySalesAmount}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="3">조회된 결과가 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
