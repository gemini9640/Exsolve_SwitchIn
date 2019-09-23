<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="detail_tab  tab_event">
		<a href="${base}manage/event/detail.do?eventId=${event.id}&status=${event.status}">
			Basic Info
		</a>
	</li>
<!-- 	<li class="detail_tab  tab_event_cate"> -->
<%-- 		<a href="${base}manage/event/detail.do?id=${event.id}"> --%>
<!-- 			Category -->
<!-- 		</a> -->
<!-- 	</li> -->
	<li class="detail_tab  tab_event_banner">
		<a href="${base}manage/event/list_doc.do?eventId=${event.id}&type=1&status=${event.status}">
			Banner
		</a>
	</li>
	<li class="detail_tab  tab_event_qr">
		<a href="${base}manage/event/list_doc.do?eventId=${event.id}&type=2&status=${event.status}">
			QR
		</a>
	</li>
</ul>
<script>
function activeCreationTab(type) {
	$(".detail_tab").removeClass("active");
	$(".tab_"+type).addClass("active");
}
</script>