<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script>
function branchSalaryInsertBtn(btn){
	if(btn == "list"){
		result = confirm('登録をキャンセルしますか？');
		if(result){
			$(location).attr('href', '${pageContext.request.contextPath}/branchSalaryList');
		}else{
			
		}
	}
	if(btn == "insert"){
		result = confirm('登録しますか?');
		if(result){
			$('#branchSalaryInsertForm').submit();
		}else{
			
		}
	}
}
	$(document).ready(function(){		
		//급여 자동 입력
		$('#branchEmployeeSalarySearch').click(function(){
			var branchCodeList = $('#branchEmployeeCode').val();
			
			if(branchCodeList == 'empty'){
				alert('社員コードを選んでください');
				return false;
			}else{
				$.ajax({
					url:"branchEmployeeSalaryInsert"
					, type:"GET"
					, data:{"branchCodeList":branchCodeList}
					, success:function(data){
						var Salary = JSON.parse(data);	//급여
						var Health= Salary*0.03			//건강보험
						var Insurance = Salary*0.0065	//고용보험
						var Persion = Salary*0.045		//국민연금
						var Deduction = Salary*0.03 + Salary*0.0065 + Salary*0.045//공제합계
						var Receipts = Salary-Deduction	//실수령액
							if(Salary != null){
								$('#branchEmployeeSalary').val(Salary);
								$('#branchSalaryHealth').val(Health);
								$('#branchSalaryInsurance').val(Insurance);
								$('#branchSalaryPersion').val(Persion);
								$('#branchSalaryPayments').val(Salary);
								$('#branchSalaryDeduction').val(Deduction);
								$('#branchSalaryReceipts').val(Receipts);
								
							}else{
								alert('照会エラーが発生しました！\n情報をご確認して下さい。');
								return false;
							}
						}
					, error:function(request, status, error){
						alert('登録エラー発生！\n入力情報をご確認して下さい。');
					}
					});
				}
		});
		//급여변경등록버튼
		$('#branchEmployeeSalaryChange').click(function(){
			var branchSalaryChange = $('#branchEmployeeSalary').val();
			var Health2= branchSalaryChange*0.03
			var Insurance2 = branchSalaryChange*0.0065
			var Persion2 = branchSalaryChange*0.045
			var Deduction2 = branchSalaryChange*0.03 + branchSalaryChange*0.0065 + branchSalaryChange*0.045
			var Receipts2 = branchSalaryChange-Deduction2
			if(branchSalaryChange == 'empty'){
				alert('社員コードを入力して下さい。');
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

	});
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>支店社員給与管理</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>給与明細書登録</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form id="branchSalaryInsertForm" action="${pageContext.request.contextPath}/branchSalaryInsert" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="tempCate">社員コード</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control selectBox" id="branchEmployeeCode" name="branchEmployeeCode">
										<option value="empty">選択して下さい</option>
										<c:forEach var="branchCodeList" items="${branchCodeList}">
											<option value="${branchCodeList}">${branchCodeList}</option>
										</c:forEach>
									 </select>
								</div>
								<button class="btn btn-primary" type="button" id="branchEmployeeSalarySearch" >検索</button>
							</div>
	                   		<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryWorkmonth" required="required">帰属年月</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryWorkmonth" name="branchSalaryWorkmonth" class="form-control col-md-7 col-xs-12" type="month">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchEmployeeSalary">月給</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="branchEmployeeSalary" name="branchEmployeeSalary" required="required" class="form-control col-md-7 col-xs-12" >
								</div>
								<button class="btn btn-primary" type="button" id="branchEmployeeSalaryChange" >給与変更</button>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryHealth">健康保険</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryHealth" name="branchSalaryHealth" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryInsurance">雇用保険</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryInsurance" name="branchSalaryInsurance" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryPersion">国民年金</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPersion" name="branchSalaryPersion" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryPayments">支払い合計</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPayments" name="branchSalaryPayments" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryDeduction">控除合計</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryDeduction" name="branchSalaryDeduction" class="form-control col-md-7 col-xs-12" type="text" readonly>
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryReceipts">手取り額</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryReceipts" name="branchSalaryReceipts" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>	
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="branchSalaryPaydate" required="required">実支払い日付</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="branchSalaryPaydate" name="branchSalaryPaydate" class="form-control col-md-7 col-xs-12" type="date">
								</div>
							</div>								
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-4">
									<input type="button" class="btn btn-primary" value="リスト" onclick="branchSalaryInsertBtn('list')" name="list">
									<input type="button" class="btn btn-success" value="登録" onclick="branchSalaryInsertBtn('insert')" name="insert">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>