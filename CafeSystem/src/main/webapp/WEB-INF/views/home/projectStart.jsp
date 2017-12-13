<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="<c:url value="/resources/cafesystemJS/projectStartJS.js" />"></script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					매출 현황 <small>Sales</small>
				</h3>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h4>전 매장 TOP5</h4>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<div class="x_panel">
								<div class="x_title">
									<h4>
										2017-12-11 매출 TOP5&nbsp;<small>Daily Sales TOP5</small>
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
										11월 매출 TOP5&nbsp;<small>Monthly Sales TOP5</small>
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
						<h4><strong>강서발산역점 </strong>일·월별 매출</h4>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<div class="x_panel">
								<div class="x_title">
									<h4>
										2017-12-04 ~ 2017-12-10 매출&nbsp;<small>Weekly Sales</small>
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
										2017년 월별 매출&nbsp;<small>2017 Monthly Sales</small>
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