<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 加这个空标签可以是以下的js方法正常执行 无解 -->
<script></script>
<script>
$.DateTimeConfig = {
		init : function(dateTimeSelector) {
			$(dateTimeSelector).daterangepicker({
		   	        ranges: {
		   	            'Today': [moment(),moment()],
		   	            'Yestoday': [moment().subtract(1, 'days'),moment().subtract(1, 'days')],
		   	            'Last 7 days': [moment().subtract(6, 'days'), moment()],
		   	            'This month': [moment().startOf('month'), moment().endOf('month')],
		   	            'Last month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
		   	        },
		   	        locale: {
		   	        	format: "DD/MM/YYYY",
		   	        	separator : " to ",
		   	            applyLabel: "Apply",
		   	            cancelLabel: "Cancel",
		   	            fromLabel: "start date",
		   	            toLabel: "end date",
		   	            customRangeLabel: "Custom",
		   	            daysOfWeek: ["SUN","MON","TUE","WED","THU","FRI","STA"],
		   	            monthNames: ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SET","OCT","NOV","DEC"]
		   	        }
			   	}).prev().on(ace.click_event, function(){
				 	$(this).next().focus();
			 });
			$.DateTimeConfig.resetDateTimePicker($(dateTimeSelector)); 
		},
		resetDateTimePicker : function(picker) {
			picker.val("");
// 			picker.val(moment().subtract(6, 'days').format('DD/MM/YYYY') + ' to ' + moment().format('DD/MM/YYYY'));
		},
		DateRange : function(rangePicker) {
			var startDate = $.trim(rangePicker.split("to")[0]);
			var endDate = $.trim(rangePicker.split("to")[1]);
			this.start = startDate==""?"":startDate+ " 00:00:00";
			this.end = + endDate==""?"":endDate+ " 23:59:59";
		}
}

$.TableDataConfig = {
		generateSizeSelector : function(selectGroup, pageSize) {
			var sizeSelector = $.TableDataConfig.htmlSizeSelector(selectGroup, pageSize);
			$("."+selectGroup+"_sizeSelector").html(sizeSelector);
		},
		pagination : function (selectGroup, pageSize, navigatepage, nowPage, firstRow, lastRow, totalRow) {
			$.TableDataConfig.generateSizeSelector(selectGroup, pageSize);
			var navigation = "";
			for(var index in navigatepage) {
				var active = "";
				if(navigatepage[index] == nowPage) {
					active = "active";
				}
				navigation+="<li class='pageNumber "+active+"'><a href='javascript:void(0);' "+$.TableDataConfig.generateQueryFunc(selectGroup, navigatepage[index])+">"+navigatepage[index]+"</a></li>"; 
			}
			var prevPage = "";
			var nextPage = "";
			if(nowPage-1>0) {
				prevPage = "<li class='prev'><a href='javascript:void(0);' "+$.TableDataConfig.generateQueryFunc(selectGroup, nowPage-1)+">Previous</a></li> ";
			} 
			if(nowPage<navigatepage.length) {
				nextPage = "<li class='next'><a href='javascript:void(0);' "+$.TableDataConfig.generateQueryFunc(selectGroup, nowPage+1)+">Next</a></li> ";
			}
			var pageInfo = "<div class='col-sm-6'> "+
								"<div class='pagination_info dataTables_info' id='sample-table-2_info'>Showing "+firstRow+" to "+lastRow+" of "+totalRow+" entries</div> "+
							"</div> "+
							"<div class='col-sm-6'> "+
								"<div class='dataTables_paginate paging_bootstrap'> "+
									"<ul class='pagination'> "+
										prevPage +
										navigation +
										nextPage +
									"</ul> "+
								"</div> "+
							"</div>";
			$("."+selectGroup+"_pageInfo").html(pageInfo);					
		},
		htmlSizeSelector : function(selectGroup, defaultSize) {
			return "<label>Display" + 
						"<select onchange='' id='"+selectGroup+"_size_selected' size='1' name='sample-table-2_length' aria-controls='sample-table-2'>" +
							"<option class='sizeOption' value='5' "+(defaultSize==5?"selected='selected'":"")+">5</option>" +	
							"<option class='sizeOption' value='10' "+(defaultSize==10?"selected='selected'":"")+">10</option>" +
							"<option class='sizeOption' value='25' "+(defaultSize==25?"selected='selected'":"")+">25</option>" +
							"<option class='sizeOption' value='50' "+(defaultSize==50?"selected='selected'":"")+">50</option>" +
							"<option class='sizeOption' value='100' "+(defaultSize==100?"selected='selected'":"")+">100</option>" +
						"</select> " +
					"records</label>";
		},
		generateQueryFunc : function(type, pageNumber) {
			var func = "onclick=";
			func += "'"+type+"_list("+pageNumber+")'";
			return func;
		}
}

$.DropDownListConfig = {
		init : function() {
			$(".chosen-select").chosen(); 
			$('#chosen-multiple-style').on('click', function(e){
				var target = $(e.target).find('input[type=radio]');
				var which = parseInt(target.val());
				if(which == 2) {
					$('#form-field-select-4').addClass('tag-input-style');
				} else {
					$('#form-field-select-4').removeClass('tag-input-style');
				}
			});
			//chosen plugin inside a modal will have a zero width because the select element is originally hidden
			//and its width cannot be determined.
			//so we set the width after modal is show
			$('#modal-form').on('shown.bs.modal', function () {
				$(this).find('.chosen-container').each(function(){
					$(this).find('a:first-child').css('width' , '210px');
					$(this).find('.chosen-drop').css('width' , '210px');
				});
			});
			$('.chosen-search').remove();
		}
} 

$.LeftMenuConfig = {
		reset : function() {
			$(".left_menu").removeClass("active");
			$(".left_menu").removeClass("open");
			$(".submenu_user").removeClass("active");
			$(".submenu_catelog").removeClass("active");
		},
		onDashboard : function() {
			$(".left_menu_dashboard").addClass("active");
		},
		onCatelogProductAdd : function() {
			$(".left_menu_catelog").addClass("active");
			$(".left_menu_catelog").addClass("open");
			$(".submenu_catelog_product_add").addClass("active");
		},
		onCatelogProduct : function() {
			$(".left_menu_catelog").addClass("active");
			$(".left_menu_catelog").addClass("open");
			$(".submenu_catelog_product").addClass("active");
		},
		onCatelogCategory : function() {
			$(".left_menu_catelog").addClass("active");
			$(".left_menu_catelog").addClass("open");
			$(".submenu_catelog_category").addClass("active");
		},
		onCatelogCategoryAdd : function() {
			$(".left_menu_catelog").addClass("active");
			$(".left_menu_catelog").addClass("open");
			$(".submenu_catelog_category_add").addClass("active");
		},
		onUserMerchant : function() {
			$(".left_menu_user").addClass("active");
			$(".left_menu_user").addClass("open");
			$(".submenu_user_merchant").addClass("active");
		},
		onUserStaff : function() {
			$(".left_menu_user").addClass("active");
			$(".left_menu_user").addClass("open");
			$(".submenu_user_staff").addClass("active");
		}, 
		onUserSalesStaff : function() {
			$(".left_menu_user").addClass("active");
			$(".left_menu_user").addClass("open");
			$(".submenu_user_sales_staff").addClass("active");
		}
}
</script>