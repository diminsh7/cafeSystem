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
		if(btn == "delete"){
			result = confirm('정말 삭제하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryDelete?branchSalaryCode=${branchSalary.branchSalaryCode}');
			}	
		}
	}
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
						<div class="form-horizontal form-label-left">
						
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">명세서 코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryCode" value="${branchSalary.branchSalaryCode}" name="branchSalaryCode" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">전표번호 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="statementNumber" value="${branchSalary.statementNumber}" name="statementNumber"  type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="detail">직원코드 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="branchEmployeeCode"  value="${branchSalary.branchEmployeeCode}" name="branchEmployeeCode"   readonly="readonly"class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">귀속 년월 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id=" branchSalaryWorkmonth" value="${branchSalary.branchSalaryWorkmonth}" name="branchSalaryWorkmonth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">월급 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchEmployeeSalary" value="${branchSalary.branchEmployeeSalary}" name="branchEmployeeSalary" type="text" readonly="readonly"  class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">건강보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryHealth" value="${branchSalary.branchSalaryHealth}" name="branchSalaryHealth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">고용보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryInsurance" value="${branchSalary.branchSalaryInsurance}"  name="branchSalaryInsurance" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div> 
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">국민연금 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPersion" value="${branchSalary.branchSalaryPersion}" name="branchSalaryPersion" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">지급합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPayments" value="${branchSalary.branchSalaryPayments}" name="branchSalaryPayments" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">공제합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryDeduction" value="${branchSalary.branchSalaryDeduction}" name="branchSalaryDeduction" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">실 수령액 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryReceipts" value="${branchSalary.branchSalaryReceipts}" name="branchSalaryReceipts" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">실 지급일자 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPaydate" value="${branchSalary.branchSalaryPaydate}"  name="branchSalaryPaydate" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<input type="button" class="btn btn-primary" value="목록" onclick="branchSalaryBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="수정" onclick="branchSalaryBtn('update')" name="update">
									<input type="button" class="btn btn-primary" value="삭제" onclick="branchSalaryBtn('delete')" name="delete">
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