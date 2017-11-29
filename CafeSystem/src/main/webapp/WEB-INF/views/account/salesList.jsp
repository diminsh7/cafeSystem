<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			$.fn.dataTable.tables({
				visible : true,
				api : true
			}).columns.adjust();
		});

		$('#dailySales').DataTable({
			ajax : {
				"type" : "POST",
				"url" : "<c:url value='/dailySalesListJson'/>",
				"dataType" : "JSON"
			},
			columns : [
						{data: "dailySalesCode"},
						{data: "statementNum"},
						{data: "shopName"},
						{data: "dailySalesDate"},
						{data: "dailySalesAmount"}
			],
			scrollY : 500,
			scrollCollapse : true,
			paging : true
		});

		// Apply a search to the second table for the demo
		$('#myTable2').DataTable().search('New York').draw();
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
						<h2>
							매출 조회
						</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="" role="tabpanel" data-example-id="togglable-tabs">
							<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
								<li role="presentation" class="active"><a
									href="#dailySales" id="dailySales-tab" role="tab" data-toggle="tab"
									aria-expanded="true">일 매출</a></li>
								<li role="presentation" class=""><a role="tab"
									href="#monthlySales" id="monthlySales-tab" data-toggle="tab"
									aria-expanded="false">월 매출</a></li>
								<li role="presentation"><a role="tab" href="#fee" id="fee-tab"
									data-toggle="tab" aria-expanded="false">가맹수수료</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<table role="tabpanel" id="dailySales" class="tab-pane fade active in table table-striped table-bordered" aria-labelledby="dailySales-tab">
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
								<table role="tabpanel" id="monthlySales" class="tab-pane fade active in table table-striped table-bordered" aria-labelledby="monthlySales-tab">
									<thead>
										<tr>
											<th>Name</th>
											<th>Position</th>
											<th>Office</th>
											<th>Extn.</th>
											<th>Start date</th>
											<th>Salary</th>
										</tr>
									</thead>
								</table>
								<table role="tabpanel" id="fee" class="tab-pane fade active in table table-striped table-bordered" aria-labelledby="fee-tab">
									<thead>
										<tr>
											<th>Name</th>
											<th>Position</th>
											<th>Office</th>
											<th>Extn.</th>
											<th>Start date</th>
											<th>Salary</th>
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
