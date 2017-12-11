<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="<c:url value="/resources/cafesystemJS/salesListByShopJS.js" />"></script>

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
									
									<div class="col-md-4" style="margin-left: 450px;">
										날짜 검색
				                        <form class="form-horizontal">
				                          <fieldset>
				                            <div class="control-group">
				                              <div class="controls">
				                                <div class="input-prepend input-group">
				                                  <span class="add-on input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span>
				                                  <input type="text" style="width: 200px" name="dailyDate" id="dailyDate" class="form-control" />
				                                  &nbsp; &nbsp;
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