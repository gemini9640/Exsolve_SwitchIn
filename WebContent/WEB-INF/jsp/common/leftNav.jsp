<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function switchLeftActive(model, action, type) {
	$(".left_nav").removeClass("active");
	$(".left_nav").removeClass("open");
	$(".left_nav_"+model).addClass("active");
	$(".left_nav_"+model).addClass("open");
	if(action != null) {
		$(".left_nav_"+action).addClass("active");
		$(".left_nav_"+action).addClass("open");
	}
	if(type != null) {
		$(".left_nav_"+type).addClass("active");
	}
}
</script>
<div id="sidebar" class="sidebar responsive ace-save-state">
	<script type="text/javascript">
		try{ace.settings.loadState('sidebar')}catch(e){}
	</script>
	<ul class="nav nav-list nav-list2">
		<li class="left_nav left_nav_dashboad">
			<a href="${base}">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text"> Dashboard </span>
			</a>
			<b class="arrow"></b>
		</li>
		<li class="left_nav left_nav_user">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-users"></i>
				<span class="menu-text">
					User Management
				</span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="left_nav left_nav_user_create">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-caret-right"></i>
						Create User
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="left_nav left_nav_createMerchant">
							<a href="${base}user/merchant/add.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Create Merchant
							</a>
							<b class="arrow"></b>
						</li>
						<li class="left_nav left_nav_createMember">
							<a href="${base}user/member/add.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Create Member
							</a>
							<b class="arrow"></b>
						</li>
						<li class="left_nav left_nav_createAgent">
							<a href="${base}user/exlagent/add.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Create Agent
							</a>
							<b class="arrow"></b>
						</li>
						<li class="left_nav left_nav_createClient">
							<a href="${base}user/exlclient/add.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Create Client
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>
				<li class="left_nav left_nav_merchantList">
					<a class="dropdown-toggle">
						<i class="menu-icon fa fa-caret-right"></i>
						SI-Merchant
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="left_nav left_nav_merchantPending">
							<a href="${base}user/merchant/pending.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Pending Merchant
							</a>
							<b class="arrow"></b>
						</li>
						<li class="left_nav left_nav_merchantActive">
							<a href="${base}user/merchant/active.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Active Merchant
							</a>
							<b class="arrow"></b>
						</li>
						<li class="left_nav left_nav_merchantRejected">
							<a href="${base}user/merchant/rejected.htm">
								<i class="menu-icon fa fa-caret-right"></i>
								Rejected Merchant
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>
				<li class="left_nav left_nav_memberList">
					<a href="${base}user/member/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						SI-Member
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_agentList">
					<a href="${base}user/exlagent/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						ExL-Agent
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_clientList">
					<a href="${base}user/exlclient/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						ExL-Client
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>


		<li class="left_nav left_nav_event">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-lightbulb-o"></i>
				<span class="menu-text"> Event Management </span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="left_nav left_nav_eventCreate">
					<a href="${base}event/add.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Create Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_eventPending">
					<a href="${base}event/pending.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Pending Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_eventActive">
					<a href="${base}event/active.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Active Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_eventExpired">
					<a href="${base}event/expired.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Expired Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_eventRejected">
					<a href="${base}event/rejected.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Rejected Event
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
		<li class="left_nav left_nav_voucher">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-book"></i>
				<span class="menu-text">Voucher Management</span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="left_nav left_nav_voucherCreate">
					<a href="${base}voucher/add.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Create Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_voucherPending">
					<a href="${base}voucher/pending.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Pending  Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_voucherActive">
					<a href="${base}voucher/active.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Active Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_voucherExpired">
					<a href="${base}voucher/expired.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Expired Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="left_nav left_nav_voucherRejected">
					<a href="${base}voucher/rejected.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Rejected Voucher
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
	</ul>
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>