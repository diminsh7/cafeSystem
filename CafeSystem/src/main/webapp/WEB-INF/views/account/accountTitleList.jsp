<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>계정과목관리</h3>
			</div>
		</div>
		<div class="clearfix"></div>	
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>계정과목 리스트</h2>
						<div class="col-md-0 col-sm-0 col-xs-0 form-group pull-right top_search">
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/accountTitleInsert">계정과목 등록</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
					<p class="text-muted font-13 m-b-30">
						<h2>게시글 목록</h2>
					</p>
					<form name="search" method="post" action="${pageContext.request.contextPath}/accountTitleList">
						<select name="searchOption">
							<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>계정과목명+내용</option>
							<option value="account_title_name"
								<c:out value="${searchOption == 'account_title_name'?'selected':''}"/>>계정과목명</option>
							<option value="account_title_content"
								<c:out value="${searchOption == 'account_title_content'?'selected':''}"/>>내용</option>
						</select> 
						<input name="keyword" value="${keyword}"> <input type="submit" value="조회">
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
						<c:forEach var="accountTitleList" items="${accountTitleList}">
							<tr>
								<td>${accountTitleList.accountTitleCode}</td>
								<td>${accountTitleList.accountTitleName}</td>
								<td>${accountTitleList.accountTitleContent}</td>
								<td><a id="accountTitleUpdateButton"
									href="${pageContext.request.contextPath}/accountTitleUpdate?accountTitleCode=${accountTitleList.accountTitleCode}">
										수정</a>
								</td>
								<td><a onclick="button_event()" id="accountTitleDeleteButton"
									href="${pageContext.request.contextPath}/accountTitleDelete?accountTitleCode=${accountTitleList.accountTitleCode}">
										삭제</a>
								</td>
							</tr>
						</c:forEach>
					</table>
						<ul class="pager">
							<c:if test="${currentPage>1}">
								<li class="previous">
									<a href="${pageContext.request.contextPath}/accountTitleList?currentPage=${currentPage-1}">이전</a>
								</li>
							</c:if>
							<c:if test="${currentPage<lastPage}">
								<li class="next">
									<a href="${pageContext.request.contextPath}/accountTitleList?currentPage=${currentPage+1}">다음</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


