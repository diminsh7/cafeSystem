<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<form action="./branchCallSearch" method="post" name="form1">
	<select name="searchOption">
		<option value="all" <c:out value="${searchOption == 'all'?'selected':''}"/> >점포명+점포주소</option>
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
			<th>소유자명</th>
			<th>점포명</th>
			<th>점포주소</th>
			<th>점포연락처</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="shop" items="${map.list}">
			<tr>
				<td>${shop.contractOwnerName}</td>
				<td>${shop.shopName}</td>
				<td>${contract.shopAddress}</td>
				<td>${contract.shopCall}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- /page content -->
