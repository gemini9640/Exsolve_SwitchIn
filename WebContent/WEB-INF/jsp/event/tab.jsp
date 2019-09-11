<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="detail_tab  tab_si_merchant">
		<a href="${base}manage/event/detail.do?id=${event.id}">
			Basic Info
		</a>
	</li>
	<li class="detail_tab  tab_event_cate">
		<a href="${base}manage/event/detail.do?id=${event.id}">
			Category
		</a>
	</li>
	<li class="detail_tab  tab_event_banner">
		<a href="${base}manage/event/picture.do?id=${event.id}&type=banner">
			Banner
		</a>
	</li>
	<li class="detail_tab  tab_event_qr">
		<a href="${base}manage/event/picture.do?id=${event.id}&type=qr">
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