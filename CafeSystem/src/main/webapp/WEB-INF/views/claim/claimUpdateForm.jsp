<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function claimBtn(btn){
		if(btn == 'cancel'){
			//console.log("rollback Claim List");
			result = confirm('수정을 취소하시겠습니까?');
			if(result){
				//$(location).attr('href', '${pageContext.request.contextPath}/claimList');
				history.go(-1);
			} else {
				
			}		
		} 
		if(btn == 'update'){
			//console.log("Claim Insert Action");
			result = confirm('수정하시겠습니까?');
			if(result){
				$('#claimUpdateForm').submit();
			} else {
				
			}
		}
	}
</script>
<form id="claimUpdateForm" action="${pageContext.request.contextPath}/claimUpdate" method="post">
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h2>게시글 보기</h2>
				</div>
			</div>
			<div>
				<div>
					<input type="hidden" id="customerClaimCode" name="customerClaimCode" value="${claim.customerClaimCode}"><!-- 수정 후 바로 상세페이지로 가기 위한 변수  -->
					<select id="claimCategoryCode" name="claimCategoryCode">
					<c:forEach var="category" items="${claimCategory}">
						<option value="${category.categoryCode}">${category.categorySmall}</option>
					</c:forEach>
				</select>
					<input type="text" id="customerClaimTitle" name="customerClaimTitle" value="${claim.customerClaimTitle}">
				</div>
				<div>
					<textarea id="customerClaimContents" name="customerClaimContents">${claim.customerClaimContents}</textarea>
				</div>
				<div>
					<input type="file" id="customerClaimFile" name="customerClaimFile" value="${claim.customerClaimFile}">
				</div>
				<div>
					<input type="button" id="claimListBtn" value="취소" onclick="claimBtn('cancel')">
					<input type="button" id="claimInsertBtn" value="수정" onclick="claimBtn('update')"> 
				</div>
			</div>
		</div>
	</div>
</form>