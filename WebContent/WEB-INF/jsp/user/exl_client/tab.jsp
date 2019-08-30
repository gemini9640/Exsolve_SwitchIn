<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="detial_tab  tab_exl_client">
		<a href="${base}manage/exlclient/detail.do?id=${client.id}">
			EXL-Client
		</a>
	</li>
</ul>
<script>
function activeCreationTab(type) {
	$(".detial_tab").removeClass("active");
	$(".tab_"+type).addClass("active");
}
</script>