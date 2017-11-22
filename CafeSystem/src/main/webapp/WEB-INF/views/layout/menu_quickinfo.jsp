<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="profile clearfix">
	 <div class="profile_pic">
		<img src="resources/production/images/login.PNG" alt="로그인이미지"
			class="img-circle profile_img">
	</div>
	<div class="profile_info">
	<!-- 로그인 세션정보 있을 때랑 없을 때 구분 - if문 사용하기 -->
	<!-- 로그인 세션정보 없을 때 - 로그인 버튼 -->
		<div class="fa-hover">
			<h3><a href="/login" style="color: white;"> LOGIN</a></h3>
	    </div>
	<!-- 로그인 세션정보 있을 때 - 간단한 정보와 로그아웃 버튼 -->
		<!-- <span>Welcome,</span>
		<h2>직원이름</h2> -->
	</div>
</div>