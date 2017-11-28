<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3> 지점 인사 관리 </h3>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>지점 직원 등록 <small>모든 항목을 다 채워 주십시오.</small></h2>
                  
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <form id="branchPersonnelInsert" name="branchPersonnelInsert" class="form-horizontal form-label-left" action="${pageContext.request.contextPath}/insertBranchPersonnel" method="post" novalidate >

                      <span class="section">지점 직원 인적사항 등록</span>
						
					  <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">지역<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <select name="localCategoryCode" id="localCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<c:forEach var="BPlocal" items="${localList}">
                       			<option value='${BPlocal.categoryCode}'>${BPlocal.categorySmall}</option>
                       		</c:forEach>
						</select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">매장번호 <span class="required">*</span>
                        </label>                
                        	<div class="col-md-6 col-sm-6 col-xs-12">																													
                       			<select name="shopCode" id="shopCode" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
                       				<c:forEach var="BPShopCode" items="${branchShopCode}">
                       				<option>${BPShopCode.shopCode}</option>
                       				</c:forEach> 
                       			</select>
                        	</div>                        
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">직급<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <select name="positionCategoryCode" id="positionCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<option value='202'>매니져</option>
							<option value='203'>직원</option>
						</select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">아이디 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">																										<!-- 입력이 꼭 필요 하다. -->						
                          <input type="text" id="branchEmployeeId" name="branchEmployeeId" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" required="required" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">이름 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="branchEmployeeName" name="branchEmployeeName" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">생년월일 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="branchEmployeeBirth" name="branchEmployeeBirth" data-validate-linked="email" placeholder="ex)980101 비밀번호로 사용됩니다." required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">연락처 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="branchEmployeePhone" name="branchEmployeePhone" required="required" placeholder="ex)010-1234-1234" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="website">주소  <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="branchEmployeeAddress" name="branchEmployeeAddress" required="required"  class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">보건증 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input  type="file" id="branchEmployeeCetificate" name="branchEmployeeCetificate" data-validate-length-range="5,20" class="optional form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label for="password" class="control-label col-md-3">입사일<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date" id="branchPersonnelJoin" name="branchPersonnelJoin" placeholder="ex)000-00-00000" data-validate-length="6,8" class="form-control col-md-7 col-xs-12" required="required">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">월급<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="branchPersonnelSalary" name="branchPersonnelSalary" data-validate-linked="password" class="form-control col-md-7 col-xs-12" required="required">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">월급계좌은행명 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <select name="branchPersonnelBank" id="branchPersonnelBank" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<option>우리</option>
							<option>국민</option>
							<option>신한</option>
							<option>하나</option>
							<option>카카오</option>
							<option>신한</option>
							<option>외한은행</option>
							<option>SC은행</option>
							<option>KDB산업은행</option>
						</select>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">월급계좌번호 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12"> 
                        <input type="text" id="branchPersonnelBanknum" name="branchPersonnelBanknum" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12"> 
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">근로계약서 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input  type="file" id="branchPersonnelContract" name="branchPersonnelContract" data-validate-length-range="5,20" class="optional form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <a class="btn btn-default" href="${pageContext.request.contextPath}/branchPersonnelList">목록</a>
                          <a href="${pageContext.request.contextPath}/insertformbranchPersonneel" class="btn btn-primary">지우기</a>
                          <input type="submit" id="branchPersonnelInsertButton" name="branchPersonnelInsertButton" class="btn btn-success" value="등록">
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
		</div>