<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>급여명세서관리<small>본사</small></h3>
			</div>
		</div>
		<div class="clearfix"></div>	
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>급여명세서 리스트</h2>
						<div class="col-md-0 col-sm-0 col-xs-0 form-group pull-right top_search">
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/headSalaryInsert">급여명세서 등록</a>
						</div>
						<div class="clearfix"></div>
					</div>
					
					<div class="x_content">
					<p class="text-muted font-13 m-b-30">
						<h2>급여명세서 목록</h2>
					</p>
					
					<form name="search" method="post" action="${pageContext.request.contextPath}/headSalaryList">
						<legend>검색</legend>
						<ul>
							<li>
								<label>직원코드 검색</label>
								<input type="text" name="keyword1" value="${keyword1}">
							</li>
							<li>
								<label>기간검색</label>
								<input type="Date" name="keyword2" value="${keyword2}">
							</li>
						</ul>
						<input type="submit" value="조회">
						<%-- <!-- <div name="searchOption"> -->
						직원 코드 검색: <input name="keyword" value="${keyword}"> 
						<input type="submit" value="조회">
						<div value="searchOption" value="head_salary_workmonth">날짜 검색<input type="Date" name="keyword"  value="${keyword}" required></div>
						<input type="submit" value="조회">	 --%>			
					</form>
					<!-- 레코드의 갯수를 출력 -->
					${headSalaryCount}개의 게시물이 있습니다.
					<table id="datatable" class="table table-striped table-bordered">
						<tr>
							<th>귀속연월</th>
							<th>직원코드</th>
							<th>이름</th>
							<th>생년월일</th>
							<th>부서</th>
							<th>지급합계</th>
							<th>공제합계</th>
							<th>실수령액</th>
							<th>상세정보</th>
						</tr>
						<c:forEach var="headSalaryList" items="${headSalaryList}">
							<tr>
								<td>${headSalaryList.headSalaryWorkmonth}</td>
								<td>${headSalaryList.headEmployeeCode}</td>
								<td>${headSalaryList.headEmployeeName}</td>
								<td>${headSalaryList.headEmployeeBirth}</td>
								<td>${headSalaryList.categoryDepartment}</td>
								<td>${headSalaryList.headSalaryPayments}</td>
								<td>${headSalaryList.headSalaryDeduction}</td>
								<td>${headSalaryList.headSalaryReceipts}</td>
								<td><a href="${pageContext.request.contextPath}/headSalaryDetail?headEmployeeCode=${headSalaryList.headEmployeeCode}">상세보기</a></td>
							</tr>
						</c:forEach>
					</table>
						<ul class="pager">
							<c:if test="${currentPage>1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/headSalaryList?currentPage=${currentPage-1}">이전</a></li>
							</c:if>
							<c:if test="${currentPage<=lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/headSalaryList?currentPage=${currentPage+1}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
