<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	$(document).ready(function() {
		$('#deleteButton').click(function() {
			if ($('#contractOwnerName').val().length < 2) {
				alert('contractOwnerName는 2자이상 이어야 합니다');
				$('#contractOwnerName').focus();
			} else {
				$('#deleteContract').submit();
			}
		});
	});
</script>
<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>계약서관리</h3>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/contractList">전체계약서 리스트</a>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/insertContract">계약서 등록</a>
			</div>
			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>계약서 삭제</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Settings 1</a></li>
									<li><a href="#">Settings 2</a></li>
								</ul></li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form action="./deleteContract" method="post"
							class="form-horizontal form-label-left" novalidate>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">계약코드<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractCode"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="contractCode" required="required" type="text"
										value="${param.contractCode}">
								</div>
							</div>
							<div class="item form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="name">소유자명 확인<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input id="contractOwnerName"
										class="form-control col-md-7 col-xs-12"
										data-validate-length-range="6" data-validate-words="2"
										name="contractOwnerName" required="required" type="text">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-md-offset-3">
									<button id="deleteButton" type="submit" class="btn btn-success">삭제</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
