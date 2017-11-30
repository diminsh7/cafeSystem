<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
$(document).ready(function(){
	$('#materialcal').click(function(){
		var itemCode = $('#itemCode').val(); //1. 아이템 코드 가져오기
		var materialMeasure = $('#materialMeasure').val();
		$.ajax({
			url : "materialCostCla" // 2. 가져온 아이템 코드를 컨트롤러 로 넘기기
			,type : 'GET' //보내는 방식 
			,data : {"itemCode" : itemCode, "materialMeasure" : materialMeasure} //내가 보내는 값			
			,success : function(data){
				var result = JSON.parse(data); //웹 서버와 데이터를 교환하는 데 주로 사용
				 if(result != 0){
					 $('#materialCost').val(result)
				 }
			}
		});
	});
});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>메뉴관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/MaterialList">원가관리목록</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertMaterial">메뉴원가등록</a>
			</div>
		</div> 
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>메뉴원가수정</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					
						<form action="./updateMaterial" method="post"class="form-horizontal form-label-left" novalidate>
							<c:forEach var="Update" items="${updateMaterial}">
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">메뉴명<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									 <select name="menuCode" id="menuCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
										<c:forEach var="ManuName" items="${ManuNameList}">
                       						<option value='${ManuName.menuCode}'<c:if test="${ManuName.menuCode == Update.menuCode}">selected="selected"</c:if>>${ManuName.menuName}</option>
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
                       						<option value='${size.sizeCategoryCode}'<c:if test="${size.sizeCategoryCode == Update.sizeCategoryCode}">selected="selected"</c:if>>${size.sizecate}</option>
                       					</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">품목상세내용<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select name="itemCode" id="itemCode" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
										<c:forEach var="item" items="${item}">
                       						<option value='${item.itemCode}'<c:if test="${item.itemCode == Update.itemCode}">selected="selected"</c:if>>${item.itemName}</option>
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
                       						<option value='${temp.tempCategoryCode}'<c:if test="${temp.tempCategoryCode == Update.tempCategoryCode}">selected="selected"</c:if>>${temp.tempcate}</option>
                       					</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">용량(ml/g)<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									 <input type="text" id="materialMeasure" name="materialMeasure" value="${Update.materialMeasure}" data-validate-linked="email" required="required" class="form-control col-md-7 col-xs-12">
                     			</div>
                     			 <button type="button" id="materialcal" class="btn btn-default">단가계산</button>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">단가<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="materialCost" name="materialCost" value="${Update.materialCost}" required="required"  class="form-control col-md-7 col-xs-12" readonly="readonly">
                      			 </div>
							</div>
							
							<input type="hidden" id="materialCode" name="materialCode" value="${Update.materialCode}" required="required"  class="form-control col-md-7 col-xs-12">
                      			
							</c:forEach>
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