<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/common.inc"%>
<%
request.setAttribute("title", "Dashboard");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="common/html_head.jsp"/>
</head>
<body class="no-skin">
		<jsp:include page="common/header.jsp"/>
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			<jsp:include page="common/leftNav.jsp"/>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">
								<a href="#">Dashboard</a>
							</li>
						</ul>
					</div>
					<div class="page-content">
						<div class="page-header">
							<h1>
								Dashboard
							</h1>
						</div>
							<div class="col-xs-12">
								<div class="alert alert-block alert-success">
									<button type="button" class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>
									<i class="ace-icon fa fa-check green"></i>
									Welcome to
									<strong class="green">
										Welcome to 
										<small>ExSolve (v1.1).</small>
									</strong>
								</div>
							</div>
						</div>
					</div>
			</div>
			<jsp:include page="common/html_foot.jsp"/>
		</div><!-- /.main-container -->

<script>
// 	$.LeftMenuConfig.reset();
// 	$.LeftMenuConfig.onDashboard();
</script>
</body>
</html>

