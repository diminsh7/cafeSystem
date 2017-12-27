<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		$(document).on('click', '#filedown', function(e) {
			var answer = confirm("文書をダウンロードしますか？")
			if (answer) {
				 e.preventDefault();
				 window.open("/resources/files/CafeSystem.docx", "_blank");
			}
		});
	});
</script>
<div class="right_col" role="main">
	<div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>Project Title &nbsp;</h2>
						<button id="filedown" type="button">開発文書 Download</button>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<h4>
							フランチャイズカフェ統合管理電算システム - Franchise Integrated Management System &nbsp;
						</h4>
					</div>
				</div>		
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>Project Goal</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">フランチャイズカフェの全社的な資源、経営戦略のためのソフトウェア開発</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>Expectancy Effects</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<tbody>
								<tr>
									<td>1</td>
									<td>本社での社員管理の便利性増進、また支店管理の容易性確保</td>
								</tr>
								<tr>
									<td>2</td>
									<td>支店での社員管理の便利性増進、また店舗管理の容易性確保</td>
								</tr>
								<tr>
									<td>3</td>
									<td>本社と支店間の業務電算化による業務の効率性増進</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-10">
				<div class="x_panel">
					<div class="x_title">
						<h2>Development Environment</h2>
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
						<h2>Related Data</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<table class="table">
							<tbody>
								<tr>
									<td></td>
									<td>▼ Click ▼</td>
								</tr>
								<tr>
									<td><strong>GITHUB Address</strong></td>
									<td><a href="https://github.com/Jeon-Yoo-jin/cafe-system">
											https://github.com/Jeon-Yoo-jin/cafe-system </a></td>
								</tr>
								<tr>
									<td><strong>ERD</strong></td>
									<td><a href="/resources/img/ERD_logical.png">論理ERD</a> / <a
										href="/resources/img/ERD_physical.png">物理ERD</a></td>
								</tr>
								<tr>
									<td><strong>開発文書</strong></td>
									<td><a id="filedown">Download</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>