<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
--%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contract 가맹계약서 등록페이지</title>
</head>
<body>
	<form action="./insertContract" method="post">
		<table border="1">
			<!-- 
			<tr>
				<td>계약코드</td>
				<td></td>
			</tr>
			 -->
			<tr>
				<td>소유자명</td>
				<td><input type="text" name="contract_owner_name"></td>
			</tr>
			<tr>
				<td>점포명</td>
				<td><input type="text" name="contract_shop_name"></td>
			</tr>
			<tr>
				<td>소유자연락처</td>
				<td><input type="text" name="contract_owner_phone"></td>
			</tr>
			<tr>
				<td>계약일</td>
				<td><input type="text" name="contract_start_date"></td>
			</tr>
			<tr>
				<td>계약만료일</td>
				<td><input type="text" name="contract_end_date"></td>
			</tr>
			<tr>
				<td>계약서사진</td>
				<td><input type="file" name="contract_photo"></td>
			<tr>
				<td colspan="4"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>
