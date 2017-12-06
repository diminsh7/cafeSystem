<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>불량품목관리</h3>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/branchFaultyList">불량품목(지점리스트)</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>불량품목수정</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./updateFaulty" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">불량품목관리코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="faultyCode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="faultyCode" required="required" type="text"
										value="${faulty.faultyCode}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">불량발생전표번호<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="statementNumber"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="statementNumber" required="required" type="text"
										value="${faulty.statementNumber}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">품목명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="itemName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="itemName" required="required" type="text"
										value="${faulty.itemName}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">불량카테고리명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="categorySmall"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="categorySmall" required="required" type="text"
										value="${faulty.categorySmall}" readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">불량수량<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="faultyAmount"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="faultyAmount" required="required" type="text"
										value="${faulty.faultyAmount}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">불량이미지<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="faultyImage"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="faultyImage" required="required" type="file"
										value="${faulty.faultyImage}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">불량상세사유<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="faultyReason" class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="faultyReason" required="required" type="text"
										value="${faulty.faultyReason}">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="send" type="submit" class="btn btn-warning">수정</button>
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
