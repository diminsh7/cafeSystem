<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
<form action="./listContract" method="post">
	<select name="searchContractOption">
		<option value="contractOwnerName">소유자명</option>
		<option value="contractShopName">점포명</option>
		<option value="contractEndDate">계약만료일</option>
	</select>
	<input id="searchContractText" name="searchContractText" type="text">
	<input type="submit" value="검색">
</form>
 -->
 <!-- 
<c:choose>
	<c:when test="${con != null}">
		<input type="hidden" id="con" value="${con}">
		<input type="hidden" id="consearch" value="${consearch}">
	</c:when>
	<c:otherwise>
		<form action="listContract" method="post" class="form-horizontal">
			<select name="con" id="con" required class="consearch-sm">
				<option id="opt" value="${con}" class="consearch-sm">검색 조건 선택</option>
				<option value="contractOwnerName" class="consearch-sm">소유자명</option>
				<option value="contractShopName" class="consearch-sm">점포명</option>
				<option value="contractEndDate" class="consearch-sm">계약만료일</option>
			</select> <input type="text" name="consearch" id="consearch" value="${consearch}" required class="consearch"> 
			<input type="submit" value="검색" class="btn-default btn-sm">
		</form>
	</c:otherwise>
</c:choose>
 -->
