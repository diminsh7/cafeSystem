<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function claimBtn(btn){
		if(btn == 'cancel'){
			result = confirm('답글 작성을 취소하시겠습니까?');
			if(result){
				history.go(-1);
			}
		} 
		if(btn == 'insert'){
			//console.log("Claim Insert Action");
			result = confirm('등록하시겠습니까?');
			if(result){
				$('#claimReplyInsertForm').submit();
			}
		}
	}
</script>
<form id="claimReplyInsertForm" action="${pageContext.request.contextPath}/claimReply" method="post">
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
						<!-- 답글 입력 처리를 위한 매개변수 -->
						<input type="hidden" name="claimCode" value="${claim.claimCode}">
						<input type="hidden" name="claimReRef" value="${claim.claimReRef}">
						<input type="hidden" name="claimReLev" value="${claim.claimReLev}">
						<input type="hidden" name="claimReSeq" value="${claim.claimReSeq}">
						<!-- 글 작성자 등록을 위한 직원 코드 -->
						<input type="hidden" name="employeeCode" value="${loginInfo.empCode}">
						<input type="hidden" name="claimCategoryCode" value="${claim.claimCategoryCode}">
						<input type="text" id="claimCategoryName" name="claimCategoryName" value="${claim.claimCategoryName}" readonly>
						<input type="text" id="claimTitle" name="claimTitle" value="re: ${claim.claimTitle}">
					</div>
					<div>
						<textarea id="claimContents" name="claimContents"></textarea>
					</div>
					<div>
						<input type="file" id="claimFile" name="claimFile">
					</div>
					<div>
						<input type="button" id="claimReplyCancelBtn" value="취소" onclick="claimBtn('cancel')">
						<input type="button" id="claimReplyInsertBtn" value="등록" onclick="claimBtn('insert')">
					</div>
				</div>
			</div>
		</div>
	</div>
</form>