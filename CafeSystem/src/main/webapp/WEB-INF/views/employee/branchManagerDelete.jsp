<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchManagerList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertformbranchManager">점주등록</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">ㄴ
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>점주삭제</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./deleteContract" method="post" class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">직원코드<span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" value="${code.branchEmployeeCode}" id="branchEmployeeCode" name="branchEmployeeCode" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" readonly="readonly" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">생년월일<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="contractOwnerName" name="contractOwnerName" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="deleteButton" type="submit" class="btn btn-success">삭제</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>