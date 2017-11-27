<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					BOARD <small>통합게시판</small> 
				</h3>
			</div>
			<!-- 검색 창 -->
			<div class="title_right">
				<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
					<form name="search" method="post" action="${pageContext.request.contextPath}/boardList">
						<select name="searchOption">
							<!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>title+내용+카테고리</option>
							<option value="board_content"
								<c:out value="${searchOption == 'board_content'?'selected':''}"/>>title명</option>
							<option value="board_content"
								<c:out value="${searchOption == 'board_content'?'selected':''}"/>>내용</option>
							<option value="category.category_small"
								<c:out value="${searchOption == 'category.category_small'?'selected':''}"/>>카테고리</option>
						</select> 
						<span class="input-group-btn">
							<input name="keyword" value="${keyword}" class="form-control"> <input type="submit" class="btn btn-default" value="조회">
						</span>
					</form>
					</div>
				</div>
			</div>
			<!--검색 창 끝  -->
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							Board LIST <small>Board</small>
						</h2>
						<div class="col-md-0 col-sm-0 col-xs-0 form-group pull-right top_search">
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/boardInsert	">게시글 등록</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">
							카테고리 나중에 join
						</p>
						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>게시글코드</th>
									<th>카테고리</th>
									<th>직원코드</th>
									<th>제목</th>
									<th>날짜</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="boardList" items="${boardList}">
									<tr>
										<td>${boardList.boardCode}</td>
										<td>${boardList.categorySmall}</td> 
										<td>${boardList.employeeCode}</td>
										<td><a href="${pageContext.request.contextPath}/boardDetail?boardCode=${boardList.boardCode}">${boardList.boardTitle}</a></td>
										<td>${boardList.boardDate}</td>					
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage>1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage<=lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
						<%--<div class = "text-center"> 
							<ul class="pagination">
								<c:if test="${currentPage > 1}">
									<li class="previous"><a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage-1}">이전</a></li>
								</c:if>
							 	<c:forEach var="page" begin="${startPage}" end="${endPage}" step="1">
									<c:choose>
										<c:when test="${page == currentPage}">
											<li class="active"><a>${page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${pageContext.request.contextPath}/claimList?currentPage=${page}">${page}</a></li>
										</c:otherwise>	
									</c:choose>	
								</c:forEach> 
								<c:if test="${currentPage < lastPage}">
									<li class="next"><a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage+1}">다음</a></li>
								</c:if>
							</ul>
						</div>--%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>