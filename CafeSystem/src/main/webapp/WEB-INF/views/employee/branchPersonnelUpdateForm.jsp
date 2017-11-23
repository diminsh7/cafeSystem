<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/branchPersonnelList">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertformbranchPersonneel">점주등록</a>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>직원 인적사항 변경</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					
						<form action="./updateBranchPersonnel" method="post"class="form-horizontal form-label-left" novalidate>
							<c:forEach var="branchPersonnelUpdate" items="${branchPersonnelUpdate}">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">직원코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeCode" id="branchEmployeeCode" value="${branchPersonnelUpdate.branchEmployeeCode}" readonly="readonly" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">직급<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="shopName"  id="shopName" value="${branchPersonnelUpdate.categorySmall}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" required="required">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">아이디<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeId" id="branchEmployeeId" value="${branchPersonnelUpdate.branchEmployeeId}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">이름<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeName" id="branchEmployeeName" value="${branchPersonnelUpdate.branchEmployeeName}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">생년월일<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input  type="text" name="branchEmployeeBirth" id="branchEmployeeBirth" value="${branchPersonnelUpdate.branchEmployeeBirth}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">연락처<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeePhone" value="${branchPersonnelUpdate.branchEmployeePhone}" id="branchEmployeePhone" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">주소<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchEmployeeAddress" id="branchEmployeeAddress" value="${branchPersonnelUpdate.branchEmployeeAddress}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">월급<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchPersonnelSalary" id="branchPersonnelSalary" value="${branchPersonnelUpdate.branchPersonnelSalary}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">월급계좌은행명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchPersonnelBank" id="branchPersonnelBank" value="${branchPersonnelUpdate.branchPersonnelBank}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">월급계좌번호<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="branchPersonnelBanknum" id="branchPersonnelBanknum" value="${branchPersonnelUpdate.branchPersonnelBanknum}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
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