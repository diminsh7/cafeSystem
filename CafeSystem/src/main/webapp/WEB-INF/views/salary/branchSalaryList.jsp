<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>給与明細書管理 <small> ㅣ 支店</small></h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>給与明細書リスト</h2>
						<div class="col-md-0 col-sm-0 col-xs-0 form-group pull-right top_search">
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/branchSalaryInsert">明細書登録</a>
						</div>
						<div class="clearfix"></div>
					</div>
					
					<div class="x_content">
					<form name="search" method="post" action="${pageContext.request.contextPath}/branchSalaryList">
						<div style="float: right">
							<label>社員コード</label>
							<input type="text" name="keyword1" value="${keyword1}">
							<label>帰属年月</label>
							<input type="MONTH" name="keyword2" value="${keyword2}">
							<input type="submit" value="検索">
						</div>
					</form>
					<!-- 레코드의 갯수를 출력 -->
					${branchSalaryCount}個の結果があります。
					<table id="datatable" class="table table-striped table-bordered">
						<tr>
							<th>帰属年月</th>
							<th>社員コード</th>
							<th>名前</th>
							<th>生年月日</th>
							<th>部署</th>
							<th>支給合計</th>
							<th>控除合計</th>
							<th>手取り額</th>
							<th>詳細照会</th>
						</tr>
						<c:forEach var="branchSalaryList" items="${branchSalaryList}">
							<tr>
								<td>${branchSalaryList.branchSalaryWorkmonth}</td>
								<td>${branchSalaryList.branchEmployeeCode}</td>
								<td>${branchSalaryList.branchEmployeeName}</td>
								<td>${branchSalaryList.branchEmployeeBirth}</td>
								<td>${branchSalaryList.categoryPosition}</td>
								<td>${branchSalaryList.branchSalaryPayments}</td>
								<td>${branchSalaryList.branchSalaryDeduction}</td>
								<td>${branchSalaryList.branchSalaryReceipts}</td>
								<td><a href="${pageContext.request.contextPath}/branchSalaryDetail?branchSalaryCode=${branchSalaryList.branchSalaryCode}">詳細照会</a></td>
							</tr>
						</c:forEach>
					</table>
						<ul class="pager">
							<c:if test="${currentPage>1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/branchSalaryList?currentPage=${currentPage-1}">Prev</a></li>
							</c:if>
							<c:if test="${currentPage<=lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/branchSalaryList?currentPage=${currentPage+1}">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
