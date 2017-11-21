<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="./listContract" method="post">
	<select name="searchContractOption">
		<option value="contractOwnerName">소유자명</option>
		<option value="contractShopName">점포명</option>
		<option value="contractEndDate">계약만료일</option>
	</select>
	<input id="searchContractText" name="searchContractText" type="text">
	<input id="searchContractBtn" name="searchContractBtn" type="submit" value="검색">
</form>
