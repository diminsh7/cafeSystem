<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="profile clearfix">
	<!-- 로그인 세션정보 있을 때랑 없을 때 구분 - if문 사용하기 -->
	<!-- 로그인 세션정보 없을 때 - 로그인 버튼 -->
	<!-- 로그인 세션정보 있을 때 - 간단한 정보 -->
	<!-- 보이는 정보부분 바꾸기!! 그리고 이미지쪽도 로그인된거랑 안된거 구분해야됨 -->
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo }">
			<div class="profile_pic">
				<img src="resources/production/images/login.PNG" alt="로그인이미지"
					class="img-circle profile_img">
			</div>
			<div class="profile_info">
				<div class="fa-hover">
					<h3>
						<a href="/login" style="color: white;"> LOGIN</a>
					</h3>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="profile_pic">
				<img src="resources/production/images/loging.jpg" alt="로그인이미지"
					class="img-circle profile_img">
			</div>
			<div class="profile_info">
				<span>Welcome,</span>
				<h2>직원이름</h2>
			</div>
		</c:otherwise>
	</c:choose>
</div>