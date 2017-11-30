<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<script>
	$(document).ready(function() {
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			$.fn.dataTable.tables({
				visible : true,
				api : true
			}).columns.adjust();
		});

		$.get("/dailySalesListJson", function(data) {
			var list = JSON.parse(data);
			console.log(data);
			$('#dailySalesTable').DataTable({
				processing : true,
				serverSide : false,
				data : list,
				columns : [ {
					"data" : "dailySalesCode"
				}, {
					"data" : "statementNum"
				}, {
					"data" : "shopName"
				}, {
					"data" : "dailySalesDate"
				}, {
					"data" : "dailySalesAmount"
				} ]
			});
		});
		$.get("/dailySalesListJson", function(data) {
			var list = JSON.parse(data);
			console.log(data);
			$('#monthlySalesTable').DataTable({
				processing : true,
				serverSide : false,
				data : list,
				columns : [ {
					"data" : "dailySalesCode"
				}, {
					"data" : "statementNum"
				}, {
					"data" : "shopName"
				}, {
					"data" : "dailySalesDate"
				}, {
					"data" : "dailySalesAmount"
				} ]
			});
		});
	});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					매출 <small>Sales</small>
				</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>매출 조회</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div role="tabpanel" data-example-id="togglable-tabs">
							<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
								<li role="presentation" class="active"><a
									href="#dailySales" id="dailySales-tab" role="tab"
									data-toggle="tab" aria-expanded="true">일 매출</a></li>
								<li role="presentation" class=""><a role="tab"
									href="#monthlySales" id="monthlySales-tab" data-toggle="tab"
									aria-expanded="false">월 매출</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div role="tabpanel" class="tab-pane fade active in" id="dailySales" aria-labelledby="dailySales-tab">
									<table id="dailySalesTable"	class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>일매출 관리코드</th>
												<th>전표번호</th>
												<th>매장명</th>
												<th>날짜</th>
												<th>일매출액</th>
											</tr>
										</thead>
									</table>
								</div>
								<div role="tabpanel" class="tab-pane fade" id="monthlySales" aria-labelledby="monthlySales-tab">
									<table id="monthlySalesTable" class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>일매출 관리코드</th>
												<th>전표번호</th>
												<th>매장명</th>
												<th>날짜</th>
												<th>일매출액</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>