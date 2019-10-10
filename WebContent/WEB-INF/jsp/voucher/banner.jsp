<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.inc"%>
<%
request.setAttribute("title", "Tables - Voucher");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/html_head.jsp"/>
</head>
<body class="no-skin">
		<jsp:include page="../common/header.jsp"/>
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>
			<jsp:include page="../common/leftNav.jsp"/>
			
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
								Voucher-Banner
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											
											<form action="${base}manage/voucher/uploadSingleDoc.do" method="post" class="form-horizontal"  enctype="multipart/form-data">
												<input type="hidden" name="voucherId" value="${voucher.id}">
												<input type="hidden" name="type" value="1">
												<input type="hidden" name="status" value="${voucher.status}">
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("voucher_banner");
													</script>
													<div id="banner-picture" class="tab-pane">
														<h4 class="header blue bolder smaller">Banner Picture
															<small>Size 1440px X 550px , Maximum no exceed 500kb</small>															
														</h4>
														<div class="row">
															<div class="col-xs-12 col-sm-2">
																<span onclick="uploadBanner();" class="profile-picture">
																	<c:choose>
																	   <c:when test="${list == null || list.size() < 1 }">
																	   		<img id="voucher_banner" class="editable img-responsive" src="${base}static/images/addFile.jpg"/>
																	   </c:when>
																	   <c:otherwise> 
																			<c:forEach items="${list}" var="banner" varStatus="vs">
																				<img id="voucher_banner" class="editable img-responsive" src="${base}manage/img/showByPath.do?path=${banner.path}"/>
																			</c:forEach>	
																	   </c:otherwise>
																	</c:choose>
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
			
			<jsp:include page="../common/html_foot.jsp"/>
		</div><!-- /.main-container -->
<jsp:include page="../common/jsConfig.jsp"/>
<jsp:include page="../common/jsUtils.jsp"/>
<jsp:include page="../common/script.jsp"/>

<script src="${ace}js/bootstrap-datepicker.min.js"></script>
<script>
var voucherStatus = "";
if("${voucher.status}" == "1") {
	voucherStatus = "voucherPending";
} else if("${voucher.status}" == "2") {
	voucherStatus = "voucherActive";
} else if("${voucher.status}" == "3") {
	voucherStatus = "voucherExpired";
} else if("${voucher.status}" == "4") {
	voucherStatus = "voucherRejected";
} 
switchLeftActive("voucher", null, voucherStatus);
function uploadBanner() {
	$("#uploadFile").click();
}
$.UploadConfig.onchange("#uploadFile", "#voucher_banner");
</script>

</body>
</html>

