<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(document).ready(
		function() {
			// top5 日売上チャート
			var dChartLabels = [];
			var dChartData = [];
			$.get("/dailyTopJson", function(data) {
				var list = JSON.parse(data);
				console.log(data);
				$(list).each(function(i, list) {
					dChartLabels.push(list.shop_name);
					dChartData.push(list.daily_sales_amount);
				});
				createTopChart(dCtx1, dTopLineChartData, dOptions1);
			});
			var dTopLineChartData = {
				labels : dChartLabels,
				datasets : [ {
					label : "日売上",
					data : dChartData,
					backgroundColor : [ 'rgba(0, 99, 132, 0.6)',
							'rgba(60, 99, 132, 0.6)',
							'rgba(120, 99, 132, 0.6)',
							'rgba(180, 99, 132, 0.6)',
							'rgba(240, 99, 132, 0.6)' ],
					borderColor : [ 'rgba(0, 99, 132, 1)',
							'rgba(60, 99, 132, 1)', 'rgba(120, 99, 132, 1)',
							'rgba(180, 99, 132, 1)', 'rgba(240, 99, 132, 1)' ],
					borderWidth : 2,
					hoverBorderWidth : 0
				} ]
			}
			var dCtx1 = document.getElementById("dailyTop");
			var dOptions1 = {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '日売上 TOP5'
				},
				scales : {
					xAxes : [ {
						ticks : {
							min : 1500000
						}
					} ]
				}
			};
			// top5 月売上チャート
			var mChartLabels = [];
			var mChartData = [];
			$.get("/monthlyTopJson", function(data) {
				var list = JSON.parse(data);
				console.log(data);
				$(list).each(function(i, list) {
					mChartLabels.push(list.shop_name);
					mChartData.push(list.monthly_sales_amount);
				});
				createTopChart(mCtx1, mTopLineChartData, mOptions1);
			});
			var mTopLineChartData = {
				labels : mChartLabels,
				datasets : [ {
					label : "月売上",
					data : mChartData,
					backgroundColor : [ 'rgba(0, 99, 132, 0.6)',
							'rgba(60, 99, 132, 0.6)',
							'rgba(120, 99, 132, 0.6)',
							'rgba(180, 99, 132, 0.6)',
							'rgba(240, 99, 132, 0.6)' ],
					borderColor : [ 'rgba(0, 99, 132, 1)',
							'rgba(60, 99, 132, 1)', 'rgba(120, 99, 132, 1)',
							'rgba(180, 99, 132, 1)', 'rgba(240, 99, 132, 1)' ],
					borderWidth : 2,
					hoverBorderWidth : 0
				} ]
			};
			var mCtx1 = document.getElementById("monthlyTop");
			var mOptions1 = {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '月売上 TOP5'
				},
				scales : {
					xAxes : [ {
						ticks : {
							min : 17000000
						}
					} ]
				}
			};

			function createTopChart(ctx, data, options) {
				var ctxGet = ctx.getContext("2d");
				var myLine = new Chart(ctxGet, {
					type : 'horizontalBar',
					data : data,
					options : options,
					responsive : true
				});
			}
			// 支店の日売上グラフ
			var dGraphLabels = [];
			var dGraphData = [];
			$.ajax({
				url : "/dailyGraphJson",
				type : "GET",
				success : function(data) {
					var list = JSON.parse(data);
					console.log(data);
					$(list).each(function(i, list) {
						dGraphLabels.push(list.daily_sales_date);
						dGraphData.push(list.daily_sales_amount);
					});
					createGraph(dCtx2, dGraphLineData, dOptions2);
				},
				error : function(request, status, error) {
					alert('内の店舗の日売上グラフ描き失敗');
				}
			});
			var dGraphLineData = {
				labels : dGraphLabels,
				datasets : [ {
					label : "日売上",
					data : dGraphData,
					lineTension : 0,
					fill : false,
					borderColor : 'skyblue',
					backgroundColor : 'transparent',
					borderDash : [ 5, 5 ],
					pointBorderColor : 'rgba(47,182,230,1)',
					pointBackgroundColor : 'rgba(47,182,230,1)',
					pointRadius : 5,
					pointHoverRadius : 10,
					pointHitRadius : 30,
					pointBorderWidth : 2,
					pointStyle : 'rectRounded'
				} ]
			};
			var dCtx2 = document.getElementById("dailyGraph");
			var dOptions2 = {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '週間売上'
				},
				scales : {
					yAxes : [ {
						ticks : {
							min : 1200000
						}
					} ]
				}
			};
			// 支店月売上グラフ
			var mGraphData = [];
			$.ajax({
				url : "/monthlyGraphJson",
				type : "GET",
				success : function(data) {
					var list = JSON.parse(data);
					console.log(data);
					$(list).each(function(i, list) {
						mGraphData.push(list.monthly_sales_amount);
					});
					createGraph(mCtx2, mGraphLineData, mOptions2);
				},
				error : function(request, status, error) {
					alert('内の店舗の月売上描き失敗');
				}
			});
			var mGraphLineData = {
				labels : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ],
				datasets : [ {
					label : "月売上",
					data : mGraphData,
					lineTension : 0,
					fill : false,
					borderColor : 'skyblue',
					backgroundColor : 'transparent',
					borderDash : [ 5, 5 ],
					pointBorderColor : 'rgba(47,182,230,1)',
					pointBackgroundColor : 'rgba(47,182,230,1)',
					pointRadius : 5,
					pointHoverRadius : 10,
					pointHitRadius : 30,
					pointBorderWidth : 2,
					pointStyle : 'rectRounded'
				} ]
			};
			var mCtx2 = document.getElementById("monthlyGraph");
			var mOptions2 = {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '2017年の月売上の成り行き'
				},
				scales : {
					yAxes : [ {
						ticks : {
							min : 12000000
						}
					} ]
				}
			};

			function createGraph(ctx, data, options) {
				var ctxGet = ctx.getContext("2d");
				var myLine = new Chart(ctxGet, {
					type : 'line',
					data : data,
					options : options,
					responsive : true
				});
			}
		});
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					売上現況 <small>Sales</small>
				</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h4>TOP5 店舗</h4>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<div class="x_panel">
								<div class="x_title">
									<h4>
										2017-12-11 売上 TOP5&nbsp;<small>Daily Sales TOP5</small>
									</h4>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<iframe class="chartjs-hidden-iframe"
										style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
									<canvas id="dailyTop"></canvas>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<div class="x_panel">
								<div class="x_title">
									<h4>
										11月 売上 TOP5&nbsp;<small>Monthly Sales TOP5</small>
									</h4>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<iframe class="chartjs-hidden-iframe"
										style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
									<canvas id="monthlyTop"></canvas>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h4><strong>강서발산역店 </strong>日·月別売上</h4>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<div class="x_panel">
								<div class="x_title">
									<h4>
										2017-12-04 ~ 2017-12-10 売上&nbsp;<small>Weekly Sales</small>
									</h4>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<iframe class="chartjs-hidden-iframe"
										style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
									<canvas id="dailyGraph"></canvas>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<div class="x_panel">
								<div class="x_title">
									<h4>
										2017年の月別売上&nbsp;<small>2017 Monthly Sales</small>
									</h4>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<iframe class="chartjs-hidden-iframe"
										style="width: 100%; display: block; border: 0px; height: 0px; margin: 0px; position: absolute; left: 0px; right: 0px; top: 0px; bottom: 0px;"></iframe>
									<canvas id="monthlyGraph"></canvas>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>