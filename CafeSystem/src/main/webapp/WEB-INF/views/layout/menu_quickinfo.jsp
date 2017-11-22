<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="profile clearfix">
	<!-- 로그인 되었을 때의 이미지 상의해서 변경하든지 하자 -->
	<c:choose>
		<c:when test="${empty sessionScope.loginInfo }">
			<div class="profile_pic">
				<img src="resources/production/images/login.PNG" alt="로그인안함"
					class="img-circle profile_img">
			</div>
			<div class="profile_info">
				<div class="fa-hover">
					<h3>
						<a href="${pageContext.request.contextPath}/login" style="color: white;"> LOGIN</a>
					</h3>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="profile_pic">
				<img src="resources/production/images/loging.jpg" alt="로그인중"
					class="img-circle profile_img">
			</div>
			<div class="profile_info">
				<span>${sessionScope.loginInfo.empCode}</span>
				<h2>${sessionScope.loginInfo.name} 님</h2>
			</div>
		</c:otherwise>
	</c:choose>
</div>