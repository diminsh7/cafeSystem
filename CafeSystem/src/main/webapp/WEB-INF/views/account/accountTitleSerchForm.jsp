<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/accountTitleList">
	<select name="searchOption">
	    <!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
	<option value="all" <c:out value="${searchOption == 'all'?'selected':''}"/> >계정과목명+내용</option>
	<option value="account_title_name" 
		<c:out value="${searchOption == 'account_title_name'?'selected':''}"/> >계정과목명</option>
	<option value="account_title_content" 
		<c:out value="${searchOption == 'account_title_content'?'selected':''}"/> >내용</option>
	</select>
	<input name="keyword" value="${keyword}">
	<input type="submit" value="조회">
	<button type="button" id="btnWrite">글쓰기</button>
	</form>
<!-- 레코드의 갯수를 출력 -->
${count}개의 게시물이 있습니다.
	<table id="datatable" class="table table-striped table-bordered">
		<tr>
			<th>계정과목코드</th>
			<th>계정과목명</th>
			<th>상세내용</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	<c:forEach var="map" items="${alist}">
		<tr>
			<td>${map.accountTitleCode}</td>
			<td>${map.accountTitleName}</td>
			<td>${map.accountTitleContent}</td>
			<td><a id="accountTitleUpdateButton" 
				href ="${pageContext.request.contextPath}/accountTitleUpdateForm?accountTitleCode=${accountTitle.accountTitleCode}">
				수정</a>
			</td>
			<td><a  onclick="button_event()" id="accountTitleDeleteButton" 
				href ="${pageContext.request.contextPath}/accountTitleDelete?accountTitleCode=${accountTitle.accountTitleCode}">
				삭제</a>
			</td>
		</tr>    
	</c:forEach>
	</table>