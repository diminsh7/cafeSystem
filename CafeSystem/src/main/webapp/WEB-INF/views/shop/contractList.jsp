<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%request.setCharacterEncoding("utf-8");%>

	<table border = "1">
		<tr>
			<th>계약코드</th>
			<th>소유자명</th>
			<th>점포명</th>
			<th>소유자연락처</th>
			<th>계약일</th>
			<th>계약만료일</th>
			<th>계약서사진</th>
			<th>상세</th>
		</tr>
		<c:forEach var="contract" items="${clist}">
			<tr>
				<td>${contract.contractCode}</td>
				<td>${contract.contractOwnerName}</td>
				<td>${contract.contractShopName}</td>
				<td>${contract.contractOwnerPhone}</td>
				<td>${contract.contractStartDate}</td>
				<td>${contract.contractEndDate}</td>
				<td>${contract.contractPhoto}</td>
				<!-- 수정해야함 -->
				<td><a href="<%=request.getContextPath()%>/Glist/g_detail.go?sendGcode=${contract.contractCode}">상세</a></td>
			</tr>	
		</c:forEach>
	</table>
