<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	$(document).ready(function() {
		$.ajax({
			url : "/feeListByShopJson",
			type : "GET",
			success:function(data){
				var list = JSON.parse(data);
				console.log(data);
				$('#feeTable').DataTable({
					data : list,
					columns : [
						{data : "feeCode"},
						{data : "statementNum"},
						{data : "shopName"},
						{data : "feeMonth"},
						{data : "feePrice"},
						{data : "feeAuto"},
						{data : "feeReal"},
						{data : "feeRemain"}
					],
					order : [0, "desc"]
				});
			},
			error:function(request, status, error){
				alert('실패');
			}
		});
	});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					가맹 수수료 <small>Fee</small>
				</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>우리 매장 가맹 수수료 조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="form-group" style="float: right;">
							<form
								action="${pageContext.request.contextPath}/#" method="get">
								<select class="input-sm" style="float: left;">
									<option value="">날짜</option>
									<option value="">매장</option>
								</select> <input type="search" name="search" class="input-sm"
									style="text-align: center; float: left;" placeholder="검색어 입력"
									aria-controls="datatable"> &nbsp; &nbsp;
								<button type="submit" class="btn btn-primary btn-sm"
									id="searchButton"
									style="float: right; padding: 0.75mm 1.2mm 0.75mm 1.2mm;">
									검색</button>
							</form>
						</div>
						<table id="feeTable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>가맹수수료 관리코드</th>
									<th>전표번호</th>
									<th>매장명</th>
									<th>연월</th>
									<th>수수료</th>
									<th>자동 이체일</th>
									<th>실이체일</th>
									<th>잔여 납부금</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>