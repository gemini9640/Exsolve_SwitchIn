<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/common.inc"%>
<%
request.setAttribute("title", "Tables - SI-Merchant");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../../common/html_head.jsp"/>
</head>
<body class="no-skin">
		<jsp:include page="../../common/header.jsp"/>
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			<jsp:include page="../../common/leftNav.jsp"/>
			
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li>
								<a href="#">User Management</a>
							</li>
						</ul>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								SI-Merchant-PIC Info
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											
											<%--
											<div id="banner_list">
												<c:forEach items="${list}" var="banner" varStatus="vs">
													${banner.path}<br/>
												</c:forEach>	
											</div>
											 --%>
											
											
											<form action="${base}manage/merchant/uploadDoc.do" method="post" class="form-horizontal"  enctype="multipart/form-data">
												<input type="hidden" name="picId" value="${pic.id}">
												<input type="hidden" name="merchantId" value="${merchant.id}">
												<input type="hidden" name="type" value="2">
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("si_merchant_banner");
													</script>
													<div id="banner-picture" class="tab-pane">
														<h4 class="header blue bolder smaller">Banner Picture
															<small>Size 1440px X 550px , Maximum no exceed 500kb</small>															
														</h4>
														<div class="row">
															<div class="col-xs-12 col-sm-2">
																<span onclick="uploadBanner();" class="profile-picture">
																	<img id="merchant_banner" class="editable img-responsive" src="${base}static/images/addFile.jpg" />
																</span>
															</div>
														</div>
													</div>
													<div class="clearfix form-actions">
													<div class="col-md-offset-3 col-md-9">
														<button class="btn btn-info" type="submit">
															<i class="ace-icon fa fa-check bigger-110"></i>
															Save
														</button>

														&nbsp; &nbsp;
														<button class="btn" type="reset">
															<i class="ace-icon glyphicon glyphicon-remove bigger-110"></i>
															cancel
														</button>
													</div>
												</div>
													<input id="uploadFile" type="file" name="file" style="display:none;"/>
												</div>
											</form>
										</div><!-- /.span -->
									</div><!-- /.user-profile -->
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
			
			<jsp:include page="../../common/html_foot.jsp"/>
		</div><!-- /.main-container -->
<jsp:include page="../../common/jsConfig.jsp"/>
<jsp:include page="../../common/jsUtils.jsp"/>
<jsp:include page="../../common/script.jsp"/>

<script src="${ace}js/bootstrap-datepicker.min.js"></script>
<script>
function uploadBanner() {
	$("#uploadFile").click();
}
$.UploadConfig.onchange("#uploadFile", "#merchant_banner");
</script>

</body>
</html>

