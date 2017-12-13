$(document).ready(
		function() {
			// top5 일매출 차트
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
			var dCtx1 = document.getElementById("dailyTop");
			var dOptions1 = {
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
			// top5 월매출 차트
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
			var mCtx1 = document.getElementById("monthlyTop");
			var mOptions1 = {
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
			// 지점 일매출 그래프
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
					alert('우리 지점의 일매출 그래프 그리기 실패');
				}
			});
			var dGraphLineData = {
				labels : dGraphLabels,
				datasets : [ {
					label : "일매출",
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
					text : '주간 매출'
				},
				scales : {
					yAxes : [ {
						ticks : {
							min : 1200000
						}
					} ]
				}
			};
			// 지점 월매출 그래프
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
					alert('우리 지점의 월매출 그래프 그리기 실패');
				}
			});
			var mGraphLineData = {
				labels : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
						'9월', '10월', '11월', '12월' ],
				datasets : [ {
					label : "월매출",
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
					text : '2017년 월 매출 추이'
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