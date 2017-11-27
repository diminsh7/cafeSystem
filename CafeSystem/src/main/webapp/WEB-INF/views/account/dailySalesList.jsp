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

			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
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
