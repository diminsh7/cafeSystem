<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					加盟契約書管理
					<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/contractList">契約書リスト</a> 
					<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/insertContract">契約書登録</a>					
				</h3>
				
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>契約書リスト <small>* 契約コードをクリックして詳細情報確認</small> </h2>
						<div class="clearfix"></div>
					</div>
					<form action="./contractList" method="post" name="search">
						<select name="searchOption">
							<option value="all"
								<c:out value="${searchOption == 'all'?'selected':''}"/>>所有主名+店舗名</option>
							<option value="contract_owner_name"
								<c:out value="${map.searchOption == 'contractOwnerName'?'selected':''}"/>>所有主名</option>
							<option value="contract_shop_name"
								<c:out value="${map.searchOption == 'contractShopName'?'selected':''}"/>>店舗名</option>
						</select>
						<input name="keyword" value="${keyword}">
						<input type="submit" value="検索">
					</form>
					<div class="x_content">
						<div align="right">契約書数: ${contractCount}</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>契約コード</th>
									<th>所有主名</th>
									<th>店舗名</th>
									<th>契約日</th>
									<th>契約終了日</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="contract" items="${contractList}">
									<tr>
										<td><a href="${pageContext.request.contextPath}/contractDetail?contractCode=${contract.contractCode}">${contract.contractCode}</a></td>
										<td>${contract.contractOwnerName}</td>
										<td>${contract.contractShopName}</td>
										<td>${contract.contractStartDate}</td>
										<td>${contract.contractEndDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pager">
							<c:if test="${currentPage > 1}">
								<li class="previous"><a
									href="${pageContext.request.contextPath}/contractList?currentPage=${currentPage-1}">Prev</a></li>
							</c:if>
							<c:if test="${currentPage < lastPage}">
								<li class="next"><a
									href="${pageContext.request.contextPath}/contractList?currentPage=${currentPage+1}">Next</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
