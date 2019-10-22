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
								Create Voucher
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											<form class="form-horizontal" action="${base}manage/voucher/add.do" method="post">
												<div class="tabbable">
													<ul class="nav nav-tabs padding-16">
														<li class="active">
															<a data-toggle="tab" href="#create-voucher">
																Basic Info
															</a>
														</li>
													</ul>
													<div class="tab-content profile-edit-tab-content">
														<div id="create-voucher" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General Info</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-10">
																	<div class="form-group"><!--  has-error -->
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-vouchertitle">voucher Title</label>
																		<div class="col-sm-10">
																			<input name="voucherTitle" class="col-xs-12 col-sm-10" type="text" id="form-field-vouchertitle" placeholder="" value="" />
<!-- 																			<div class="help-block col-xs-12 col-sm-reset inline">* Please Enter Voucher Title.</div> -->
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-1">Voucher Type</label>
																		<div class="col-sm-2">
																			<select name="voucherType" class="form-control" id="form-field-select-voucherType">
																				<option value="NORMAL">Normal</option>
																				<option value="PERMIUM">Premium</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date-startdate">Started Date</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="startDate" class="input-medium date-picker" id="form-field-date-startdate" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
																					<span class="input-group-addon">
																						<i class="ace-icon fa fa-calendar"></i>
																					</span>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date-enddate">Ended Date</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="endDate" class="input-medium date-picker" id="form-field-date-enddate" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
																					<span class="input-group-addon">
																						<i class="ace-icon fa fa-calendar"></i>
																					</span>
																				</div>
																			</div>
																		</div>
																	</div>
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="startTime">Start Time</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<div class="input-medium"> -->
<!-- 																				<div class="input-group bootstrap-timepicker"> -->
<!-- 																					<input name="starttime" id="startTime" type="text" class="form-control" /> -->
<!-- 																					<span class="input-group-addon"> -->
<!-- 																						<i class="fa fa-clock-o bigger-110"></i> -->
<!-- 																					</span> -->
<!-- 																				</div> -->
<!-- 																			</div> -->
<!-- 																		</div> -->
<!-- 																	</div> -->
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="endTime">End Time</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<div class="input-medium"> -->
<!-- 																				<div class="input-group bootstrap-timepicker"> -->
<!-- 																					<input name="endtime" id="endTime" type="text" class="form-control" /> -->
<!-- 																					<span class="input-group-addon"> -->
<!-- 																						<i class="fa fa-clock-o bigger-110"></i> -->
<!-- 																					</span> -->
<!-- 																				</div> -->
<!-- 																			</div> -->
<!-- 																		</div> -->
<!-- 																	</div> -->
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-maxpax">Quantity</label>
																		<div class="col-sm-10">
																			<input name="quantity" class="col-xs-12 col-sm-10" type="text" id="form-field-quantity" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-address">Address</label>
																		<div class="col-sm-10">
																			<input name="address" class="col-xs-12 col-sm-10" type="text" id="form-field-address" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-csphone">Customer Service Number</label>
																		<div class="col-sm-10">
																			<span class="input-icon input-icon-right">
																				<input name="csphone" class="" type="text" id="form-field-csphone" />
																				<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																			</span>
																		</div>
																	</div>																	
																</div>
															</div>
															<h4 class="header blue bolder smaller">Merchant Info</h4>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-merchantId">Merchant ID</label>
																<div class="col-sm-10">
																	<span>
																		<input name="merchantId" type="text" value="" id="form-field-merchantId" />
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Social Media</h4>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-facebook">Facebook</label>
																<div class="col-sm-10">
																	<span class="input-icon">
																		<input name="facebook" type="text" value="" id="form-field-facebook" />
																		<i class="ace-icon fa fa-facebook blue"></i>
																	</span>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-instagram">Instagram</label>
																<div class="col-sm-10">
																	<span class="input-icon">
																		<input name="instagram" type="text" value="" id="form-field-instagram" />
																		<i class="ace-icon fa fa-instagram red"></i>
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Others Info</h4>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-11">Description</label>
																<div class="col-sm-10">
																<textarea name="description" id="form-field-11" class="autosize-transition form-control"></textarea>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-reminder">Reminder</label>
																<div class="col-sm-10">
																<textarea name="reminder" id="form-field-reminder" class="autosize-transition form-control"></textarea>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-tnc">Term & Condition</label>
																<div class="col-sm-10">
																<textarea name="tnc" id="form-field-tnc" class="autosize-transition form-control"></textarea>
																</div>
															</div>
														</div>

													</div>
													<div class="clearfix form-actions">
														<div class="col-md-offset-3 col-md-9">
<!-- 															<button class="btn btn-success" type="button"> -->
<!-- 																<i class="ace-icon fa fa-floppy-o bigger-110"></i> -->
<!-- 																Save Draft -->
<!-- 															</button> -->
															&nbsp; &nbsp;
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

function uploadProfilePic() {
	$("#uploadFile").click();
}
$.UploadConfig.onchange("#uploadFile", "#profile_pic");
</script>

</body>
</html>

