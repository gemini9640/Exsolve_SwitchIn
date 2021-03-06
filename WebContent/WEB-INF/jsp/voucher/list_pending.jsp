<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.inc"%>
<%
request.setAttribute("title", "Tables - Pending Voucher");
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
							<li class="active">Pending Voucher</li>
						</ul>
					</div>
					<div class="page-content">
						<div class="page-header">
							<h1>
								Pending Voucher
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Listing
								</small>
							</h1>
						</div>
						<!-- start popup box -->
						<div class="col-xs-12 col-sm-4">
							<div id="rejectForm" class="widget-box ui-widget-overlay hide" style="height: 100%; width: 100%; position: fixed; left: 0px; top: 0px; z-index: 1049; opacity: 0.3;">
								<div class="widget-header">
									<h4 class="widget-title">Reject Message</h4>
									<div class="widget-toolbar">
										<a href="#" onclick="$('#rejectForm').addClass('hide');">
											<i class="ace-icon fa fa-times"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div>
											<label for="form-field-8">Message</label>
											<textarea class="rejectReason form-control" id="form-field-8" placeholder="Reason"></textarea>
										</div>
									</div>
									<div class="form-actions center">
										<button id="submitReject" type="button" class="btn btn-sm btn-success">
											Submit
											<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<!-- end popup box -->
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<h3 class="header smaller lighter blue">Pending Voucher dataTables</h3>
										<div class="pull-left">
											<label>Date Range Picker</label>
											<div class="row">
												<div class="col-xs-3" style="float:left;">
													<div class="input-group">
														<span class="input-group-addon">
															<i class="ace-icon fa fa-calendar"></i>
														</span>
														<input class="form-control" type="text" name="date-range-picker" id="voucher-date-range-picker" />
													</div>
												</div>
												<button onclick="$('#voucher-date-range-picker').val('');" class="btn_search btn btn-primary">
													<i class="align-top"></i>
													Clear Date Picker
												</button>
												<button onclick="voucher_list(1);" class="btn_search btn btn-primary">
													<i class="align-top"></i>
													Search
												</button>
											</div>
											<label>Merchant ID</label>
											<div class="row">
												<div class="col-xs-3" style="float:left;">
													<div class="input-group">
														<input class="form-control" type="text" id="merchantId" />
													</div>
												</div>
											</div>
                                        </div>
										<div class="clearfix">
											<div class="pull-right tableTools-container"></div>
										</div>
										<div class="table-header">
											Results for "Voucher Pending"
										</div>
										<div class="dataTables_wrapper">
											<div id="sample-table-2_length" class="row voucher_sizeSelector" style="padding-bottom: 0px;">
											</div>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th class="center">
															<label class="pos-rel">
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</th>
														<th>ID</th>
														<th>Voucher Title</th>
														<th>Merchant ID</th>
														<th>Quantity</th>
														<th>Expired date</th>
														<th>Voucher type</th>
														<th class="hidden-480">Action</th>
														<th></th>
													</tr>
												</thead>
												<tbody class="tabaleData_voucher">
												</tbody>
											</table>
											<div class="row voucher_pageInfo">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				switchLeftActive("voucher", null, "voucherPending");
			</script>
			<jsp:include page="../common/html_foot.jsp"/>
		</div><!-- /.main-container -->
<jsp:include page="../common/jsConfig.jsp"/>
<jsp:include page="../common/jsUtils.jsp"/>
<jsp:include page="../common/script.jsp"/>
<script>
$.DateTimeConfig.init("#voucher-date-range-picker");
$.TableDataConfig.generateSizeSelector("voucher", 25);

function voucher_list(pageNumber) {
	var dateRange = new $.DateTimeConfig.DateRange($('#voucher-date-range-picker').val());
	$(".tabaleData_voucher").html("");
	$.post("${base}manage/voucher/listByProperties.do", {
		merchantId : $("#merchantId").val(),
		status : 1,
		start : dateRange.start,
		end : dateRange.end,
		pageNum : pageNumber,
		pageSize : $("#voucher_size_selected").val()
	},function(result) {
		voucher_html(result);
	});
}

function voucher_html(result) {
	if(result.status == 0) {
		var pageResp = result.data;
		var data = pageResp.list;
		var tr = "";
		for(var key in data) {
			var voucher = data[key];
			tr += "<tr id='tr_"+voucher.id+"'>"+
					"<td class='center'>"+
						"<label class='pos-rel'>"+
							"<input type='checkbox' class='ace' />"+
							"<span class='lbl'></span>"+
						"</label>"+
					"</td>"+
					"<td class='dataValue'>"+
						"<a href='${base}manage/voucher/detail.do?voucherId="+voucher.id+"&status="+voucher.status+"'>"+voucher.id+"</a>"+
					"</td>"+
					"<td class='dataValue'>"+voucher.voucherTitle+"</td>"+
					"<td class='dataValue'>"+voucher.merchantId+"</td>"+
					"<td class='dataValue'>"+voucher.quantity+"</td>"+
					"<td class='dataValue'>"+$.JsUtil.convertDate(voucher.endDate)+"</td>"+
					"<td class='dataValue'>"+voucher.voucherType+"</td>"+	
					"<td class='hidden-480'>"+
						"<button onclick='activeVoucher(\""+voucher.id+"\");' class='btn btn-minier btn-success'>Approve</button>"+
						"<button onclick='rejectForm(\""+voucher.id+"\");' class='btn btn-minier btn-danger'>Reject</button>"+
					"</td>"+
					"<td>"+
						"<div class='hidden-sm hidden-xs action-buttons'>"+
							"<a class='blue' href='#'>"+
								"<i class='ace-icon fa fa-search-plus bigger-130'></i>"+
							"</a>"+
							"<a class='green'  href='${base}manage/voucher/detail.do?voucherId="+voucher.id+"&status="+voucher.status+"'>"+
								"<i class='ace-icon fa fa-pencil bigger-130'></i>"+
							"</a>"+
							"<a class='red' href='#'>"+
								"<i class='ace-icon fa fa-trash-o bigger-130'></i>"+
							"</a>"+
						"</div>"+
					"</td>"+
				"</tr>";
		}
		$(".tabaleData_voucher").html(tr);
		$.JsUtil.undefinedRed(".dataValue");	
		$.TableDataConfig.pagination("voucher", pageResp.pageSize, pageResp.navigatepageNums, pageResp.pageNum, pageResp.startRow, pageResp.endRow, pageResp.total);
	}
}
voucher_list(1);

function activeVoucher(id) {
	$.post("${base}manage/voucher/ajaxEdit.do", {
		id : id,
		status : 2
	},function(result) {
		if(result.status == 0) {
			alert("voucher status updated.");
			$("#tr_"+id).remove();
		} else {
			alert(result.msg);
		}
	});
}

function rejectForm(id) {
	$("#submitReject").attr("onclick","rejectVoucher('"+id+"');");
	$("#rejectForm").removeClass("hide");
}

function rejectVoucher(id) {
	$.post("${base}manage/voucher/ajaxEdit.do", {
		id : id,
		rejectReason : $(".rejectReason").val(),
		status : 4
	},function(result) {
		if(result.status == 0) {
			alert("voucher status updated.");
			$("#tr_"+id).remove();
			$("#rejectForm").addClass("hide");
			$(".rejectReason").val("");
		} else {
			alert(result.msg);
		}
	});
}
</script>



<!-- dynamiic-table -->
<script src="${ace}js/jquery.dataTables.min.js"></script>
<script src="${ace}js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${ace}js/dataTables.buttons.min.js"></script>
<script src="${ace}js/buttons.flash.min.js"></script>
<script src="${ace}js/buttons.html5.min.js"></script>
<script src="${ace}js/buttons.print.min.js"></script>
<script src="${ace}js/buttons.colVis.min.js"></script>
<script src="${ace}js/dataTables.select.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		//initiate dataTables plugin
		var myTable =  $('#dynamic-table')
		.DataTable( {
			bAutoWidth: false,
			"aoColumns": [
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false },
			  { "bSortable": false }
			],
			"aaSorting": [],
			"bPaginate": false,
			"bInfo": false, 
			"searching": false,select: {
				style: 'multi'
			}
	    } );
	
		
		
		$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
		
		new $.fn.dataTable.Buttons( myTable, {
			buttons: [
			  {
				"extend": "colvis",
				"text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
				"className": "btn btn-white btn-primary btn-bold",
				columns: ':not(:first):not(:last)'
			  },
			  {
				"extend": "copy",
				"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "csv",
				"text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "excel",
				"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "pdf",
				"text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "print",
				"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
				"className": "btn btn-white btn-primary btn-bold",
				autoPrint: false,
				message: 'This print was produced using the Print button for DataTables'
			  }		  
			]
		} );
		myTable.buttons().container().appendTo( $('.tableTools-container') );
		
		var defaultCopyAction = myTable.button(1).action();
		myTable.button(1).action(function (e, dt, button, config) {
			defaultCopyAction(e, dt, button, config);
			$('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
		});
		
		
		var defaultColvisAction = myTable.button(0).action();
		myTable.button(0).action(function (e, dt, button, config) {
			
			defaultColvisAction(e, dt, button, config);
			
			
			if($('.dt-button-collection > .dropdown-menu').length == 0) {
				$('.dt-button-collection')
				.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
				.find('a').attr('href', '#').wrap("<li />")
			}
			$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
		});
	
// 		////
	
		setTimeout(function() {
			$($('.tableTools-container')).find('a.dt-button').each(function() {
				var div = $(this).find(' > div').first();
				if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
				else $(this).tooltip({container: 'body', title: $(this).text()});
			});
		}, 500);
		
		
		
		myTable.on( 'select', function ( e, dt, type, index ) {
			if ( type === 'row' ) {
				$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', true);
			}
		} );
		myTable.on( 'deselect', function ( e, dt, type, index ) {
			if ( type === 'row' ) {
				$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', false);
			}
		} );
	
	
	
// 		/////////////////////////////////
// 		//table checkboxes
		$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
		
		//select/deselect all rows according to table header checkbox
		$('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
			var th_checked = this.checked;//checkbox inside "TH" table header
			
			$('#dynamic-table').find('tbody > tr').each(function(){
				var row = this;
				if(th_checked) myTable.row(row).select();
				else  myTable.row(row).deselect();
			});
		});
		
// 		//select/deselect a row when the checkbox is checked/unchecked
		$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
			var row = $(this).closest('tr').get(0);
			if(this.checked) myTable.row(row).deselect();
			else myTable.row(row).select();
		});
		
// 		//And for the first simple table, which doesn't have TableTools or dataTables
// 		//select/deselect all rows according to table header checkbox
		var active_class = 'active';
		$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
			var th_checked = this.checked;//checkbox inside "TH" table header
			
			$(this).closest('table').find('tbody > tr').each(function(){
				var row = this;
				if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
				else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
			});
		});
		
		//select/deselect a row when the checkbox is checked/unchecked
		$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
			var $row = $(this).closest('tr');
			if($row.is('.detail-row ')) return;
			if(this.checked) $row.addClass(active_class);
			else $row.removeClass(active_class);
		});
	});
</script>
</body>
</html>

