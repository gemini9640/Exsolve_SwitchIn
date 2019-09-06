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
								SI-Merchant Info
							</h1>
						</div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-0 col-sm-12">
											<div class="space"></div>
											<form action="${base}manage/merchant/edit.do" method="post" class="form-horizontal" enctype="multipart/form-data">
												<input type="hidden" name="lastloginpicid" value="${merchant.lastloginpicid}">
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("si_merchant");
													</script>
													<div class="tab-content profile-edit-tab-content">
														<div id="create-merchant" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<span onclick="uploadProfilePic();" class="profile-picture">
																		<img id="profile_pic" class="editable img-responsive" alt="" src="${base}manage/img/showByPath.do?path=${merchant.companylogo}" />
																	</span>
																</div>
																<div class="vspace-12-sm"></div>
																<div class="col-xs-12 col-sm-10">
																	<div class="form-group "> <!--error class has-error -->
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-id">SI-Merchant ID</label>
																		<div class="col-sm-10">
																			<input name="id" class="col-xs-12 col-sm-10" type="hidden" placeholder="" value="${merchant.id}" />
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-id" placeholder="" value="${merchant.id}" disabled/>
																		</div>
																	</div>
																	<div class="form-group "> <!--error class has-error -->
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyname">Company Name</label>
																		<div class="col-sm-10">
																			<input name="companyname" class="col-xs-12 col-sm-10" type="text" id="form-field-companyname" placeholder="" value="${merchant.companyname}" />
<!-- 																			<div class="help-block col-xs-12 col-sm-reset inline">* Please Enter Company Name.</div> -->
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyregno">Company Reg. No</label>
																		<div class="col-sm-10">
																			<input name="companyregno" class="col-xs-12 col-sm-10" type="text" id="form-field-companyregno" placeholder="" value="${merchant.companyregno}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-totalstaff">No. of Staff</label>
																		<div class="col-sm-10">
																			<input name="totalstaff" class="col-xs-12 col-sm-10" type="text" id="form-field-totalstaff" placeholder="" value="${merchant.totalstaff}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-companytype">Company Type</label>
																		<div class="col-sm-2">
																			<input id="hidden_type" type="hidden" value="${merchant.companytype}">
																			<select onchange="changeCompanyType();" class="form-control" id="form-field-select-companytype">
																				<option value="SB">Sdn. Bhd.</option>
																				<option value="BHD">Bhd</option>
																				<option value="PNS">Partnership</option>
																				<option value="SP">Sole Proprietor</option>
																				<option value="oths">Others</option>
																			</select>
																		</div>
																	</div>
																	<div id="type_oths" class="form-group hide">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyType-oths">Others</label>
																		<div class="col-sm-10">
																			<!-- merchant.companytype -->
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-companyType-oths" placeholder="" value="" />
																		</div>
																	</div>
																	<script>
																		var isOthsType = true;
																		$("#form-field-select-companytype option").each(function() {
																			if($(this).val()=='${merchant.companytype}') {
																				$(this).attr("selected",true);
																				isOthsType = false;
																			}
																		}); 
																		if(isOthsType) {
																			$("#form-field-select-companytype").find("option[value='oths']").attr("selected",true);
																			$("#type_oths").removeClass("hide");
																			$("#hidden_type").attr("name","");
																			$("#form-field-companyType-oths").attr("name","companytype");
																			$("#form-field-companyType-oths").val('${merchant.companytype}');
																		} else {
																			$("#type_oths").addClass("hide");
																			$("#form-field-companyType-oths").attr("name","");
																			$("#hidden_type").attr("name","companytype");
																			$("#hidden_type").val("${merchant.companytype}");
																		}
																		
																		function changeCompanyType() {
																			if($("#form-field-select-companytype").val()=="oths") {
																				$("#type_oths").removeClass("hide");
																				$("#form-field-companyType-oths").attr("name","companytype");
																				$("#hidden_type").attr("name","");
																			} else {
																				$("#type_oths").addClass("hide");
																				$("#hidden_type").val($("#form-field-select-companytype").val());
																				$("#hidden_type").attr("name","companytype");
																				$("#form-field-companyType-oths").attr("name","");
																			}
																		}
																	</script>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-industrytype">Industry</label>
																		<div class="col-sm-2">
																			<input id="hidden_industrytype" type="hidden" value="${merchant.industrytype}" />
																			<select onchange="changeIndustrytypeType();" class="form-control" id="form-field-select-industrytype">
																				<option value="service">Service</option>
																				<option value="retail">Retail</option>
																				<option value="finance">Finance</option>
																				<option value="fb">F & B</option>
																				<option value="publicSector">Public Sector</option>
																				<option value="oths">Others</option>
																			</select>
																		</div>
																	</div>
																	<div id="industrytype_oths" class="form-group hide">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-industrytype">Others</label>
																		<div class="col-sm-10">
																			<!-- merchant.industrytype -->
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-industrytype-oths" placeholder="" value="" />
																		</div>
																	</div>
																	<script>
																		var isOthsIndustrytype = true;
																		$("#form-field-select-industrytype option").each(function() {
																			if($(this).val()=='${merchant.industrytype}') {
																				$(this).attr("selected",true);
																				isOthsIndustrytype = false;
																			}
																		}); 
																		if(isOthsIndustrytype) {
																			$("#form-field-select-industrytype").find("option[value='oths']").attr("selected",true);
																			$("#industrytype_oths").removeClass("hide");
																			$("#hidden_industrytype").attr("name","");
																			$("#form-field-industrytype-oths").attr("name","industrytype");
																			$("#form-field-industrytype-oths").val('${merchant.industrytype}');
																		} else {
																			$("#industrytype_oths").addClass("hide");
																			$("#form-field-industrytype-oths").attr("name","");
																			$("#hidden_industrytype").attr("name","industrytype");
																			$("#hidden_industrytype").val("${merchant.industrytype}");
																		}
																		
																		function changeIndustrytypeType() {
																			if($("#form-field-select-industrytype").val()=="oths") {
																				$("#industrytype_oths").removeClass("hide");
																				$("#form-field-industrytype-oths").attr("name","industrytype");
																				$("#hidden_industrytype").attr("name","");
																			} else {
																				$("#industrytype_oths").addClass("hide");
																				$("#hidden_industrytype").val($("#form-field-select-industrytype").val());
																				$("#hidden_industrytype").attr("name","industrytype");
																				$("#form-field-industrytype-oths").attr("name","");
																			}
																		}
																	</script>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-companyaddress">Company Address</label>
																		<div class="col-sm-10">
																			<!-- merchant.companyaddress -->
																			<input name="companyaddress" class="col-xs-12 col-sm-10" type="text" id="form-field-companyaddress" placeholder="" value="${merchant.companyaddress}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date-expireddatessm">SSM Expired Date</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="expireddatessm" class="input-medium date-picker" id="form-field-date-expireddatessm" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" value="<fmt:formatDate value="${merchant.expireddatessm}" pattern="dd-MM-yyyy"/>"/>
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
																			<input name="username" class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="${merchant.username}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-usertitle">Title</label>
																		<div class="col-sm-2">
																			<select name="usertitle" class="form-control" id="form-field-select-usertitle" >
																				<option value="none"></option>
																				<option value="Mr">Mr.</option>
																				<option value="Mrs">Mrs.</option>
																				<option value="Mdm">Mdm</option>
																				<option value="Ms">Ms.</option>
																				<option value="Dr">Dr.</option>
																			</select>
																			<script>
																				$("#form-field-select-usertitle").find("option[value='${merchant.usertitle}']").attr("selected",true);
																			</script>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-realname">Director Name</label>
																		<div class="col-sm-10">
																			<input name="realname" class="col-xs-12 col-sm-10" type="text" id="form-field-realname" placeholder="" value="${merchant.realname}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-credentialno">Mykad/Passport No.</label>
																		<div class="col-sm-10">
																			<input name="credentialno" class="col-xs-12 col-sm-10" type="text" id="form-field-credentialno" placeholder="" value="${merchant.credentialno}" />
																		</div>
																	</div>
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="form-field-email">Email</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<span class="input-icon input-icon-right"> -->
<!-- 																				<input name="email" type="email" id="form-field-email" value="" /> -->
<!-- 																				<i class="ace-icon fa fa-envelope"></i> -->
<!-- 																			</span> -->
<!-- 																		</div> -->
<!-- 																	</div> -->
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-officephone">Office Contact No.</label>
																		<div class="col-sm-10">
																			<span class="input-icon input-icon-right">
																				<input name="officephone" class="" type="text" id="form-field-officephone" value="${merchant.officephone}"/>
																				<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																			</span>
																		</div>
																	</div>																	
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="form-field-phone">mobile</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<span class="input-icon input-icon-right"> -->
<!-- 																				<input name="phone" class=" input-mask-phone" type="text" id="form-field-phone" /> -->
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
																		<input name="email" type="email" id="form-field-email" value="${merchant.email}" />
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
																		<input name="phone" class="" type="text" id="form-field-phone" value="${merchant.phone}"/>
																		<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Social</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-facebook">Facebook</label>
																<div class="col-sm-9">
																	<span class="input-icon">
																		<input name="facebook" type="text" value="${merchant.facebook}" id="form-field-facebook" />
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


<!-- 															pic -->
<!-- 															<h4 class="header blue bolder smaller"> -->
<!-- 																Person In Charge -->
<!-- 																<small>The representative who direct in charge on communicating and coordinating with Switch-inTM Team. </small> -->
<!-- 															</h4> -->
<!-- 															<div class="form-group"> -->
<!-- 																<div class="checkbox"> -->
<!-- 																	<label class="col-sm-7 control-label no-padding-right" > -->
<!-- 																	<div class="col-sm-8"> -->
<!-- 																		<input onchange="switchPICSection(this);" name="form-field-checkbox" type="checkbox" class="ace"> -->
<!-- 																		<span class="lbl">Same as the director’s info</span> -->
<!-- 																	</div> -->
<!-- 																	</label> -->
<!-- 																</div> -->
<!-- 															</div> -->
<!-- 															<div class="merchant_pic_form"> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1">Title</label> -->
<!-- 																	<div class="col-sm-2"> -->
<!-- 																		<select name="merchantPIC.title" class="form-control" id="form-field-select-1"> -->
<!-- 																			<option value="none"></option> -->
<!-- 																			<option value="Mr">Mr.</option> -->
<!-- 																			<option value="Mrs">Mrs.</option> -->
<!-- 																			<option value="Mdm">Mdm</option> -->
<!-- 																			<option value="Ms">Ms.</option> -->
<!-- 																			<option value="Dr">Dr.</option> -->
<!-- 																		</select> -->
																		<script>
// 																			$("#form-field-select-1").find("option[value='${merchantPIC.title}']").attr("selected",true);
																		</script>
<!-- 																	</div> -->
<!-- 																</div> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-username">User Name</label> -->
<!-- 																	<div class="col-sm-9"> -->
<%-- 																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" name="merchantPIC.username" placeholder="" value="${merchantPIC.username}" /> --%>
<!-- 																	</div> -->
<!-- 																</div> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-realname">Name</label> -->
<!-- 																	<div class="col-sm-9"> -->
<%-- 																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-realname" name="merchantPIC.realname" placeholder="" value="${merchantPIC.realname}" /> --%>
<!-- 																	</div> -->
<!-- 																</div> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-designation">Designation</label> -->
<!-- 																	<div class="col-sm-9"> -->
<%-- 																		<input class="col-xs-12 col-sm-10" type="text" id="form-field-designation" name="merchantPIC.discription" placeholder="" value="${merchantPIC.discription}" /> --%>
<!-- 																	</div> -->
<!-- 																</div> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label> -->
<!-- 																	<div class="col-sm-9"> -->
<!-- 																		<span class="input-icon input-icon-right"> -->
<%-- 																			<input type="email" id="form-field-email" name="merchantPIC.email" value="${merchantPIC.email}" /> --%>
<!-- 																			<i class="ace-icon fa fa-envelope"></i> -->
<!-- 																		</span> -->
<!-- 																	</div> -->
<!-- 																</div> -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-officeContent">Office Contact No.</label> -->
<!-- 																	<div class="col-sm-9"> -->
<!-- 																		<span class="input-icon input-icon-right"> -->
<!-- 																			<input class="" type="text" id="form-field-officeContent"/> -->
<!-- 																			<i class="ace-icon fa fa-phone fa-flip-horizontal"></i> -->
<!-- 																		</span> -->
<!-- 																	</div> -->
<!-- 																</div>																	 -->
<!-- 																<div class="form-group"> -->
<!-- 																	<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">mobile</label> -->
<!-- 																	<div class="col-sm-9"> -->
<!-- 																		<span class="input-icon input-icon-right"> -->
<%-- 																			<input class="input-mask-phone" type="text" id="form-field-phone" name="merchantPIC.phone" value="${merchantPIC.phone}"/> --%>
<!-- 																			<i class="ace-icon fa fa-phone fa-flip-horizontal"></i> -->
<!-- 																		</span> -->
<!-- 																	</div> -->
<!-- 																</div>												 -->
<!-- 															</div>																						 -->
															<h4 class="header blue bolder smaller">Company Description</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-11">Description</label>
																<div class="col-sm-9">
																<textarea id="form-field-11" class="autosize-transition form-control"  name="companydiscription">${merchant.companydiscription}</textarea>
																</div>
															</div>
															<!-- 
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
															 -->
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

function switchPICSection(obj) {
	if($(obj).prop('checked')) {
		$(".merchant_pic_form").hide();
	} else {
		$(".merchant_pic_form").show();
	}
}
function uploadProfilePic() {
	$("#uploadFile").click();
}
$.UploadConfig.onchange("#uploadFile", "#profile_pic");
</script>

</body>
</html>

