<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3>紹介</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-exclamation-circle"></i> Project &amp; Team <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/">About Me</a></li>
					<li><a href="${pageContext.request.contextPath}/project">About Project</a></li>
					<li><a href="${pageContext.request.contextPath}/team">About Team</a></li>
					
				</ul></li>
			<li><a href="https://blog.naver.com/synths" target="_black"><i class="fa fa-arrow-circle-right"></i> Owner's BLOG </a></li>	
			<li><a href="${pageContext.request.contextPath}/start"><i class="fa fa-arrow-circle-right"></i> Project START </a></li>
		</ul>
	</div>
<c:if test="${not empty sessionScope.loginInfo }">
	<div class="menu_section">
		<h3>本社</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-building-o"></i> 店舗管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/shopList">店舗情報</a></li>
					<li><a href="${pageContext.request.contextPath}/contractList">加盟契約書</a></li>
					<li><a href="${pageContext.request.contextPath}/feeList">加盟ロイヤルティー</a></li>
				</ul></li>
			<li><a><i class="fa fa-users"></i> 社員管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/headEmployeeList">本社社員情報</a></li>
					<li><a href="${pageContext.request.contextPath}/branchManagerList">店長情報</a></li>
					<li><a href="${pageContext.request.contextPath}/branchPersonnelList">支店社員情報</a></li>
					<li><a href="${pageContext.request.contextPath}/headSalaryList">本社社員給与明細書</a></li>
				</ul></li>
			<li><a><i class="fa fa-coffee"></i> メニュー管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/menuInfoList">メニュー情報</a></li>
					<li><a href="${pageContext.request.contextPath}/materialList">材料原価</a></li>
					<li><a href="${pageContext.request.contextPath}/menuPriceList">価格管理</a></li>
				</ul></li>
			<li><a><i class="fa fa-shopping-cart"></i> 発注管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/itemList">発注品目管理</a></li>
					<li><a href="${pageContext.request.contextPath}/headOrderList">発注申請管理</a></li>
					<li><a href="${pageContext.request.contextPath}/headOrderCancelList">発注取消管理</a></li>
					<li><a href="${pageContext.request.contextPath}/faultyList">不良品申請管理</a></li>
				</ul></li>
			<li><a><i class="fa fa-krw"></i> 売上・会計管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/accountTitleList">勘定科目管理</a></li>
					<li><a href="${pageContext.request.contextPath}/salesList">支店売上管理</a></li>
				</ul></li>
		</ul>
	</div>
	<div class="menu_section">
		<h3>支店</h3>
		<ul class="nav side-menu">
			<li><a><i class="fa fa-building-o"></i> 店舗管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/branchShopList">店舗情報照会</a></li>
					<li><a href="${pageContext.request.contextPath}/branchContractList">加盟契約情報照会</a></li>
					<li><a href="${pageContext.request.contextPath}/feeListByShop">加盟ロイヤルティー照会</a></li>
				</ul></li>
			<li><a><i class="fa fa-users"></i> 社員管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/selectBranchManager">店長情報</a></li>
					<li><a href="${pageContext.request.contextPath}/branchPersonnelInfoList">支店社員情報</a></li>
					<li><a href="${pageContext.request.contextPath}/branchSalaryList">支店社員給与明細書</a></li>
				</ul></li>
			<li><a><i class="fa fa-coffee"></i> メニュー管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/branchMenuInfoList">メニュー情報</a></li>
					<li><a href="${pageContext.request.contextPath}/branchMaterialList">材料原価照会</a></li>
					<li><a href="${pageContext.request.contextPath}/branchMenuPriceList">メニュー価格照会</a></li>
				</ul></li>
			<li><a><i class="fa fa-shopping-cart"></i> 発注管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/branchOrderForm">発注</a></li>
					<li><a href="${pageContext.request.contextPath}/branchOrderRequestList">発注申請内訳</a></li>
				</ul></li>
			<li><a><i class="fa fa-krw"></i> 売上管理 <span class="fa fa-chevron-down"></span></a>
				<ul class="nav child_menu">
					<li><a href="${pageContext.request.contextPath}/salesListByShop">支店売上</a></li>
				</ul></li>
		</ul>
	</div>
	<div class="menu_section">
		<h3>共通</h3>
		<ul class="nav side-menu">
			<li><a href="${pageContext.request.contextPath}/claimList"><i
					class="fa fa-exclamation-triangle"></i> クレーム </a></li>
			<li><a href="${pageContext.request.contextPath}/boardList"><i
					class="fa fa-edit"></i> 掲示板 </a></li>
			<li><a href="${pageContext.request.contextPath}/branchCallList"><i
					class="fa fa-phone-square"></i> 店舗ネットワーク </a></li>
		</ul>
	</div>
</c:if>
</div>