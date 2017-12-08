var dailySalesTable;
$(document).ready(
		function() {
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
				success : function(data) {
					var list = JSON.parse(data);
					console.log(data);
					dailySalesTable = $('#dailySalesTable').DataTable({
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
				},
				error : function(request, status, error) {
					alert('우리 지점의 일매출 조회 실패');
				}
			});
			$.ajax({
				url : "/monthlySalesListByShopJson",
				type : "GET",
				success : function(data) {
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
				},
				error : function(request, status, error) {
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
				success : function(data) {
					var list = JSON.parse(data);
					console.log(data);
					$(list).each(function(i, list) {
						dGraphLabels.push(list.daily_sales_date);
						dGraphData.push(list.daily_sales_amount);
					});
					createGraph(dCtx, dGraphLineData, dOptions);
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
			var dCtx = document.getElementById("dailyGraph");
			var dOptions = {
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
			// 월매출 그래프
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
					createGraph(mCtx, mGraphLineData, mOptions);
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
			var mCtx = document.getElementById("monthlyGraph");
			var mOptions = {
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
			// 일매출, 월매출 그래프 끝
			
			// 일매출 날짜 검색
			$('input[id="dailyDate"]').daterangepicker(
					{ locale: {
					      format: 'YYYY-MM-DD'
				    	},
				    startDate: '2017-12-03',
				    endDate: '2017-12-09'
				    },
				    function(start, end, label) {
				    	console.log("New date range selected: " + start.format('YYYY-MM-DD') + " to " + end.format('YYYY-MM-DD') + " (predefined range: " + label + ")");
				    }
			);
			$('input[id="dailyDate"]').on('apply.daterangepicker', function(ev, picker) {
				$.ajax({
		    		url : "/dailyDateSearchByShopJson",
					type : "json",
					method : "GET",
					data : {start : picker.startDate.format('YYYY-MM-DD'), end : picker.endDate.format('YYYY-MM-DD')},
					success : function(data) {
						var list = JSON.parse(data);
						dailySalesTable.clear();
						console.log(list);
						for(var i=0; i < list.length; i++){
							var dailySales = list[i];
							dailySalesTable.row.add(dailySales);
						}
						dailySalesTable.draw();
					},
					error : function(request, status, error) {
						alert('지점 일매출 날짜 검색 실패');
					}
		    	});
			  });
		});