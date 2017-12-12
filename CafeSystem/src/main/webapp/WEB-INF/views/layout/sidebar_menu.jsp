<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3>소개</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-building-o"></i> 프로젝트 &amp; 팀 소개 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/">프로젝트 소개</a></li>
					<li><a href="${pageContext.request.contextPath}/team">팀 소개</a></li>
				</ul></li>
		</ul>
	</div>
<c:if test="${not empty sessionScope.loginInfo }">
	<div class="menu_section">
		<h3>본사</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-building-o"></i> 매장관리 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/shopList">매장정보</a></li>
					<li><a href="${pageContext.request.contextPath}/contractList">가맹계약서</a></li>
					<li><a href="${pageContext.request.contextPath}/feeList">가맹수수료</a></li>
				</ul></li>
			<li><a><i class="fa fa-users"></i> 직원관리 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/headEmployeeList">본사직원정보</a></li>
					<li><a
						href="${pageContext.request.contextPath}/branchManagerList">점주정보</a></li>
					<li><a href="${pageContext.request.contextPath}/branchPersonnelList">지점직원정보</a></li>
					<li><a href="${pageContext.request.contextPath}/#">본사직원근태정보</a></li>
					<li><a href="${pageContext.request.contextPath}/#">본사직원급여명세서</a></li>
				</ul></li>
			<li><a><i class="fa fa-coffee"></i> 메뉴관리 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/menuInfoList">카페메뉴</a></li>
					<li><a href="${pageContext.request.contextPath}/materialList">메뉴재료원가</a></li>
					<li><a href="${pageContext.request.contextPath}/menuPriceList">메뉴가격관리</a></li>
				</ul></li>
			<li><a><i class="fa fa-shopping-cart"></i> 발주관리 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/item">발주품목</a></li>
					<li><a href="${pageContext.request.contextPath}/headOrderList">발주신청내역</a></li>
					<li><a href="${pageContext.request.contextPath}/headOrderCancelList">발주취소내역</a></li>
					<li><a href="${pageContext.request.contextPath}/#">불량품목신청내역</a></li>
				</ul></li>
			<li><a><i class="fa fa-krw"></i> 매출 및 회계관리 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/accountTitleList">계정과목</a></li>
					<li><a href="${pageContext.request.contextPath}/salesList">지점매출조회</a></li>
				</ul></li>
		</ul>
	</div>
	<div class="menu_section">
		<h3>지점</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-building-o"></i> 매장관리 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/#">매장정보조회</a></li>
					<li><a href="${pageContext.request.contextPath}/#">가맹계약서조회</a></li>
					<li><a href="${pageContext.request.contextPath}/feeListByShop">가맹수수료조회</a></li>
				</ul></li>
			<li><a><i class="fa fa-users"></i> 직원관리 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/selectBranchManager">점주정보</a></li>
					<li><a href="${pageContext.request.contextPath}/branchPersonnelInfoList">지점직원정보</a></li>
					<li><a href="${pageContext.request.contextPath}/#">지점직원근태정보</a></li>
					<li><a href="${pageContext.request.contextPath}/#">지점직원급여명세서</a></li>
				</ul></li>
			<li><a><i class="fa fa-coffee"></i> 메뉴관리 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/#">카페메뉴조회</a></li>
					<li><a href="${pageContext.request.contextPath}/branchMaterialList">메뉴재료원가조회</a></li>
					<li><a href="${pageContext.request.contextPath}/#">메뉴총원가조회</a></li>
				</ul></li>
			<li><a><i class="fa fa-shopping-cart"></i> 발주관리 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/branchOrderForm">발주</a></li>
					<li><a href="${pageContext.request.contextPath}/branchOrderRequestList">발주신청내역</a></li>
					<li><a href="${pageContext.request.contextPath}/#">불량품목신청</a></li>
				</ul></li>
			<li><a><i class="fa fa-krw"></i> 매출 및 회계관리 <span
					class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/salesListByShop">지점매출</a></li>
					<li><a href="${pageContext.request.contextPath}/#">지점기타지출</a></li>
					<li><a href="${pageContext.request.contextPath}/#">지점회계</a></li>
				</ul></li>
		</ul>
	</div>
	<div class="menu_section">
		<h3>공통</h3>
		<ul class="nav side-menu">
			<li><a href="${pageContext.request.contextPath}/claimList"><i
					class="fa fa-exclamation-triangle"></i> 고객클레임 </a></li>
			<li><a href="${pageContext.request.contextPath}/boardList"><i
					class="fa fa-edit"></i> 통합게시판 </a></li>
			<li><a href="${pageContext.request.contextPath}/branchCallList"><i
					class="fa fa-phone-square"></i> 매장연락망</a></li>
		</ul>
	</div>
</c:if>
</div>