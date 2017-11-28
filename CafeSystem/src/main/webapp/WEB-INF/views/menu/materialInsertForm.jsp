<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3> 메뉴관리 </h3>
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>메뉴 원가 관리 <small></small></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <form id="materialInsert" name="materialInsert" class="form-horizontal form-label-left" action="${pageContext.request.contextPath}/insertMaterial" method="post" novalidate >

                      <span class="section">메뉴 원가 등록</span>
					
					  <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">메뉴명<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <select name="menuCode" id="menuCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<c:forEach var="ManuName" items="${ManuNameList}">
                       			<option value='${ManuName.menuCode}'>${ManuName.menuName}</option>
                       		</c:forEach>
						</select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Hot/Ice<span class="required">*</span>
                        </label>                
                        	<div class="col-md-6 col-sm-6 col-xs-12">																													
                       			<select name="tempCategoryCode" id="tempCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
									<c:forEach var="temp" items="${Temp}">
                       			<option value='${temp.tempCategoryCode}'>${temp.tempcate}</option>
                       		</c:forEach>
						</select>
                        	</div>                        
                      </div>
                      
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">사이즈<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <select name="sizeCategoryCode" id="sizeCategoryCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<c:forEach var="size" items="${Size}">
                       			<option value='${size.sizeCategoryCode}'>${size.sizecate}</option>
                       		</c:forEach>
						</select>
                        </div>
                      </div>
                      
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">상세품목내용<span class="required">*</span>
                        </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">																														
                           <select name="itemCode" id="itemCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
							<c:forEach var="item" items="${item}">
                       			<option value='${item.itemCode}'>${item.itemName}</option>
                       		</c:forEach>
						</select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">용량(ml/g) <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="materialMeasure" name="materialMeasure" data-validate-linked="email" placeholder="ml,g 단위로 적어주세요." required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      
                      <!-- 원가 구하기 버튼 클릭 추가하기 -->
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">단가 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="materialCost" name="materialCost" required="required"  class="form-control col-md-7 col-xs-12" placeholder="먼저는 아무거나 치고 넘어가기 /원가계산버튼 만들기">
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