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
								Create User
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											<form action="${base}manage/merchant/add.do" method="post" class="form-horizontal">
												<div class="tabbable">
													<jsp:include page="../create_tab.jsp"/>
													<script>
														activeCreationTab("si_merchant");
													</script>
													<div class="tab-content profile-edit-tab-content">
														<div id="create-merchant" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<span class="profile-picture">
																		<img id="merchantlogo" class="editable img-responsive" alt="Alex's Avatar" src="${base}static/images/merchant01.jpg" />
																	</span>
																</div>
																<div class="vspace-12-sm"></div>
																<div class="col-xs-12 col-sm-10">
																	<div class="form-group "> <!--error class has-error -->
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyname">Company Name</label>
																		<div class="col-sm-10">
																			<input name="merchant.companyname" class="col-xs-12 col-sm-10" type="text" id="form-field-companyname" placeholder="" value="" />
<!-- 																			<div class="help-block col-xs-12 col-sm-reset inline">* Please Enter Company Name.</div> -->
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyregno">Company Reg. No</label>
																		<div class="col-sm-10">
																			<input name="merchant.companyregno" class="col-xs-12 col-sm-10" type="text" id="form-field-companyregno" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-totalstaff">No. of Staff</label>
																		<div class="col-sm-10">
																			<input name="merchant.totalstaff" class="col-xs-12 col-sm-10" type="text" id="form-field-totalstaff" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-companytype">Company Type</label>
																		<div class="col-sm-2">
																			<select name="merchant.companytype" class="form-control" id="form-field-select-companytype">
																				<option value="AL">Sdn. Bhd.</option>
																				<option value="AK">Bhd</option>
																				<option value="AZ">Partnership</option>
																				<option value="AK">Sole Proprietor</option>
																				<option value="AZ">Others</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group hide">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyType-oths">Others</label>
																		<div class="col-sm-10">
																			<!-- merchant.companytype -->
																			<input name="" class="col-xs-12 col-sm-10" type="text" id="form-field-companyType-oths" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-industrytype">Industry</label>
																		<div class="col-sm-2">
																			<select name="merchant.industrytype"class="form-control" id="form-field-select-industrytype">
																				<option value="AL">Service</option>
																				<option value="AK">Retail</option>
																				<option value="AZ">Finance</option>
																				<option value="AK">F & B</option>
																				<option value="AZ">Public Sector</option>
																				<option value="AK">Others</option>
																				</select>
																		</div>
																	</div>
																	<div class="form-group hide">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-username">Others</label>
																		<div class="col-sm-10">
																			<!-- merchant.industrytype -->
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyaddress">Company Address</label>
																		<div class="col-sm-10">
																			<!-- merchant.companyaddress -->
																			<input name="companyaddress" class="col-xs-12 col-sm-10" type="text" id="form-field-companyaddress" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date-expireddatessm">SSM Expired Date</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="merchant.expireddatessm" class="input-medium date-picker" id="form-field-date-expireddatessm" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
																					<span class="input-group-addon">
																						<i class="ace-icon fa fa-calendar"></i>
																					</span>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-username">Username</label>
																		<div class="col-sm-10">
																			<input name="merchant.username" class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-password">Password</label>
																		<div class="col-sm-10">
																			<input name="merchant.password" class="col-xs-12 col-sm-10" type="text" id="form-field-password" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-usertitle">Title</label>
																		<div class="col-sm-2">
																			<select name="merchant.usertitle" class="form-control" id="form-field-select-usertitle">
																				<option value="AL">Mr.</option>
																				<option value="AK">Mrs.</option>
																				<option value="AZ">Mdm</option>
																				<option value="AK">Ms.</option>
																				<option value="AZ">Dr.</option>
																				<option value="AK">Others</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group hide">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-usertitle-oths">Others</label>
																		<div class="col-sm-10">
																			<!-- merchant.usertitle -->
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-usertitle-oths" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-realname">Director Name</label>
																		<div class="col-sm-10">
																			<input name="merchant.realname" class="col-xs-12 col-sm-10" type="text" id="form-field-realname" placeholder="" value="" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-credentialno">Mykad/Passport No.</label>
																		<div class="col-sm-10">
																			<input name="merchant.credentialno" class="col-xs-12 col-sm-10" type="text" id="form-field-credentialno" placeholder="" value="" />
																		</div>
																	</div>
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="form-field-email">Email</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<span class="input-icon input-icon-right"> -->
<!-- 																				<input name="merchant.email" type="email" id="form-field-email" value="" /> -->
<!-- 																				<i class="ace-icon fa fa-envelope"></i> -->
<!-- 																			</span> -->
<!-- 																		</div> -->
<!-- 																	</div> -->
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-officephone">Office Contact No.</label>
																		<div class="col-sm-10">
																			<span class="input-icon input-icon-right">
																				<input name="merchant.officephone" class="" type="text" id="form-field-officephone" />
																				<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																			</span>
																		</div>
																	</div>																	
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="form-field-phone">mobile</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<span class="input-icon input-icon-right"> -->
<!-- 																				<input name="merchant.phone" class=" input-mask-phone" type="text" id="form-field-phone" /> -->
<!-- 																				<i class="ace-icon fa fa-phone fa-flip-horizontal"></i> -->
<!-- 																			</span> -->
<!-- 																		</div> -->
<!-- 																	</div>																																		 -->
																</div>
															</div>
															<h4 class="header blue bolder smaller">Contact</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label>
																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input name="merchant.email" type="email" id="form-field-email" value="" />
																		<i class="ace-icon fa fa-envelope"></i>
																	</span>
																</div>
															</div>
<!-- 															<div class="form-group"> -->
<!-- 																<label class="col-sm-3 control-label no-padding-right" for="form-field-website">Website</label> -->
<!-- 																<div class="col-sm-9"> -->
<!-- 																	<span class="input-icon input-icon-right"> -->
<!-- 																		<input type="url" id="form-field-website" value="" /> -->
<!-- 																		<i class="ace-icon fa fa-globe"></i> -->
<!-- 																	</span> -->
<!-- 																</div> -->
<!-- 															</div> -->
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">Phone Support</label>
																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input name="merchant.phone" class="" type="text" id="form-field-phone" />
																		<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Social</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-facebook">Facebook</label>
																<div class="col-sm-9">
																	<span class="input-icon">
																		<input name="merchant.facebook" type="text" value="" id="form-field-facebook" />
																		<i class="ace-icon fa fa-facebook blue"></i>
																	</span>
																</div>
															</div>
<!-- 															<div class="form-group"> -->
<!-- 																<label class="col-sm-3 control-label no-padding-right" for="form-field-twitter">Twitter</label> -->
<!-- 																<div class="col-sm-9"> -->
<!-- 																	<span class="input-icon"> -->
<!-- 																		<input type="text" value="" id="form-field-twitter" /> -->
<!-- 																		<i class="ace-icon fa fa-twitter light-blue"></i> -->
<!-- 																	</span> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 															<div class="form-group"> -->
<!-- 																<label class="col-sm-3 control-label no-padding-right" for="form-field-gplus">Instagram</label> -->
<!-- 																<div class="col-sm-9"> -->
<!-- 																	<span class="input-icon"> -->
<!-- 																		<input type="text" value="" id="form-field-gplus" /> -->
<!-- 																		<i class="ace-icon fa fa-instagram red"></i> -->
<!-- 																	</span> -->
<!-- 																</div> -->
<!-- 															</div> -->
															<h4 class="header blue bolder smaller">
																Person In Charge
																<small>The representative who direct in charge on communicating and coordinating with Switch-inTM Team. </small>
															</h4>
															<div class="form-group">
																<div class="checkbox">
																	<label class="col-sm-7 control-label no-padding-right" >
																	<div class="col-sm-8">
																		<input onchange="switchPICSection(this);" name="form-field-checkbox" type="checkbox" class="ace">
																		<span class="lbl">Same as the director’s info</span>
																	</div>
																	</label>
																</div>
															</div>
															<div class="merchant_pic_form">
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1">Title</label>
																	<div class="col-sm-2">
																		<select class="form-control" id="form-field-select-1">
																			<option value="AL">Mr.</option>
																			<option value="AK">Mrs.</option>
																			<option value="AZ">Mdm</option>
																			<option value="AK">Ms.</option>
																			<option value="AZ">Dr.</option>
																			<option value="AK">Others</option>
																		</select>
																	</div>
																</div>
																<div class="form-group hide">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-username">Others</label>
																	<div class="col-sm-9">
																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="" />
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-username">Name</label>
																	<div class="col-sm-9">
																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="" />
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-username">Designation</label>
																	<div class="col-sm-9">
																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="" />
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label>
																	<div class="col-sm-9">
																		<span class="input-icon input-icon-right">
																			<input type="email" id="form-field-email" value="" />
																			<i class="ace-icon fa fa-envelope"></i>
																		</span>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">Office Contact No.</label>
																	<div class="col-sm-9">
																		<span class="input-icon input-icon-right">
																			<input class="" type="text" id="form-field-phone" />
																			<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																		</span>
																	</div>
																</div>																	
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">mobile</label>
																	<div class="col-sm-9">
																		<span class="input-icon input-icon-right">
																			<input class="input-mask-phone" type="text" id="form-field-phone" />
																			<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																		</span>
																	</div>
																</div>												
															</div>																						
															<h4 class="header blue bolder smaller">Company Description</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-11">Description</label>
																<div class="col-sm-9">
																<textarea id="form-field-11" class="autosize-transition form-control"></textarea>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Document</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<input type="file" />
																</div>
															</div>
															<h4 class="header blue bolder smaller">Banner Picture
																<small>Size 1440px X 550px , Maximum no exceed 500kb</small>															
															</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<input type="file" />
																</div>
															</div>
															<h4 class="header blue bolder smaller">QR Code</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<input type="file" />
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

function switchPICSection(obj) {
	if($(obj).prop('checked')) {
		$(".merchant_pic_form").hide();
	} else {
		$(".merchant_pic_form").show();
	}
}
</script>

</body>
</html>

