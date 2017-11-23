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
                    <h2>지점장 등록 <small>모든 항목을 다 채워 주십시오.</small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <form id="branchManagerInsert" name="branchManagerInsert" class="form-horizontal form-label-left" action="${pageContext.request.contextPath}/insertBranchManager" method="post" novalidate >

                      <span class="section">지점장 인적사항 등록</span>
						
					  <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">지역<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <select name="localCategoryCode" id="localCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<option value='001'>서울특별시</option>
							<option value='002'>부산광역시</option>
							<option value='003'>대구광역시</option>
							<option value='004'>인천광역시</option>
							<option value='005'>대전광역시</option>
							<option value='006'>광주광역시</option>
							<option value='007'>울산광역시</option>
							<option value='008'>세종특별자치시</option>
							<option value='009'>경기도</option>
							<option value='010'>강원도</option>
							<option value='011'>충청북도</option>
							<option value='012'>충청남도</option>
							<option value='013'>전라북도</option>
							<option value='014'>전라남도</option>
							<option value='015'>경상북도</option>
							<option value='016'>경상남도</option>
							<option value='017'>제주도</option>
						</select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">매장번호 <span class="required">*</span>
                        </label>                
                        	<div class="col-md-6 col-sm-6 col-xs-12">																													
                       			<select name="shopCode" id="shopCode" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
                       				<c:forEach var="BMShopCode" items="${branchManagerShopCode}">
                       				<option>${BMShopCode.shopCode}</option>
                       				</c:forEach> 
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
                        <label for="password" class="control-label col-md-3">사업자번호<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="branchManagerWorknum" name="branchManagerWorknum" placeholder="ex)000-00-00000" data-validate-length="6,8" class="form-control col-md-7 col-xs-12" required="required">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">사업시작일<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date" id="branchManagerStart" name="branchManagerStart" data-validate-linked="password" class="form-control col-md-7 col-xs-12" required="required">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">사업계좌은행명 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <select name="branchManagerBank" id="branchManagerBank" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">사업계좌번호 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12"> 
                        <input type="text" id="branchManagerBanknum" name="branchManagerBanknum" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12"> 
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <a href="${pageContext.request.contextPath}/branchManagerList" class="btn btn-primary">취소</a>
                          <a href="${pageContext.request.contextPath}/insertformbranchManager" class="btn btn-primary">지우기</a>
                          <input type="submit" id="branchManagerInsertButton" name="branchManagerInsertButton" class="btn btn-success" value="등록">
                          
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
