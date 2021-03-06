<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/common.inc"%>
<%
request.setAttribute("title", "Tables - EXL-Client");
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
											<form action="${base}manage/exlclient/edit.do" method="post" class="form-horizontal"  enctype="multipart/form-data">
												<input type="hidden" name="username" value="${client.username}">
												<div class="tabbable">
													<jsp:include page="tab.jsp"/>
													<script>
														activeCreationTab("exl_client");
													</script>
													<div class="tab-content profile-edit-tab-content">
														<div id="create-client" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General</h4>
															<div class="row">
																<div class="col-xs-12 col-sm-2">
																	<span onclick="uploadProfilePic();" class="profile-picture">
																		<c:choose>
																		   <c:when test="${empty client.profilepicture}">
																		   		<img id="profile_pic" class="editable img-responsive" alt="" src="${base}static/images/addFile.jpg"/>
																		   </c:when>
																		   <c:otherwise> 
																				<img id="profile_pic" class="editable img-responsive" alt="" src="${base}manage/img/showByPath.do?path=${client.profilepicture}"/>	
																		   </c:otherwise>
																		</c:choose>
																	</span>
																</div>
																<div class="vspace-12-sm"></div>
																<div class="col-xs-12 col-sm-10">
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-id">ClientID</label>
																		<div class="col-sm-10">
																			<input type="hidden" name="id" value="${client.id}"/>
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-id" placeholder="" value="${client.id}" disabled/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-username">Username</label>
																		<div class="col-sm-10">
																			<input name="username" class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="" value="${client.username}" disabled="disabled"/>
																		</div>
																	</div>
<!-- 																	<div class="form-group"> -->
<!-- 																		<label class="col-sm-2 control-label no-padding-right" for="form-field-password">Password</label> -->
<!-- 																		<div class="col-sm-10"> -->
<!-- 																			<input name="password" class="col-xs-12 col-sm-10" type="password" id="form-field-password" placeholder="" value="" /> -->
<!-- 																		</div> -->
<!-- 																	</div> -->
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-realname">Name</label>
																		<div class="col-sm-10">
																			<input name="realname" class="col-xs-12 col-sm-10" type="text" id="form-field-realname" placeholder="" value="${client.realname}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-date">Date of Birth</label>
																		<div class="col-sm-10">
																			<div class="input-medium">
																				<div class="input-group">
																					<input name="dob" class="input-medium date-picker" id="form-field-date" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" value="<fmt:formatDate value="${client.dob}" pattern="dd-MM-yyyy"/>"/>
																					<span class="input-group-addon">
																						<i class="ace-icon fa fa-calendar"></i>
																					</span>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-select-1">Gender</label>
																		<div class="col-sm-2">
																			<select name="sex" class="form-control" id="form-field-select-1">
																				<option value="M">Male</option>
																				<option value="F">Female</option>
																			</select>
																			<script>
																				$("#form-field-select-1").find("option[value='${client.sex}']").attr("selected",true);
																			</script>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-agentid">Agent ID No.</label>
																		<div class="col-sm-10">
																			<input name="agentid" class="col-xs-12 col-sm-10" type="text" id="form-field-agentid" placeholder="" value="${client.agentid}" />
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-2 control-label no-padding-right" for="form-field-policyno">Policy No.</label>
																		<div class="col-sm-10">
																			<input name="policyno" class="col-xs-12 col-sm-10" type="text" id="form-field-policyno" placeholder="" value="${client.policyno}" />
																		</div>
																	</div>
																</div>
															<h4 class="header blue bolder smaller">Contact</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label>
																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input name="email" type="email" id="form-field-email" value="${client.email}" />
																		<i class="ace-icon fa fa-envelope"></i>
																	</span>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">Phone No.</label>
																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input name="phone" class=" input-mask-phone" type="text" id="form-field-phone" value="${client.phone}"/>
																		<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																	</span>
																</div>
															</div>
															<h4 class="header blue bolder smaller">Social</h4>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-facebook">Facebook</label>
																<div class="col-sm-9">
																	<span class="input-icon">
																		<input name="facebook" type="text" value="${client.facebook}" id="form-field-facebook" />
																		<i class="ace-icon fa fa-facebook blue"></i>
																	</span>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-gplus">GooglePlus</label>
																<div class="col-sm-9">
																	<span class="input-icon">
																		<input name="googleplus" type="text" value="${client.googleplus}" id="form-field-gplus" />
																		<i class="ace-icon fa fa-google-plus red"></i>
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
switchLeftActive("user", "clientList", null);
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

