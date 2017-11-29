<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script>
	$(document).ready(function(){
		$('#menuNameSearch').click(function(){
			var menuName = $('#menuName').val();
			var tempCate = $('#tempCate').val();
			var sizeCate = $('#sizeCate').val();
			
			if(menuName == 'empty' || tempCate == 'empty' || sizeCate == 'empty'){
				alert('카테고리를 선택해주세요');
				return false;
			} else {		
				$.ajax({ //메뉴 코드 자동 등록
					url:"menuCodeInsert"
					, type:'GET'
					, data:{"menuName":menuName}
					, success:function(data){
						var result = JSON.parse(data);
							if(result != null){
								$('#menuCode').val(result);
							} else {								
								alert('일치하는 메뉴명이 없습니다');
								return false;
							}
					}
					, error:function(request, status, error){
						alert('메뉴 코드 자동 등록 실패');
					}
				});
				
				$.ajax({ //메뉴 원가 자동 등록
					url:"materialInsert"
					, type:'GET'
					, data:{"menuName":menuName,"tempCate":tempCate,"sizeCate":sizeCate}
					, success:function(data){
						var result = JSON.parse(data);
						if(result != 0){
							$('#menuTotalCost').val(result);
						} else {
							alert('메뉴명과 일치하는 정보를 찾을 수 없습니다');
							$('#menuTotalCost').val("");
							return false;
						}
					}
					, error:function(request, status, error){
						alert('메뉴 원가 자동 등록 실패');
					}
				});
			}
		});
	});
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>Menu Price Manager</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Menu Price Manager<small>Menu Price Insert</small></h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form id="menuPriceInsertForm" action="${pageContext.request.contextPath}/menuPriceInsert" method="post" data-parsley-validate class="form-horizontal form-label-left">
							<!-- <div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuName">Menu Name</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="menuName" name="menuName" required="required" class="form-control col-md-7 col-xs-12">
								</div>
							</div> -->
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="tempCate">Menu Name</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select class="form-control" id="menuName" name="menuName">
											<option value="empty">선택하세요</option>
											<c:forEach var="menuNameList" items="${menuNameList}">
												<option value="${menuNameList}">${menuNameList}</option>
											</c:forEach>
										 </select>
									</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuCode">Menu Code</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="menuCode" name="menuCode" required="required" class="form-control col-md-7 col-xs-12" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="tempCate">Hot/Ice</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control" id="tempCate" name="tempCategory">
										<option value="empty">선택하세요</option>
										<c:forEach var="cateList" items="${cateList}">
											<c:if test="${cateList.categoryMiddle eq 'Temp'}">
												<option value="${cateList.categoryCode}">${cateList.categorySmall}</option>
											</c:if>
										</c:forEach>
									 </select>
								</div>
	                      	</div>
	                      	<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="sizeCate">Size</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select class="form-control" id="sizeCate" name="sizeCategory">
										<option value="empty">선택하세요</option>
										<c:forEach var="cateList" items="${cateList}">
											<c:if test="${cateList.categoryMiddle eq 'Size'}">
												<option value="${cateList.categoryCode}">${cateList.categorySmall}</option>
											</c:if>
										</c:forEach>
									 </select>
								</div>
								<button type="button" id="menuNameSearch">입력</button>
	                      	</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuTotalCost">Material Total Cost</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="menuTotalCost" name="menuTotalCost" required="required" class="form-control col-md-7 col-xs-12" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12" for="menuSellCost">Menu Sell Cost</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="menuSellCost" name="menuSellCost" class="form-control col-md-7 col-xs-12" type="text">
								</div>
							</div>							
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
									<button class="btn btn-primary" type="button">취소</button>
									<button class="btn btn-primary" type="reset">Reset</button>
									<button type="submit" class="btn btn-success">등록</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>