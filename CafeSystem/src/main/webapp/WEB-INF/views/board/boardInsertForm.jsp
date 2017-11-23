<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<form id="boardInsertForm" action="${pageContext.request.contextPath}/boardInsert" method="post">
	<div class="right_col" role="main">
		<div class="">
			<div class="page-title">
				<div class="title_left">
					<h3>boardInsertForm</h3>
				</div>
			</div>
		</div>
<%-- 		<div>
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
			<input type="button" id="claimListBtn" value="목록" onclick="claimBtn('list')">
			<input type="button" id="claimInsertBtn" value="등록" onclick="claimBtn('insert')">
		</div> --%>
	</div>
</form>