<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.inc"%>
<%
request.setAttribute("title", "Tables - Event");
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
								<a href="#">Event Management</a>
							</li>
						</ul>
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								Create Event
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											<form class="form-horizontal" action="${base}manage/event/edit.do" method="post">
												<input name="id" type="hidden" value="${event.id}"/>
												<div class="tabbable">
													<ul class="nav nav-tabs padding-16">
														<li class="active">
															<a data-toggle="tab" href="#create-event">
																Basic Info
															</a>
														</li>
													</ul>
													<div class="tab-content profile-edit-tab-content">
														<div id="create-event" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General Info</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-10">
																	<div class="form-group"><!--  has-error -->
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-eventname">Event Title</label>
																		<div class="col-sm-10">
																			<input name="eventname" class="col-xs-12 col-sm-10" type="text" id="form-field-eventname" placeholder="" value="${event.eventname}" />
<!-- 																			<div class="help-block col-xs-12 col-sm-reset inline">* Please Enter Voucher Title.</div> -->
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date-startdate">Started Date & Time</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="startdate" value="<fmt:formatDate value="${event.startdate}" pattern="dd-MM-yyyy"/>" class="input-medium date-picker" id="form-field-date-startdate" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
																					<span class="input-group-addon">
																						<i class="ace-icon fa fa-calendar"></i>
																					</span>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date-enddate">Ended Date & Time</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="enddate" value="<fmt:formatDate value="${event.enddate}" pattern="dd-MM-yyyy"/>" class="input-medium date-picker" id="form-field-date-enddate" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
																					<span class="input-group-addon">
																						<i class="ace-icon fa fa-calendar"></i>
																					</span>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-maxpax">Max Pax</label>
																		<div class="col-sm-10">
																			<input name="maxpax" value="${event.maxpax}" class="col-xs-12 col-sm-10" type="text" id="form-field-maxpax" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-maxpaxperregister">Max Pax Per Register</label>
																		<div class="col-sm-10">
																			<input name="maxpaxperregister" value="${event.maxpaxperregister}" class="col-xs-12 col-sm-10" type="text" id="form-field-maxpaxperregister" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-price">Price/Pax</label>
																		<div class="col-sm-10">
																			<input name="price" value="${event.price}" class="col-xs-12 col-sm-10" type="text" id="form-field-price" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-address">Address</label>
																		<div class="col-sm-10">
																			<input name="address" value="${event.address}" class="col-xs-12 col-sm-10" type="text" id="form-field-address" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-csphone">Customer Service Number</label>
																		<div class="col-sm-10">
																			<span class="input-icon input-icon-right">
																				<input name="csphone" value="${event.csphone}" class="" type="text" id="form-field-csphone" />
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
																		<input name="merchantId" value="${event.merchantId}" type="text" value="" id="form-field-merchantId" />
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Social</h4>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-facebook">Facebook</label>
																<div class="col-sm-10">
																	<span class="input-icon">
 																		<!--name = facebook  -->
																		<input name="facebook" type="text" value="${event.facebook}" value="" id="form-field-facebook" />
																		<i class="ace-icon fa fa-facebook blue"></i>
																	</span>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-twitter">Twitter</label>
																<div class="col-sm-10">
																	<span class="input-icon">
																		<!--name = twitter  -->
																		<input name="twitter" type="text" value="${event.twitter}" id="form-field-twitter" />
																		<i class="ace-icon fa fa-twitter light-blue"></i>
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Others Info</h4>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-11">Description</label>
																<div class="col-sm-10">
																<textarea name="description" id="form-field-11" class="autosize-transition form-control">${event.description}</textarea>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-reminder">Reminder</label>
																<div class="col-sm-10">
																<textarea name="reminder" id="form-field-reminder" class="autosize-transition form-control">${event.reminder}</textarea>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label no-padding-right" for="form-field-remark">Term & Condition</label>
																<div class="col-sm-10">
																<textarea name="remark" id="form-field-remark" class="autosize-transition form-control">${event.remark}</textarea>
																</div>
															</div>
														</div>

													</div>
													<div class="clearfix form-actions">
														<div class="col-md-offset-3 col-md-9">
															<button class="btn btn-success" type="button">
																<i class="ace-icon fa fa-floppy-o bigger-110"></i>
																Save Draft
															</button>
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
				switchLeftActive("event", null, "eventCreate");
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
function uploadProfilePic() {
	$("#uploadFile").click();
}
$.UploadConfig.onchange("#uploadFile", "#profile_pic");
</script>

</body>
</html>

