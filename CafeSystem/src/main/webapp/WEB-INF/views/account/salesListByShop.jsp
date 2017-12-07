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
		$.ajax({
			url : "/dailySalesListByShopJson",
			type : "GET",
			success:function(data){
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
			},
			error:function(request, status, error){
				alert('우리 지점의 일매출 조회 실패');
			}
		});
		$.ajax({
			url : "/monthlySalesListByShopJson",
			type : "GET",
			success:function(data){
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
			},
			error:function(request, status, error){
				alert('우리 지점의 월매출 조회 실패');
			}
		});
		// 일매출, 월매출 리스트 끝
		
		// 일매출, 월매출 그래프 시작
		// 일매출 그래프
		var dGraphLabels = [];
		var dGraphData = [];
		$.ajax({
			url : "/dailyGraphJson",
			type : "GET",
			success:function(data){
				var list = JSON.parse(data);
				console.log(data);
				$(list).each(function(i, list) {
					dGraphLabels.push(list.daily_sales_date);
					dGraphData.push(list.daily_sales_amount);
				});
				createGraph(dCtx, dGraphLineData, dOptions);
			},
			error:function(request, status, error){
				alert('우리 지점의 일매출 그래프 그리기 실패');
			}
		});
		var dGraphLineData = {
				labels : dGraphLabels,
				datasets : [
			        {
			            label: "일매출",
			            data : dGraphData,
			            lineTension: 0,
			            fill: false,
			            borderColor: 'skyblue',
			            backgroundColor: 'transparent',
			            borderDash: [5, 5],
			            pointBorderColor: 'rgba(47,182,230,1)',
			            pointBackgroundColor: 'rgba(47,182,230,1)',
			            pointRadius: 5,
			            pointHoverRadius: 10,
			            pointHitRadius: 30,
			            pointBorderWidth: 2,
			            pointStyle: 'rectRounded'
			        }
			    ]
		};
		var dCtx = document.getElementById("dailyGraph");
		var dOptions = {
				legend: { display: false },
	      		title: {
	        	display: true,
	        	text: '주간 매출'
	      		},
	      		scales:{yAxes: [{
	      		      ticks: {
	      		        min: 1200000
	      		      }
	      		    }]}
		};
		// 월매출 그래프
		var mGraphData = [];
		$.ajax({
			url : "/monthlyGraphJson",
			type : "GET",
			success:function(data){
				var list = JSON.parse(data);
				console.log(data);
				$(list).each(function(i, list) {
					mGraphData.push(list.monthly_sales_amount);
				});
				createGraph(mCtx, mGraphLineData, mOptions);
			},
			error:function(request, status, error){
				alert('우리 지점의 월매출 그래프 그리기 실패');
			}
		});
		var mGraphLineData = {
				labels : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				datasets : [
			        {
			            label: "월매출",
			            data : mGraphData,
			            lineTension: 0,
			            fill: false,
			            borderColor: 'skyblue',
			            backgroundColor: 'transparent',
			            borderDash: [5, 5],
			            pointBorderColor: 'rgba(47,182,230,1)',
			            pointBackgroundColor: 'rgba(47,182,230,1)',
			            pointRadius: 5,
			            pointHoverRadius: 10,
			            pointHitRadius: 30,
			            pointBorderWidth: 2,
			            pointStyle: 'rectRounded'
			        }
			    ]
		};
		var mCtx = document.getElementById("monthlyGraph");
		var mOptions = {
				legend: { display: false },
	      		title: {
	        	display: true,
	        	text: '2017년 월 매출 추이'
	      		},
	      		scales:{yAxes: [{
	      		      ticks: {
	      		        min: 12000000
	      		      }
	      		    }]}
		};
		
		function createGraph(ctx, data, options){
			var ctxGet = ctx.getContext("2d");
			var myLine = new Chart(ctxGet, {
				type : 'line',
				data : data,
				options: options,
				responsive : true
			});
		}
		// 일매출, 월매출 그래프 끝
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
						<h2>우리 매장 매출 조회</h2>
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
												<h2>2017-12-04 ~ 2017-12-10  매출<small>Weekly Sales</small></h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
													<canvas id="dailyGraph"></canvas>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<br/>
									<div class="ln_solid"></div>
									
									<div class="col-md-4" style="margin-left: 500px;">
				                        	날짜 검색
				                        <form class="form-horizontal">
				                          <fieldset>
				                            <div class="control-group">
				                              <div class="controls">
				                                <div class="input-prepend input-group">
				                                  <span class="add-on input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span>
				                                  <input type="text" style="width: 200px" name="reservation" id="reservation" class="form-control" value="12/03/2017 - 12/09/2017" />
				                                  &nbsp; &nbsp;
													<button type="submit" class="btn btn-primary btn-sm" id="searchButton">
														검색
													</button>
				                                </div>
				                              </div>
				                            </div>
				                          </fieldset>
				                        </form>
				                      </div>
									
									<%-- <div class="form-group" style="float: right;">
										<form action="${pageContext.request.contextPath}/#" method="get">
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
									</div> --%>
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
												<h2>2017년 월별 매출<small>2017 Monthly Sales</small></h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content"><iframe class="chartjs-hidden-iframe" style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
													<canvas id="monthlyGraph"></canvas>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<br/>
									<div class="ln_solid"></div>
									<div class="form-group" style="float: right;">
										<form action="${pageContext.request.contextPath}/#" method="get">
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