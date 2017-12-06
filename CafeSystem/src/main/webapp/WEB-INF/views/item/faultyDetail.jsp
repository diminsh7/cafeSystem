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
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-6 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>불량품목상세조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal form-label-left">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">불량품목관리코드</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="form-control">${faulty.faultyCode}</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">불량발생전표번호</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="form-control">${faulty.statementNumber}</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">품목명</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="form-control">${faulty.itemName}</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">불량카테고리명</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="form-control">${faulty.categorySmall}</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">불량수량</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="form-control">${faulty.faultyAmount}</div>
								</div>
							</div>
							<%-- <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">불량이미지</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${faulty.faultyImage}</div>
									</div>
								</div> --%>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">불량상세사유</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<div class="form-control">${faulty.faultyReason}</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
