<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		$(document).on('click', '#filedown', function(e) {
			var answer = confirm("다운로드 하시겠습니까 ?")
			if (answer) {
				 e.preventDefault();
		         window.open("/resources/files/프랜차이즈카페통합관리전산시스템_개발문서.xlsx", "_blank");
			}
		});
	});
</script>
<div class="right_col" role="main">
	<div class="">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<div class="well" style="margin-bottom: 10px">
					<h5>
						<strong>프로젝트 주제</strong>
					</h5>
					<h3>프렌차이즈 통합관리 전산 시스템 (Franchise Integrated Management System)</h3>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>프로젝트 목표</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">프렌차이즈 전사적 자원, 경영 전략을 위한 소프트웨어 개발</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>기대효과</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<tbody>
								<tr>
									<td>1</td>
									<td>본사에서의 직원 관리 편의성 증진 및 지점 관리 용의성 확보</td>
								</tr>
								<tr>
									<td>2</td>
									<td>지점에서의 직원 관리 편의성 증진 및 매장 관리 용의성 확보</td>
								</tr>
								<tr>
									<td>3</td>
									<td>본사와 지점 간의 업무 전산화에 따른 업무 효율성 증진</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>개발환경</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<tbody>
								<tr>
									<td><strong>OS</strong></td>
									<td>Windows 10</td>
								</tr>
								<tr>
									<td><strong>Web Browser</strong></td>
									<td>Chrome</td>
								</tr>
								<tr>
									<td><strong>WAS</strong></td>
									<td>apache-tomcat 8.0</td>
								</tr>
								<tr>
									<td><strong>DB</strong></td>
									<td>MySQL 5.5.17</td>
								</tr>
								<tr>
									<td><strong>DB Tool</strong></td>
									<td>HeidiSQL 8.0.0</td>
								</tr>
								<tr>
									<td><strong>Development Tool</strong></td>
									<td>Spring Tool Suite 3.9.0</td>
								</tr>
								<tr>
									<td><strong>Plan Management Tool</strong></td>
									<td>Trello</td>
								</tr>
								<tr>
									<td><strong>Language</strong></td>
									<td>Java 1.8, Javascript, JSP, HTML 5</td>
								</tr>
								<tr>
									<td><strong>Framework</strong></td>
									<td>jQuery 2.2.4, Json, Ajax, Mybatis 3.4.5, bootStrap
										3.3.6, Spring 4.3.12, Maven 2.5.1, tiles 3.0.5</td>
								</tr>
								<tr>
									<td><strong>API</strong></td>
									<td>JSTL 1.2, EL, Gson 2.8.0, Log4j 1.2.15, Mybatis-Spring
										1.3.1, Datatables, chart.js 2.7.1, Kakao 우편번호</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>프로젝트 관련 자료</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<tbody>
								<tr>
									<td><strong>GITHUB 주소</strong></td>
									<td><a href="https://github.com/Jeon-Yoo-jin/cafe-system">
											https://github.com/Jeon-Yoo-jin/cafe-system </a></td>
								</tr>
								<tr>
									<td><strong>ERD</strong></td>
									<td><a href="/resources/img/ERD_logical.png">논리ERD</a> / <a
										href="/resources/img/ERD_physical.png">물리ERD</a></td>
								</tr>
								<tr>
									<td><strong>개발문서</strong></td>
									<td><a id="filedown">개발문서 다운로드</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>