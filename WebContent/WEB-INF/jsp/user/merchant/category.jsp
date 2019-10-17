<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/common.inc"%>
<%
request.setAttribute("title", "Tables - Merchant");
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
								<a href="#">Merchant Management</a>
							</li>
						</ul>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								Merchant Category
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											<form class="form-horizontal" action="${base}manage/merchant/edit.do" method="post" enctype="multipart/form-data">
												<input name="id" type="hidden" value="${merchant.id}"/>
												<input type="hidden" name="picId" value="${pic.id}">
												<input name="status" type="hidden" value="${merchant.status}"/>
												<input name="editType" type="hidden" value="category"/>
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("si_merchant_cate");
													</script>
													
													<!--Category Tab 开始-->
													<div class="tab-content profile-edit-tab-content">
														<div id="" class="tab-pane in active">
														<div class="tab-pane">
															<h4 class="header blue bolder smaller">Category</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-12">
																	<div class="space-10"></div>
																	<div>
																		<label class="inline">
																			<input id="KF" type="checkbox" name="tagline" value="KF" class="ace" />
																			<span class="lbl">Kids & Family</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="HB" type="checkbox" name="tagline" value="HB" class="ace" />
																			<span class="lbl">Healthy & Beauty</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="SA" type="checkbox" name="tagline" value="SA" class="ace" />
																			<span class="lbl">Sport & Activities</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="LP" type="checkbox" name="tagline" value="LP" class="ace" />
																			<span class="lbl">Leisure & Pleasure</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="FB" type="checkbox" name="tagline" value="FB" class="ace" />
																			<span class="lbl">Food & Beverage</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="CA" type="checkbox" name="tagline" value="CA" class="ace" />
																			<span class="lbl">Computer & Accessories</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="FC" type="checkbox" name="tagline" value="FC" class="ace" />
																			<span class="lbl">Fashion & Clothes</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="EC" type="checkbox" name="tagline" value="EC" class="ace" />
																			<span class="lbl">Education</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="WS" type="checkbox" name="tagline" value="WS" class="ace" />
																			<span class="lbl">Workshop</span>
																		</label>
																	</div>
																	<div class="space-8"></div>
																	<div>
																		<label class="inline">
																			<input id="PS" type="checkbox" name="tagline" value="PS" class="ace" />
																			<span class="lbl">Pets</span>
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
			<jsp:include page="../../common/html_foot.jsp"/>
		</div><!-- /.main-container -->
<jsp:include page="../../common/jsConfig.jsp"/>
<jsp:include page="../../common/jsUtils.jsp"/>
<jsp:include page="../../common/script.jsp"/>





<script src="${ace}js/bootstrap-datepicker.min.js"></script>
<script>
function initSelectTagline(valueStr) {
	if(valueStr != "" && valueStr.length > 0) {
		var values = valueStr.split(",");
		for(var key in values) {
			$("#"+values[key]).attr("selected", true);
			$("#"+values[key]).click();
		}
	}
}
initSelectTagline("${merchant.tagline}");

var merchantStatus = "";
if("${merchant.status}" == "0") {
	merchantStatus = "merchantPending";
} else if("${merchant.status}" == "1") {
	merchantStatus = "merchantActive";
} else if("${merchant.status}" == "2") {
	merchantStatus = "merchantRejected";
} 
switchLeftActive("user", "merchantList", merchantStatus);
$('.date-picker').datepicker().next().on(ace.click_event, function(){
	$(this).prev().focus();
});
</script>

</body>
</html>

