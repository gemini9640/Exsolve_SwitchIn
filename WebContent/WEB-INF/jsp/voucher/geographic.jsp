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
								<a href="#">Voucher Management</a>
							</li>
						</ul>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								Voucher Location
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											<form class="form-horizontal" action="${base}manage/voucher/edit.do" method="post">
												<input name="id" type="hidden" value="${voucher.id}"/>
												<input name="status" type="hidden" value="${voucher.status}"/>
												<input name="editType" type="hidden" value="geographic"/>
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("voucher_geo");
													</script>
													
													<!--Category Tab 开始-->
													<div class="tab-content profile-edit-tab-content">
														<div id="" class="tab-pane in active">
														<div class="tab-pane">
															<h4 class="header blue bolder smaller">Location</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-12">
																	<div class="space-10"></div>
																	<div>
																		<label class="inline">
																			<input id="KL" type="checkbox" name="geographic" value="KL" class="ace" />
																			<span class="lbl">Kuala Lumpur</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="SA" type="checkbox" name="geographic" value="SA" class="ace" />
																			<span class="lbl">Shah Alam</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="PTJ" type="checkbox" name="geographic" value="PTJ" class="ace" />
																			<span class="lbl">Putrajaya</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="PLJ" type="checkbox" name="geographic" value="PLJ" class="ace" />
																			<span class="lbl">Petaling Jaya</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="PC" type="checkbox" name="geographic" value="PC" class="ace" />
																			<span class="lbl">Puchong</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="AP" type="checkbox" name="geographic" value="AP" class="ace" />
																			<span class="lbl">Ampang</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="SBJ" type="checkbox" name="geographic" value="SBJ" class="ace" />
																			<span class="lbl">Subang Jaya</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="CJ" type="checkbox" name="geographic" value="CJ" class="ace" />
																			<span class="lbl">Cyberjaya</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="SKB" type="checkbox" name="geographic" value="SKB" class="ace" />
																			<span class="lbl">Seri Kembangan</span>
																		</label>
																	</div>
																</div>
															</div>
														</div>
														</div>
													</div>
														<!--Category Tab 结束-->
													<div class="clearfix form-actions">
														<div class="col-md-offset-3 col-md-9">
															<button class="btn btn-info" type="submit">
																<i class="ace-icon fa fa-check bigger-110"></i>
																Submit
															</button>
															&nbsp; &nbsp;
															<button class="btn" type="reset">
																<i class="ace-icon glyphicon glyphicon-remove bigger-110"></i>
																cancel
															</button>
														</div>
													</div>
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
			<script type="text/javascript">
				switchLeftActive("voucher", null, "voucherCreate");
			</script>
			<jsp:include page="../common/html_foot.jsp"/>
		</div><!-- /.main-container -->
<jsp:include page="../common/jsConfig.jsp"/>
<jsp:include page="../common/jsUtils.jsp"/>
<jsp:include page="../common/script.jsp"/>





<script src="${ace}js/bootstrap-datepicker.min.js"></script>
<script>
function initSelectGeographic(valueStr) {
	if(valueStr != "" && valueStr.length > 0) {
		var values = valueStr.split(",");
		for(var key in values) {
			$("#"+values[key]).attr("selected", true);
			$("#"+values[key]).click();
		}
	}
}
initSelectGeographic("${voucher.geographic}");

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
$('.date-picker').datepicker().next().on(ace.click_event, function(){
	$(this).prev().focus();
});

$('#startTime,#endTime').timepicker({
	minuteStep: 1,
	showSeconds: true,
	showMeridian: false
}).next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script>

</body>
</html>

