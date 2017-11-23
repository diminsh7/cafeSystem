<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
	function claimBtn(btn){
		if(btn == "list"){
			//console.log("rollback Claim List");
			$(location).attr('href', '${pageContext.request.contextPath}/claimList');
		} 
		if(btn == "update"){
			$(location).attr('href', '${pageContext.request.contextPath}/claimUpdate?claimCode=${claim.claimCode}');
		}
		if(btn == "delete"){
			result = confirm('정말 삭제하시겠습니까?');
			if(result){
				$(location).attr('href', '${pageContext.request.contextPath}/claimDelete?claimCode=${claim.claimCode}');
			}		
		}
		if(btn == "reply"){
			
		}
	}
</script>
<div class="right_col" role="main">
	<div class="page-title">
		<div class="title_left">
			<h2>게시글 보기</h2>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<div>
					<div>
						<input type="hidden" id="employeeCode" name="employeeCode" value="${claim.employeeCode}" readonly>
						<input type="text" id="claimCategoryCode" name="claimCategoryCode" value="${claim.claimCategoryName}" readonly>
						<input type="text" id="claimTitle" name="claimTitle" value="${claim.claimTitle}" readonly>
					</div>
					<div>
						<textarea id="claimContents" name="claimContents" readonly>${claim.claimContents}</textarea>
					</div>
					<div>
						<input type="file" id="claimFile" name="claimFile" value="${claim.claimFile}">
					</div>
					<div>
						<input type="button" id="claimListBtn" value="목록" onclick="claimBtn('list')">
					<c:if test="${claim.employeeCode eq loginInfo.empCode}">	
						<input type="button" id="claimInsertBtn" value="수정" onclick="claimBtn('update')"> 
						<input type="button" id="claimDeleteBtn" value="삭제" onclick="claimBtn('delete')">
					</c:if>	
						<input type="button" id="claimReplyBtn" value="답글" onclick="claimBtn('reply')">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>