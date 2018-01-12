<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<script>
	function branchSalaryBtn(btn){
		if(btn == "list"){
			result = confirm('修正をキャンセルしますか？');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryList');
			} else {
				
			}
		}
		if(btn == "update"){
			result = confirm('本当に修正しますか？');
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
				alert('社員コードを選択して下さい。');
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
				<h3>給与明細書管理</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>給与明細書修正</h2>
					<div class="clearfix"></div>
					</div>
					<div class="x_content">						
						<form id="branchSalaryUpdateForm" action="${pageContext.request.contextPath}/branchSalaryUpdate" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >明細書コード<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryCode" value="${branchSalary.branchSalaryCode}" name="branchSalaryCode" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >伝票番号 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="statementNumber" value="${branchSalary.statementNumber}" name="statementNumber"  type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >社員コード <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="branchEmployeeCode"  value="${branchSalary.branchEmployeeCode}" name="branchEmployeeCode"   readonly="readonly"class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >帰属年月 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id=" branchSalaryWorkmonth" value="${branchSalary.branchSalaryWorkmonth}" name="branchSalaryWorkmonth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >月給 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchEmployeeSalary" value="${branchSalary.branchEmployeeSalary}" name="branchEmployeeSalary" type="text" class="form-control col-md-7 col-xs-12" >
								</div>
								<button class="btn btn-primary" type="button" id="branchEmployeeSalaryChange" >給与変更</button>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >健康保険 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryHealth" value="${branchSalary.branchSalaryHealth}" name="branchSalaryHealth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">雇用保険 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryInsurance" value="${branchSalary.branchSalaryInsurance}"  name="branchSalaryInsurance" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div> 
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >国民年金 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPersion" value="${branchSalary.branchSalaryPersion}" name="branchSalaryPersion" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >支払い合計 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPayments" value="${branchSalary.branchSalaryPayments}" name="branchSalaryPayments" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >控除合計 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryDeduction" value="${branchSalary.branchSalaryDeduction}" name="branchSalaryDeduction" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >手取り額 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryReceipts" value="${branchSalary.branchSalaryReceipts}" name="branchSalaryReceipts" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" >実支払い日付 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPaydate" value="${branchSalary.branchSalaryPaydate}"  name="branchSalaryPaydate" type="date" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-5">
									<input type="button" class="btn btn-primary" value="List" onclick="branchSalaryBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="Modify" onclick="branchSalaryBtn('update')" name="update">
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