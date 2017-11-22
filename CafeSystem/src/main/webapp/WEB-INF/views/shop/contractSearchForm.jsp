<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="./listContract" method="post" name="form1">
	<select name="searchOption">
		<option value="all"
			<c:out value="${map.searchOption == 'all'?'selected':''}"/>>전체</option>
		<option value="contractOwnerName"
			<c:out value="${map.searchOption == 'contractOwnerName'?'selected':''}"/>>소유자명</option>
		<option value="contractShopName"
			<c:out value="${map.searchOption == 'contractShopName'?'selected':''}"/>>점포명</option>
		<option value="contractEndDate"
			<c:out value="${map.searchOption == 'contractEndDate'?'selected':''}"/>>계약만료일</option>
	</select> <input name="keyword" value="${map.keyword}"> <input
		type="submit" value="조회">
</form>
<br>
<table id="datatable" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>계약코드</th>
			<th>소유자명</th>
			<th>점포명</th>
			<th>계약일</th>
			<th>계약만료일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contract" items="${map.list}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/contractDetail?contractCode=${contract.contractCode}">${contract.contractCode}</a></td>
				<td>${contract.contractOwnerName}</td>
				<td>${contract.contractShopName}</td>
				<td>${contract.contractStartDate}</td>
				<td>${contract.contractEndDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
