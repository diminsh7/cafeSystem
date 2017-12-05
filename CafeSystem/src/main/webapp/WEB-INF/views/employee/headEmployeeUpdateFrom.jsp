<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>본사인사관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertFormHeadEmployee">목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/headEmployeeList">점주등록</a>
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
					
						<form action="./headEmployeeUpdate" method="post"class="form-horizontal form-label-left" novalidate>

							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">직원코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeeCode" id="headEmployeeCode" value="${headEmployeeUpdate.headEmployeeCode}" readonly="readonly" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">부서명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									 <select name="departmentCategoryCode" id="departmentCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
										<c:forEach var="department" items="${department}">
                       						<option value='${department.departmentCategoryCode}'<c:if test="${department.departmentCategoryCode == headEmployeeUpdate.departmentCategoryCode}">selected="selected"</c:if>>${department.cateDepartment}</option>
                       					</c:forEach>
                       				</select>
                       			</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">아이디<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeeId" id="headEmployeeId" value="${headEmployeeUpdate.headEmployeeId}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">이름<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeeName" id="headEmployeeName" value="${headEmployeeUpdate.headEmployeeName}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
						
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">연락처<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeePhone" id="headEmployeePhone" value="${headEmployeeUpdate.headEmployeePhone}"  class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2"required="required" >
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">주소<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeeAddress" id="headEmployeeAddress" value="${headEmployeeUpdate.headEmployeeAddress}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">월급<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeeSalary" id="headEmployeeSalary" value="${headEmployeeUpdate.headEmployeeSalary}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">상여금<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select name="bonusCategoryCode" id="bonusCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
										<c:forEach var="Bonus" items="${Bonus}">
                       						<option value='${Bonus.bonusCategoryCode}'<c:if test="${Bonus.bonusCategoryCode == headEmployeeUpdate.bonusCategoryCode}">selected="selected"</c:if>>${Bonus.cateBonus}</option>
                       					</c:forEach>
                       				</select>
                       			</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">계좌번호<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" name="headEmployeeBanknum" id="headEmployeeBanknum" value="${headEmployeeUpdate.headEmployeeBanknum}" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
								</div>
							</div>
						
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