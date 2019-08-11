<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</div>
