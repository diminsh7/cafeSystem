<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	function claimBtn(btn){
		if(btn == "list"){
			//console.log("rollback Claim List");
			$(location).attr('href', '${pageContext.request.contextPath}/claimList');
		} 
		if(btn == "update"){
			$(location).attr('href', '${pageContext.request.contextPath}/claimUpdate?customerClaimCode=${claim.customerClaimCode}');
		}
		if(btn == "delete"){
			result = confirm('정말 삭제하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/claimDelete?customerClaimCode=${claim.customerClaimCode}');
			}		
		}
		if(btn == "reply"){
			
		}
	}
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h2>게시글 보기</h2>
			</div>
		</div>
		<div>
			<div>
				<input type="text" id="claimCategoryCode" name="claimCategoryCode" value="${claim.claimCategoryName}" readonly>
				<input type="text" id="customerClaimTitle" name="customerClaimTitle" value="${claim.customerClaimTitle}" readonly>
			</div>
			<div>
				<textarea id="customerClaimContents" name="customerClaimContents" readonly>${claim.customerClaimContents}</textarea>
			</div>
			<div>
				<input type="file" id="customerClaimFile" name="customerClaimFile" value="${claim.customerClaimFile}">
			</div>
			<div>
				<input type="button" id="claimListBtn" value="목록" onclick="claimBtn('list')">
				<input type="button" id="claimInsertBtn" value="수정" onclick="claimBtn('update')"> 
				<input type="button" id="claimDeleteBtn" value="삭제" onclick="claimBtn('delete')">
				<input type="button" id="claimReplyBtn" value="답글" onclick="claimBtn('reply')">
			</div>
		</div>
	</div>
</div>