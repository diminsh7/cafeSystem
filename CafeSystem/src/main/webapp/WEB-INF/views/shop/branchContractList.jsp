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
				</h3>			
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>契約書詳細照会</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form class="form-horizontal">
							<c:forEach var="contract" items="${contractList}">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">契約コード</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${contract.contractCode}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所有主</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${contract.contractOwnerName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">店舗名</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${contract.contractShopName}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所有主連絡先</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${contract.contractOwnerPhone}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">契約日</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${contract.contractStartDate}</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">契約終了日</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-control">${contract.contractEndDate}</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-6 col-md-offset-5">
										<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/branchContractList">契約書</a>
										<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/branchShopList">店舗情報</a>
									</div>
								</div>
								<%-- <div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">契約書イメージ</label>
									<div class="col-md-9 col-sm-9 col-xs-12">
										<div class="form-control">${contract.contractPhoto}</div>
									</div>
								</div> --%>
							</c:forEach>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
