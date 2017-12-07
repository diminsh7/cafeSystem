<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<script>
	function branchSalaryBtn(btn){
		if(btn == "list"){
			result = confirm('수정을 취소하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryList');
			} else {
				
			}
		}
		if(btn == "update"){
			result = confirm('정말 수정 하시겠습니까?');
			if(result){
				$('#branchSalaryUpdateForm').submit();
			}else{
				
			}
		}
	}
	$(document).ready(function(){		
		$('#branchEmployeeSalaryChange').click(function(){
			var branchSalaryChange = $('#branchEmployeeSalary').val();
			var Health2= branchSalaryChange*0.03
			var Insurance2 = branchSalaryChange*0.0065
			var Persion2 = branchSalaryChange*0.045
			var Deduction2 = branchSalaryChange*0.03 + branchSalaryChange*0.0065 + branchSalaryChange*0.045
			var Receipts2 = branchSalaryChange-Deduction2
			if(branchSalaryChange == 'empty'){
				alert('직원코드를 선택해 주세요');
				return false;
			}else{
				$('#branchEmployeeSalary').val(branchSalaryChange);
				$('#branchSalaryHealth').val(Health2);
				$('#branchSalaryInsurance').val(Insurance2);
				$('#branchSalaryPersion').val(Persion2);
				$('#branchSalaryPayments').val(branchSalaryChange);
				$('#branchSalaryDeduction').val(Deduction2);
				$('#branchSalaryReceipts').val(Receipts2);
			}
		})
	})
</script>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>급여명세서관리</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>급여명세서 상세정보</h2>
					<div class="clearfix"></div>
					</div>
					<div class="x_content">						
						<form id="branchSalaryUpdateForm" action="${pageContext.request.contextPath}/branchSalaryUpdate" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >명세서 코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryCode" value="${branchSalary.branchSalaryCode}" name="branchSalaryCode" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >전표번호 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="statementNumber" value="${branchSalary.statementNumber}" name="statementNumber"  type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >직원코드 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="branchEmployeeCode"  value="${branchSalary.branchEmployeeCode}" name="branchEmployeeCode"   readonly="readonly"class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >귀속 년월 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id=" branchSalaryWorkmonth" value="${branchSalary.branchSalaryWorkmonth}" name="branchSalaryWorkmonth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >월급 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchEmployeeSalary" value="${branchSalary.branchEmployeeSalary}" name="branchEmployeeSalary" type="text" class="form-control col-md-7 col-xs-12" >
								</div>
								<button class="btn btn-primary" type="button" id="branchEmployeeSalaryChange" >급여 변경</button>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >건강보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryHealth" value="${branchSalary.branchSalaryHealth}" name="branchSalaryHealth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">고용보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryInsurance" value="${branchSalary.branchSalaryInsurance}"  name="branchSalaryInsurance" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div> 
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >국민연금 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPersion" value="${branchSalary.branchSalaryPersion}" name="branchSalaryPersion" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >지급합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPayments" value="${branchSalary.branchSalaryPayments}" name="branchSalaryPayments" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >공제합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryDeduction" value="${branchSalary.branchSalaryDeduction}" name="branchSalaryDeduction" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >실 수령액 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryReceipts" value="${branchSalary.branchSalaryReceipts}" name="branchSalaryReceipts" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >실 지급일자 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPaydate" value="${branchSalary.branchSalaryPaydate}"  name="branchSalaryPaydate" type="date" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<input type="button" class="btn btn-primary" value="목록" onclick="branchSalaryBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="수정완료" onclick="branchSalaryBtn('update')" name="update">
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