<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="detail_tab  tab_voucher">
		<a href="${base}manage/voucher/detail.do?voucherId=${voucher.id}&status=${voucher.status}">
			Basic Info
		</a>
	</li>
<!-- 	<li class="detail_tab  tab_voucher_cate"> -->
<%-- 		<a href="${base}manage/voucher/detail.do?id=${voucher.id}"> --%>
<!-- 			Category -->
<!-- 		</a> -->
<!-- 	</li> -->
	<li class="detail_tab  tab_voucher_banner">
		<a href="${base}manage/voucher/list_doc.do?voucherId=${voucher.id}&type=1&status=${voucher.status}">
			Banner
		</a>
	</li>
	<li class="detail_tab  tab_voucher_qr">
		<a href="${base}manage/voucher/list_doc.do?voucherId=${voucher.id}&type=2&status=${voucher.status}">
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