<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script>
	$('document').ready(function(){
		
		//급여 자동 입력
		$('#branchEmployeeSalary').click(function(){
			var branchCodeList = $('#branchEmployeeCode').val();
			if(branchCodeList == 'empty'){
				alert('직원코드를 선택해 주세요');
				return false;
			}else{
				$.ajax({
					url:"branchEmployeeSalaryInsert"
					, type:"GET"
					, data:{"branchCodeList":branchCodeList}
					, success:function(data){
						var result = JSON.parse(data);
							if(result != null){
								$('#branchEmployeeSalary').val(result);
							}else{
								alert('급여 못갖고옴');
								return false;
							}
						}
					, error:function(request, status, error){
						alert('급여 자동 등록 실패');
					}
					});
				}
		});
	});

</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>지점직원급여관리</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>지점직원급여관리<small>급여명세서 등록</small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form id="branchSalaryInsertForm" action="${pageContext.request.contextPath}/branchSalaryInsert" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="tempCate">직원코드</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control selectBox" id="branchEmployeeCode" name="branchEmployeeCode">
											<option value="empty">선택하세요</option>
											<c:forEach var="branchCodeList" items="${branchCodeList}">
												<option value="${branchCodeList}">${branchCodeList}</option>
											</c:forEach>
										 </select>
									</div>
									<button class="btn btn-primary" type="button" id="branchEmployeeSalary" >검색</button>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuCode">전표번호</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="menuCode" name="menuCode" required="required" class="form-control col-md-7 col-xs-12" readonly>
								</div>
							</div>
	                   		<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">귀속년월</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="date">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchEmployeeSalary">월급</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="branchEmployeeSalary" name="branchEmployeeSalary" required="required" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">건강보험</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">고용보험</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">국민연금</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">지급합계</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">공제합계</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">실수령액</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryPaydate">실지급일자</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPaydate" name="branchSalaryPaydate" class="form-control col-md-7 col-xs-12" type="date">
								</div>
							</div>								
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
									<button class="btn btn-primary" id="menuPriceInsertCancelBtn" type="button">Cancel</button>
									<button class="btn btn-primary" id="menuPriceInsertResetBtn" type="reset">Reset</button>
									<button class="btn btn-success" id="menuPriceInsertBtn" type="submit">등록</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>