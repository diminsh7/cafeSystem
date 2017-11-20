<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function claimBtn(num){
		if(num == 1){
			console.log("rollback Claim List");
			$(location).attr('href', '${pageContext.request.contextPath}/claimList');
		} 
		if(num == 2){
			console.log("Claim Insert Action");
			$('#claimInsertForm').submit();
		}
	}
</script>
<form id="claimInsertForm" action="${pageContext.request.contextPath}/claimInsert" method="post">
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>Claim Insert Form</h3>
				</div>
			</div>
		</div>
		<div>
			<select id="claimCategoryCode" name="claimCategoryCode">
				<c:forEach var="category" items="${categoryList}">
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
			<input type="button" id="claimListBtn" value="목록" onclick="claimBtn(1)">
			<input type="button" id="claimInsertBtn" value="등록" onclick="claimBtn(2)">
			<input type="button" id="claimReplyBtn" value="답글" onclick="claimBtn(3)">
		</div>
	</div>
</form>