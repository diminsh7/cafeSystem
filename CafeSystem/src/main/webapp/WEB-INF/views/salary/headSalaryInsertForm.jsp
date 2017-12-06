<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<script>
	$(document).ready(function(){
		//급여 자동 입력
		$('#headEmployeeSalarySearch').click(function(){
			var headCodeList = $('#headEmployeeCode').val();
			
			if(headCodeList == 'empty'){
				alert('직원코드를 선택해 주세요');
				return false;
			}else{
				$.ajax({
					url:"headEmployeeSalaryInsert"
					, type:"GET"
					, data:{"headCodeList":headCodeList}
					, success:function(data){
						var salaryList = [];
						salaryList = JSON.parse(data);	//급여와 상여율
						console.log(salaryList)
						var salary = salaryList[0];	//급여
						var bonusper = salaryList[1];//상여율
						var bonus = (salary*bonusper*0.01)/12//상여금
						var health= salary*0.03			//건강보험
						var insurance = salary*0.0065	//고용보험
						var persion = salary*0.045		//국민연금
						var deduction = salary*0.03 + salary*0.0065 + salary*0.045//공제합계
						var receipts = salary-deduction+bonus	//실수령액
							if(salary != null){
								$('#headEmployeeSalary').val(salary);
								$('#headSalaryBonus').val(bonus);
								$('#headSalaryHealth').val(health);
								$('#headSalaryInsurance').val(insurance);
								$('#headSalaryPersion').val(persion);
								$('#headSalaryPayments').val(salary);
								$('#headSalaryDeduction').val(deduction);
								$('#headSalaryReceipts').val(receipts);
								
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
		$('#headEmployeeSalaryChange').click(function(){
			var headSalaryChange = $('#headEmployeeSalary').val();//급여
				
			var bonus2 = $('#headSalaryBonus').val();	//상여금
			console.log(bonus2)
			var health2= headSalaryChange*0.03	//건강보험
			var insurance2 = headSalaryChange*0.0065	//고용보험
			var persion2 = headSalaryChange*0.045	//국민연금
			var deduction2 = headSalaryChange*0.03 + headSalaryChange*0.0065 + headSalaryChange*0.045 //공제합계
			var receipts2 =  bonus2 - deduction2 + headSalaryChange	//실수령액
			if(headSalaryChange == 'empty'){
				alert('직원코드를 선택해 주세요');
				return false;
			}else{
				$('#headEmployeeSalary').val(headSalaryChange);
				$('#headSalaryHealth').val(health2);
				$('#headSalaryInsurance').val(insurance2);
				$('#headSalaryPersion').val(persion2);
				$('#headSalaryPayments').val(headSalaryChange);
				$('#headSalaryDeduction').val(deduction2);
				$('#headSalaryReceipts').val(receipts2);
			}
		})		
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
						<form id="headSalaryInsertForm" action="${pageContext.request.contextPath}/headSalaryInsert" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="tempCate">직원코드</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control selectBox" id="headEmployeeCode" name="headEmployeeCode">
											<option value="empty">선택하세요</option>
											<c:forEach var="headCodeList" items="${headCodeList}">
												<option value="${headCodeList}">${headCodeList}</option>
											</c:forEach>
										 </select>
									</div>
									<button class="btn btn-primary" type="button" id="headEmployeeSalarySearch" >검색</button>
							</div>
	                   		<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryWorkmonth" required="required">귀속년월</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryWorkmonth" name="headSalaryWorkmonth" class="form-control col-md-7 col-xs-12" type="month">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headEmployeeSalary">월급</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="headEmployeeSalary" name="headEmployeeSalary" required="required" class="form-control col-md-7 col-xs-12" >
								</div>
								<button class="btn btn-primary" type="button" id="headEmployeeSalaryChange" >급여 변경</button>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryBonus">상여금</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryBonus" name="headSalaryBonus" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryHealth">건강보험</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryHealth" name="headSalaryHealth" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryInsurance">고용보험</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryInsurance" name="headSalaryInsurance" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryPersion">국민연금</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPersion" name="headSalaryPersion" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryPayments">지급합계</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPayments" name="headSalaryPayments" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryDeduction">공제합계</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryDeduction" name="headSalaryDeduction" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryReceipts" readonly>실수령액</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryReceipts" name="headSalaryReceipts" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="headSalaryPaydate" required="required">실지급일자</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="headSalaryPaydate" name="headSalaryPaydate" class="form-control col-md-7 col-xs-12" type="date">
								</div>
							</div>								
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
									<button class="btn btn-primary" id="headSalaryInsertCancelBtn" type="button">Cancel</button>
									<button class="btn btn-primary" id="headSalaryInsertResetBtn" type="reset">Reset</button>
									<button class="btn btn-success" id="headSalaryInsertBtn" type="submit">등록</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>