$(document).ready(
		function() {
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
					order : [ 0, "desc" ]
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
					order : [ 0, "desc" ]
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
				datasets : [ {
					label : "일매출",
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
			var dCtx = document.getElementById("dailyTop");
			var dOptions = {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '일 매출 TOP5'
				},
				scales : {
					xAxes : [ {
						ticks : {
							min : 1500000
						}
					} ]
				}
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
				datasets : [ {
					label : "월매출",
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
			var mCtx = document.getElementById("monthlyTop");
			var mOptions = {
				legend : {
					display : false
				},
				title : {
					display : true,
					text : '월 매출 TOP5'
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
			// 일매출, 월매출 차트 끝
		});