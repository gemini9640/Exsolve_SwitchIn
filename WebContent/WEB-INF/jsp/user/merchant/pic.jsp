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
											<form action="${base}manage/merchant/edit_pic.do" method="post" class="form-horizontal">
												<input type="hidden" name="id" value="${pic.id}">
												<input type="hidden" name="merchantid" value="${pic.merchantid}">
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("si_merchant_pic");
													</script>
													<div class="tab-content profile-edit-tab-content">
														<div id="create-merchant" class="tab-pane in active">

<!-- 															pic -->
															<h4 class="header blue bolder smaller">
																Person In Charge
																<small>The representative who direct in charge on communicating and coordinating with Switch-inTM Team. </small>
															</h4>
															<div class="form-group">
<!-- 																<div class="checkbox"> -->
<!-- 																	<label class="col-sm-7 control-label no-padding-right" > -->
<!-- 																		<div class="col-sm-8"> -->
<!-- 																			<input onchange="switchPICSection(this);" name="form-field-checkbox" type="checkbox" class="ace"> -->
<!-- 																			<span class="lbl">Same as the director’s info</span> -->
<!-- 																		</div> -->
<!-- 																	</label> -->
<!-- 																</div> -->
															</div>
															<div class="merchant_pic_form">
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1">Title</label>
																	<div class="col-sm-2">
																		<select name="title" class="form-control" id="form-field-select-1">
																			<option value="none"></option>
																			<option value="Mr">Mr.</option>
																			<option value="Mrs">Mrs.</option>
																			<option value="Mdm">Mdm</option>
																			<option value="Ms">Ms.</option>
																			<option value="Dr">Dr.</option>
																		</select>
																		<script>
																			$("#form-field-select-1").find("option[value='${pic.title}']").attr("selected",true);
																		</script>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-username">User Name</label>
																	<div class="col-sm-9">
																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" name="username" placeholder="" value="${pic.username}" />
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-realname">Name</label>
																	<div class="col-sm-9">
																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-realname" name="realname" placeholder="" value="${pic.realname}" />
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-designation">Designation</label>
																	<div class="col-sm-9">
																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-designation" name="discription" placeholder="" value="${pic.discription}" />
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label>
																	<div class="col-sm-9">
																		<span class="input-icon input-icon-right">
																			<input type="email" id="form-field-email" name="email" value="${pic.email}" />
																			<i class="ace-icon fa fa-envelope"></i>
																		</span>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-officeContent">Office Contact No.</label>
																	<div class="col-sm-9">
																		<span class="input-icon input-icon-right">
																			<input name="officephone" class="" type="text" id="form-field-officeContent" value="${pic.officephone}"/>
																			<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																		</span>
																	</div>
																</div>																	
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">mobile</label>
																	<div class="col-sm-9">
																		<span class="input-icon input-icon-right">
																			<input class="input-mask-phone" type="text" id="form-field-phone" name="phone" value="${pic.phone}"/>
																			<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																		</span>
																	</div>
																</div>												
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
												</div>
												<input id="uploadFile" type="file" name="file" style="display:none;"/>
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
$('.date-picker').datepicker().next().on(ace.click_event, function(){
	$(this).prev().focus();
});

// function switchPICSection(obj) {
// 	if($(obj).prop('checked')) {
// 		$(".merchant_pic_form").hide();
// 	} else {
// 		$(".merchant_pic_form").show();
// 	}
// }
</script>

</body>
</html>

