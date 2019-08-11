<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="creation_tab tab_si_merchant">
		<a href="${base}user/merchant/add.htm">
			SI-Merchant
		</a>
	</li>
	<li class="creation_tab  tab_si_member">
		<a href="${base}user/member/add.htm">
			SI-Member
		</a>
	</li>
	<li class="creation_tab tab_exl_agent">
		<a href="${base}user/exlagent/add.htm">
			ExL-Agent
		</a>
	</li>
	<li class="creation_tab tab_exl_client">
		<a href="${base}user/exlclient/add.htm">
			ExL-Client
		</a>
	</li>
</ul>
<script>
function activeCreationTab(type) {
	$(".creation_tab").removeClass("active");
	$(".tab_"+type).addClass("active");
}
</script>