<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점인사관리</h3>

			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>점주 인적사항 변경</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					
						<form action="./updateBranchManager" method="post"class="form-horizontal form-label-left" novalidate>
							<c:forEach var="UpDate" items="${BranchManagerUpdate}">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">직원코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeCode" id="branchEmployeeCode" value="${UpDate.branchEmployeeCode}" readonly="readonly" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">점포명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="shopName"  id="shopName" value="${UpDate.shopName}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required"  readonly="readonly">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">아이디<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeId" id="branchEmployeeId" value="${UpDate.branchEmployeeId}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">이름<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeName" id="branchEmployeeName" value="${UpDate.branchEmployeeName}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">생년월일<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input  type="text" name="branchEmployeeBirth" id="branchEmployeeBirth" value="${UpDate.branchEmployeeBirth}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">연락처<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeePhone" value="${UpDate.branchEmployeePhone}" id="branchEmployeePhone" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">주소<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeAddress" id="branchEmployeeAddress" value="${UpDate.branchEmployeeAddress}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">사업계좌은행명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchManagerBank" id="branchManagerBank" value="${UpDate.branchManagerBank}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">사업계좌<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchManagerBanknum" id="branchManagerBanknum" value="${UpDate.branchManagerBanknum}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							</c:forEach>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="update" type="submit" class="btn btn-success">수정</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>