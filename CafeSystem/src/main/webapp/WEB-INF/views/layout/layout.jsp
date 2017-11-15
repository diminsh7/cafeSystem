<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bean Place |</title>

<!-- Bootstrap -->
<link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
<!-- Font Awesome -->
<link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
<!-- NProgress -->
<link href="<c:url value="/resources/vendors/nprogress/nprogress.css" />" rel="stylesheet">
<!-- iCheck -->
<link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css" />" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link href="<c:url value="/resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" />" rel="stylesheet">
<!-- JQVMap -->
<link href="<c:url value="/resources/vendors/jqvmap/dist/jqvmap.min.css" />" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.css" />" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="<c:url value="/resources/build/css/custom.min.css" />" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>Bean Place</span></a>
					</div>

					<div class="clearfix"></div>
					<tiles:insertAttribute name="menuquick" />
					<br />
					<tiles:insertAttribute name="sidebar" />
					<tiles:insertAttribute name="menufooter" />
				</div>
			</div>

			<tiles:insertAttribute name="topnavi" />
			<tiles:insertAttribute name="contents" />
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	
<!-- jQuery -->
<script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js" />"></script>
<!-- Bootstrap -->
<script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" />"></script>
<!-- FastClick -->
<script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js" />"></script>
<!-- NProgress -->
<script src="<c:url value="/resources/vendors/nprogress/nprogress.js" />"></script>
<!-- Chart.js -->
<script src="<c:url value="/resources/vendors/Chart.js/dist/Chart.min.js" />"></script>
<!-- gauge.js -->
<script src="<c:url value="/resources/vendors/gauge.js/dist/gauge.min.js" />"></script>
<!-- bootstrap-progressbar -->
<script src="<c:url value="/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js" />"></script>
<!-- iCheck -->
<script src="<c:url value="/resources/vendors/iCheck/icheck.min.js" />"></script>
<!-- Skycons -->
<script src="<c:url value="/resources/vendors/skycons/skycons.js" />"></script>
<!-- Flot -->
<script src="<c:url value="/resources/vendors/Flot/jquery.flot.js" />"></script>
<script src="<c:url value="/resources/vendors/Flot/jquery.flot.pie.js" />"></script>
<script src="<c:url value="/resources/vendors/Flot/jquery.flot.time.js" />"></script>
<script src="<c:url value="/resources/vendors/Flot/jquery.flot.stack.js" />"></script>
<script src="<c:url value="/resources/vendors/Flot/jquery.flot.resize.js" />"></script>
<!-- Flot plugins -->
<script src="<c:url value="/resources/vendors/flot.orderbars/js/jquery.flot.orderBars.js" />"></script>
<script src="<c:url value="/resources/vendors/flot-spline/js/jquery.flot.spline.min.js" />"></script>
<script src="<c:url value="/resources/vendors/flot.curvedlines/curvedLines.js" />"></script>
<!-- DateJS -->
<script src="<c:url value="/resources/vendors/DateJS/build/date.js" />"></script>
<!-- JQVMap -->
<script src="<c:url value="/resources/vendors/jqvmap/dist/jquery.vmap.js" />"></script>
<script src="<c:url value="/resources/vendors/jqvmap/dist/maps/jquery.vmap.world.js" />"></script>
<script src="<c:url value="/resources/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js" />"></script>
<!-- bootstrap-daterangepicker -->
<script src="<c:url value="/resources/vendors/moment/min/moment.min.js" />"></script>
<script src="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.js" />"></script>
<!-- Custom Theme Scripts -->
<script src="<c:url value="/resources/build/js/custom.min.js" />"></script>

</body>
</html>