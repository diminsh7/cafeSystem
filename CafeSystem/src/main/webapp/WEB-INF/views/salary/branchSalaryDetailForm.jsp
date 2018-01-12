<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<script>
	function branchSalaryBtn(btn){
		if(btn == "list"){
			$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryList');
		}
		if(btn == "update"){
			$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryUpdate?branchSalaryCode=${branchSalary.branchSalaryCode}');
		}
	}
	$(document).ready(function(){
		$('#branchSalaryDelete').click(function(){
			$.ajax({
				url:"SelectLoginInfoForDelete"
				, type:"GET"
				, data:{}
				, success:function(data){
					var loginList = []
					loginList = JSON.parse(data);	//로그인정보<직원코드, 비번>
					console.log(loginList)
					var empCode = loginList[0]	//<직원코드>
					var pw = loginList[1]		//<비번>
						if(empCode != null){
							var pw2 = prompt('暗所番号を入力して下さい。',"");
							console.log(pw2)
							if(pw == pw2){
								alert("暗証番号一致")
								$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryDelete?branchSalaryCode=${branchSalary.branchSalaryCode}');
							}else{
								alert("暗証番号不一致")
							}
						}else{
							return false;
						}
					}
				, error:function(request, status, error){
					alert('ログインをして下さい。');
				}
			});
		});
	});

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
						<h2>給与明細書詳細照会</h2>
					<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-horizontal form-label-left">
						
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">明細書コード<span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryCode" value="${branchSalary.branchSalaryCode}" 
									name="branchSalaryCode" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">伝票番号 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="statementNumber" value="${branchSalary.statementNumber}" 
									name="statementNumber"  type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="detail">社員コード <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="branchEmployeeCode"  value="${branchSalary.branchEmployeeCode}" 
									name="branchEmployeeCode"   readonly="readonly"class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">帰属年月 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id=" branchSalaryWorkmonth" value="${branchSalary.branchSalaryWorkmonth}" 
									name="branchSalaryWorkmonth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">月給 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchEmployeeSalary" value="${branchSalary.branchEmployeeSalary}" 
									name="branchEmployeeSalary" type="text" readonly="readonly"  class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">健康保険 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryHealth" value="${branchSalary.branchSalaryHealth}" 
									name="branchSalaryHealth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">雇用保険 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryInsurance" value="${branchSalary.branchSalaryInsurance}"  
									name="branchSalaryInsurance" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div> 
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">国民年金 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPersion" value="${branchSalary.branchSalaryPersion}" 
									name="branchSalaryPersion" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支払い合計 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPayments" value="${branchSalary.branchSalaryPayments}" 
									name="branchSalaryPayments" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">控除合計 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryDeduction" value="${branchSalary.branchSalaryDeduction}" 
									name="branchSalaryDeduction" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">手取り額 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryReceipts" value="${branchSalary.branchSalaryReceipts}" 
									name="branchSalaryReceipts" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">実支払い合計 <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPaydate" value="${branchSalary.branchSalaryPaydate}"  
									name="branchSalaryPaydate" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-4">
									<input type="button" class="btn btn-primary" value="List" onclick="branchSalaryBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="Modify" onclick="branchSalaryBtn('update')" name="update">
									<button class="btn btn-primary" type="button" id="branchSalaryDelete" >Delete</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->