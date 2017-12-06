<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	$(document).ready(function() {
		// 일매출, 월매출 리스트 시작
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
				} ],
				order : [0, "desc"]
			});
		});
		$.get("/monthlySalesListJson", function(data) {
			var list = JSON.parse(data);
			console.log(data);
			$('#monthlySalesTable').DataTable({
				processing : true,
				serverSide : false,
				data : list,
				columns : [ {
					"data" : "monthlySalesCode"
				}, {
					"data" : "statementNum"
				}, {
					"data" : "shopName"
				}, {
					"data" : "monthlySalesDate"
				}, {
					"data" : "monthlySalesAmount"
				}, {
					"data" : "monthlySalesMoneydue"
				} ],
				order : [0, "desc"]
			});
		});
		// 일매출, 월매출 리스트 끝
		
		// 일매출, 월매출 차트 시작
		// 일매출 차트
		var dChartLabels = [];
		var dChartData = [];
		$.get("/dailyTopJson", function(data) {
			var list = JSON.parse(data);
			console.log(data);
			$(list).each(function(i, list) {
				dChartLabels.push(list.shop_name);
				dChartData.push(list.daily_sales_amount);
			});
			createTopChart(dCtx, dTopLineChartData, dOptions);
		});
		var dTopLineChartData = {
				labels : dChartLabels,
				datasets : [
			        {
			            label: "일매출",
			            data : dChartData,
			            backgroundColor: [
			                'rgba(0, 99, 132, 0.6)',
			                'rgba(60, 99, 132, 0.6)',
			                'rgba(120, 99, 132, 0.6)',
			                'rgba(180, 99, 132, 0.6)',
			                'rgba(240, 99, 132, 0.6)'
			              ],
		              borderColor: [
		            	    'rgba(0, 99, 132, 1)',
		            	    'rgba(60, 99, 132, 1)',
		            	    'rgba(120, 99, 132, 1)',
		            	    'rgba(180, 99, 132, 1)',
		            	    'rgba(240, 99, 132, 1)'
		            	  ],
	            	  borderWidth: 2,
	            	  hoverBorderWidth: 0
			        }
			    ]
			}
			var dCtx = document.getElementById("dailyTop");
			var dOptions = {
		      		legend: { display: false },
		      		title: {
		        	display: true,
		        	text: '일 매출 TOP5'
		      		},
		      		scales:{xAxes: [{
		      		      ticks: {
		      		        min: 1500000
		      		      }
		      		    }]}
			};
			// 월매출 차트
			var mChartLabels = [];
			var mChartData = [];
			$.get("/monthlyTopJson", function(data) {
				var list = JSON.parse(data);
				console.log(data);
				$(list).each(function(i, list) {
					mChartLabels.push(list.shop_name);
					mChartData.push(list.monthly_sales_amount);
				});
				createTopChart(mCtx, mTopLineChartData, mOptions);
			});
			var mTopLineChartData = {
					labels : mChartLabels,
					datasets : [
				        {
				            label: "월매출",
				            data : mChartData,
				            backgroundColor: [
				                'rgba(0, 99, 132, 0.6)',
				                'rgba(60, 99, 132, 0.6)',
				                'rgba(120, 99, 132, 0.6)',
				                'rgba(180, 99, 132, 0.6)',
				                'rgba(240, 99, 132, 0.6)'
				              ],
			              borderColor: [
			            	    'rgba(0, 99, 132, 1)',
			            	    'rgba(60, 99, 132, 1)',
			            	    'rgba(120, 99, 132, 1)',
			            	    'rgba(180, 99, 132, 1)',
			            	    'rgba(240, 99, 132, 1)'
			            	  ],
		            	  borderWidth: 2,
		            	  hoverBorderWidth: 0
				        }
				    ]
				}
			var mCtx = document.getElementById("monthlyTop");
			var mOptions = {
			      		legend: { display: false },
			      		title: {
			        	display: true,
			        	text: '월 매출 TOP5'
			      		},
			      		scales:{xAxes: [{
			      		      ticks: {
			      		        min: 17000000
			      		      }
			      		    }]}
			};
			
			function createTopChart(ctx, data, options){
				var ctxGet = ctx.getContext("2d");
				var myLine = new Chart(ctxGet, {
					type : 'horizontalBar',
					data : data,
					options: options,
					responsive : true
				});
			}
			// 일매출, 월매출 차트 끝
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
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>2017-10-19 매출 TOP5<small>Daily Sales TOP5</small></h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
													<canvas id="dailyTop"></canvas>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<br/>
									<div class="form-group" style="float: right;">
										<form action="${pageContext.request.contextPath}/dailySalesSearch" method="get">
											<select class="input-sm" style="float: left;">
												<option value="">날짜</option>
												<option value="">매장</option>
											</select>
											<input type="search" name="search" class="input-sm" style="text-align: center; float: left;"
												placeholder="검색어 입력" aria-controls="datatable">
											&nbsp; &nbsp;
											<button type="submit" class="btn btn-primary btn-sm" id="searchButton"
												style="float: right; padding: 0.75mm 1.2mm 0.75mm 1.2mm;">
												검색</button>
										</form>
									</div>
									<table id="dailySalesTable"
										class="table table-striped table-bordered">
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
								<div role="tabpanel" class="tab-pane fade active" id="monthlySales" aria-labelledby="monthlySales-tab">
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>9월 매출 TOP5<small>Monthly Sales TOP5</small></h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
													<canvas id="monthlyTop"></canvas>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<br/>
									<div class="form-group" style="float: right;">
										<form action="${pageContext.request.contextPath}/monthlySalesSearch" method="get">
											<select class="input-sm" style="float: left;">
												<option value="">날짜</option>
												<option value="">매장</option>
											</select>
											<input type="search" name="search" class="input-sm" style="text-align: center; float: left;"
												placeholder="검색어 입력" aria-controls="datatable">
											&nbsp; &nbsp;
											<button type="submit" class="btn btn-primary btn-sm" id="searchButton"
												style="float: right; padding: 0.75mm 1.2mm 0.75mm 1.2mm;">
												검색</button>
										</form>
									</div>
									<table id="monthlySalesTable"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>월매출 관리코드</th>
												<th>전표번호</th>
												<th>매장명</th>
												<th>연월</th>
												<th>월매출액</th>
												<th>예정 수수료</th>
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