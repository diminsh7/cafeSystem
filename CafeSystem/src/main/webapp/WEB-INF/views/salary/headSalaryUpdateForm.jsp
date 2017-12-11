<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<script>
	function headSalaryBtn(btn){
		if(btn == "list"){
			result = confirm('수정을 취소하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headSalaryList');
			} else {
				
			}
		}
		if(btn == "update"){
			result = confirm('정말 수정 하시겠습니까?');
			if(result){
				$('#headSalaryUpdateForm').submit();
			}else{
				
			}
		}
	}
	$(document).ready(function(){		
		$('#headEmployeeSalaryChange').click(function(){
			var headSalaryChange = $('#headEmployeeSalary').val();
			var Health2= headSalaryChange*0.03
			var Insurance2 = headSalaryChange*0.0065
			var Persion2 = headSalaryChange*0.045
			var Deduction2 = headSalaryChange*0.03 + headSalaryChange*0.0065 + headSalaryChange*0.045
			var Receipts2 = headSalaryChange-Deduction2
			if(headSalaryChange == 'empty'){
				alert('직원코드를 선택해 주세요');
				return false;
			}else{
				$('#headEmployeeSalary').val(headSalaryChange);
				$('#headSalaryHealth').val(Health2);
				$('#headSalaryInsurance').val(Insurance2);
				$('#headSalaryPersion').val(Persion2);
				$('#headSalaryPayments').val(headSalaryChange);
				$('#headSalaryDeduction').val(Deduction2);
				$('#headSalaryReceipts').val(Receipts2);
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
						<form id="headSalaryUpdateForm" action="${pageContext.request.contextPath}/headSalaryUpdate" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >명세서 코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryCode" value="${headSalary.headSalaryCode}" name="headSalaryCode" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >직원코드 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="headEmployeeCode"  value="${headSalary.headEmployeeCode}" name="headEmployeeCode"   readonly="readonly"class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >귀속 년월 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id=" headSalaryWorkmonth" value="${headSalary.headSalaryWorkmonth}" name="headSalaryWorkmonth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >월급 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headEmployeeSalary" value="${headSalary.headEmployeeSalary}" name="headEmployeeSalary" type="text" class="form-control col-md-7 col-xs-12" >
								</div>
								<button class="btn btn-primary" type="button" id="headEmployeeSalaryChange" >급여 변경</button>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >전표번호 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryBonus" value="${headSalary.headSalaryBonus}" name="headSalaryBonus"  type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >건강보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryHealth" value="${headSalary.headSalaryHealth}" name="headSalaryHealth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">고용보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryInsurance" value="${headSalary.headSalaryInsurance}"  name="headSalaryInsurance" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div> 
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >국민연금 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPersion" value="${headSalary.headSalaryPersion}" name="headSalaryPersion" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >지급합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPayments" value="${headSalary.headSalaryPayments}" name="headSalaryPayments" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >공제합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryDeduction" value="${headSalary.headSalaryDeduction}" name="headSalaryDeduction" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >실 수령액 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryReceipts" value="${headSalary.headSalaryReceipts}" name="headSalaryReceipts" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >실 지급일자 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPaydate" value="${headSalary.headSalaryPaydate}"  name="headSalaryPaydate" type="date" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<input type="button" class="btn btn-primary" value="목록" onclick="headSalaryBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="수정완료" onclick="headSalaryBtn('update')" name="update">
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