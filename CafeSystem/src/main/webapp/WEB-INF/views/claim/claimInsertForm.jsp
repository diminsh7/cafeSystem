<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function claimBtn(btn){
		if(btn == 'list'){
			//console.log("rollback Claim List");
			result = confirm('작성을 취소하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/claimList');
			} else {
				
			}
		} 
		if(btn == 'insert'){
			//console.log("Claim Insert Action");
			result = confirm('등록하시겠습니까?');
			if(result){
				$('#claimInsertForm').submit();
			} else {
				
			}
		}
	}
</script>
<form id="claimInsertForm" action="${pageContext.request.contextPath}/claimInsert" method="post">
	<div class="right_col" role="main">
		<div class="page-title">
			<div class="title_left">
				<h3>Claim Insert Form</h3>
			</div>
		</div>	
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">		
					<div>
						<input type="hidden" id="employeeCode" name="employeeCode" value="${loginInfo.empCode}" readonly>
						<select id="claimCategoryCode" name="claimCategoryCode">
							<c:forEach var="category" items="${claimCategory}">
								<option value="${category.categoryCode}">${category.categorySmall}</option>
							</c:forEach>
						</select>
						<input type="text" id="customerClaimTitle" name="customerClaimTitle">
					</div>
					<div>
						<textarea id="customerClaimContents" name="customerClaimContents"></textarea>
					</div>
					<div>
						<input type="file" id="customerClaimFile" name="customerClaimFile">
					</div>
					<div>
						<input type="button" id="claimListBtn" value="목록" onclick="claimBtn('list')">
						<input type="button" id="claimInsertBtn" value="등록" onclick="claimBtn('insert')">
					</div>
				</div>
			</div>
		</div>
	</div>
</form>