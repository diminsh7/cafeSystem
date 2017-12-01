<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
 
<div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3> 본사인사관리 </h3>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/">직원목록</a>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>본사 직원 등록 <small></small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <form id="materialInsert" name="materialInsert" class="form-horizontal form-label-left" action="${pageContext.request.contextPath}/insertMaterial" method="post" novalidate >

                      <span class="section">본사 직원 등록</span>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">부서코드<span class="required">*</span>
                        </label>                
                        	<div class="col-md-6 col-sm-6 col-xs-12">																													
                       			<select name="departmentCategoryCode" id="departmentCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
									<c:forEach var="temp" items="${department}">
                       					<option value='${department.departmentCategoryCode}'>${department.cateDepartment}</option>
                       				</c:forEach>
								</select>
                        	</div>                        
                      </div>
                      
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">아이디<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                            <input type="text" id="headEmployeeId" name="headEmployeeId" required="required"  class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">이름<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <input type="text" id="headEmployeeName" name="headEmployeeName" required="required"  class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                     
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">생년월일 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="text" id="headEmployeeBirth" name="headEmployeeBirth" required="required"  class="form-control col-md-7 col-xs-12" placeholder="ex)980101 -> 비밀번호로 사용됩니다.">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">전화번호 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="headEmployeePhone" name="headEmployeePhone" required="required"  class="form-control col-md-7 col-xs-12" placeholder="ex) 000-0000-0000">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">주소 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="headEmployeeAddress" name="headEmployeeAddress" required="required"  class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">입사일 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date" id="headEmployeeJoin" name="headEmployeeJoin" required="required"  class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">월급 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="headEmployeeSalary" name="headEmployeeSalary" required="required"  class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">상여금 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                      		<select name="bonusCategoryCode" id="bonusCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
								<c:forEach var="Bonus" items="${Bonus}">
                       				<option value='${Bonus.bonusCategoryCode}'>${Bonus.cateBonus}</option>
                       			</c:forEach>
							</select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">월급계좌번호 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="headEmployeeBanknum" name="headEmployeeBanknum" required="required"  class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                      </div>
                      
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">근로계약서 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="file" id="headEmployeeContract" name="headEmployeeContract" required="required"  class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <a class="btn btn-success" href="${pageContext.request.contextPath}/">목록</a>
                          <a class="btn btn-primary" href="${pageContext.request.contextPath}/" >지우기</a>
                          <input type="submit" id="InsertButton" name="InsertButton" class="btn btn-success" value="등록">
                          
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>