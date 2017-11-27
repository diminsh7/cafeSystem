<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<form action="./shopSearch" method="post" name="form1">
	<select name="searchOption">
		<option value="shop_name"
			<c:out value="${map.searchOption == 'shopName'?'selected':''}"/>>점포명</option>
		<option value="contract_owner_name"
			<c:out value="${map.searchOption == 'contractOwnerName'?'selected':''}"/>>소유자명</option>
		<option value="shop_address"
			<c:out value="${map.searchOption == 'shopAddress'?'selected':''}"/>>점포주소</option>
	</select> 
	<input name="keyword" value="${map.keyword}">
	<input type="submit" value="조회">
</form>
<br>
<table id="datatable" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>계약코드</th>
			<th>점포명</th>
			<th>소유자명</th>
			<th>점포주소</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="shop" items="${map.list}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/shopDetail?contractCode=${shop.contractCode}">${shop.contractCode}</a></td>
				<td>${shop.shopName}</td>
				<td>${shop.contractOwnerName}</td>
				<td>${shop.shopAddress}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- /page content -->
