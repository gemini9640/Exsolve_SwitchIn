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
					<a href="${base}user/merchant/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						SI-Merchant
					</a>
					<b class="arrow"></b>
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
				<li class="left_nav left_nav_eventDraft">
					<a href="tables-Draft-Event.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Draft Event
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-book"></i>
				<span class="menu-text">Voucher Management</span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="">
					<a href="">
						<i class="menu-icon fa fa-caret-right"></i>
						Create Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Pending-Voucher.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Pending  Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Active-Voucher.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Active Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Expired-Voucher.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Expired Voucher
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Draft-Voucher.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Draft Voucher
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


 <%--
<div id="sidebar" class="sidebar responsive ace-save-state">
	<script type="text/javascript">
		try{ace.settings.loadState('sidebar')}catch(e){}
	</script>
	<ul class="nav nav-list">
		<li class="active">
			<a href="index.html">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text"> Dashboard </span>
			</a>
			<b class="arrow"></b>
		</li>
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-users"></i>
				<span class="menu-text"> User Management </span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="">
					<a href="${base}user/merchant/add.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						Create User
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="${base}user/merchant/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						SI-Merchant
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="${base}user/member/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						SI-Member
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="${base}user/exlagent/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						ExL-Agent
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="${base}user/exlclient/list.htm">
						<i class="menu-icon fa fa-caret-right"></i>
						ExL-Client
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-lightbulb-o"></i>
				<span class="menu-text"> Event Management </span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="">
					<a href="">
						<i class="menu-icon fa fa-caret-right"></i>
						Create Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Pending-Event.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Pending  Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Active-Event.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Active Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Expired-Event.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Expired Event
					</a>
					<b class="arrow"></b>
				</li>
				<li class="">
					<a href="tables-Draft-Event.html">
						<i class="menu-icon fa fa-caret-right"></i>
						Draft Event
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
	</ul>

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>--%>