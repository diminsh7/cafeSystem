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
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<p class="text-muted font-13 m-b-30">
						<h2>게시글 목록</h2>
						</p>
						<%@include file="../account/accountTitleSerchForm.jsp"%>
						<div>전체 수: ${totalRowCount}</div>

						<table id="datatable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>계정과목코드</th>
									<th>계정과목명</th>
									<th>상세내용</th>
									<th>수정</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="accountlist" items="${accountlist}"> 
									<tr>
										<td>${accountlist.accountTitleCode}</td>
										<td>${accountlist.accountTitleName}</td>
										<td>${accountlist.accountTitleContent}</td>
										<td><a href="${pageContext.request.contextPath}/accountTitleUpdateForm?accountTitleCode=${accountlist.accountTitleCode}">수정</a></td> 
                             			<td><a href="${pageContext.request.contextPath}/accountTitleDelete?accountTitleCode=${accountlist.accountTitleCode}">삭제</a></td>						
									</tr>
								</c:forEach> 
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage>1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/accountTitleList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage<=lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/accountTitleList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
						<div>
							<a href="${pageContext.request.contextPath}/accountTitleInsert">계정과목
								입력</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


