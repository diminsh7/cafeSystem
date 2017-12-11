<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<script>
	function headSalaryBtn(btn){
		if(btn == "list"){
			$(location).attr('href', '${pageContext.request.contextPath}/headSalaryList');
		}
		if(btn == "update"){
			$(location).attr('href', '${pageContext.request.contextPath}/headSalaryUpdate?headSalaryCode=${headSalary.headSalaryCode}');
		}
		/* if(btn == "delete"){
			result = confirm('정말 삭제하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/headSalaryDelete?headSalaryCode=${headSalary.headSalaryCode}');
			}	
		} */
	}
	
	$(document).ready(function(){
		$('#headSalaryDelete').click(function(){
			$.ajax({
				url:"getLoginInfoForDelete"
				, type:"GET"
				, data:{}
				, success:function(data){
					var loginList = []
					loginList = JSON.parse(data);	//로그인정보<직원코드, 비번>
					console.log(loginList)
					var empCode = loginList[0]	//<직원코드>
					var pw = loginList[1]		//<비번>
						if(empCode != null){
							var pw2 = prompt('삭제하시려면 비밀번호를 입력해 주세요',"");
							console.log(pw2)
							if(pw == pw2){
								alert("비번일치")
								$(location).attr('href', '${pageContext.request.contextPath}/headSalaryDelete?headSalaryCode=${headSalary.headSalaryCode}');
							}else{
								alert("비번불일치")
							}
						}else{
							return false;
						}
					}
				, error:function(request, status, error){
					alert('삭제실패');
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
									<input id="headSalaryCode" value="${headSalary.headSalaryCode}" name="headSalaryCode" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="detail">직원코드 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="headEmployeeCode"  value="${headSalary.headEmployeeCode}" name="headEmployeeCode"   readonly="readonly"class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">귀속 년월 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id=" headSalaryWorkmonth" value="${headSalary.headSalaryWorkmonth}" name="headSalaryWorkmonth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">월급 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headEmployeeSalary" value="${headSalary.headEmployeeSalary}" name="headEmployeeSalary" type="text" readonly="readonly"  class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">상여금 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryBonus" value="${headSalary.headSalaryBonus}" name="headSalaryBonus"  type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">건강보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryHealth" value="${headSalary.headSalaryHealth}" name="headSalaryHealth" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">고용보험 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryInsurance" value="${headSalary.headSalaryInsurance}"  name="headSalaryInsurance" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12" >
								</div> 
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">국민연금 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPersion" value="${headSalary.headSalaryPersion}" name="headSalaryPersion" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">지급합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPayments" value="${headSalary.headSalaryPayments}" name="headSalaryPayments" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">공제합계 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryDeduction" value="${headSalary.headSalaryDeduction}" name="headSalaryDeduction" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">실 수령액 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryReceipts" value="${headSalary.headSalaryReceipts}" name="headSalaryReceipts" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">실 지급일자 <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPaydate" value="${headSalary.headSalaryPaydate}"  name="headSalaryPaydate" type="text" readonly="readonly" class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<input type="button" class="btn btn-primary" value="목록" onclick="headSalaryBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="수정" onclick="headSalaryBtn('update')" name="update">
									<button class="btn btn-primary" type="button" id="headSalaryDelete" >삭제</button>
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