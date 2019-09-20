<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="detail_tab  tab_si_merchant">
		<a href="${base}manage/merchant/detail.do?id=${merchant.id}">
			SI-Merchant
		</a>
	</li>
	<li class="detail_tab  tab_si_merchant_pic">
		<a href="${base}manage/merchant/pic.do?id=${pic.id}">
			Person In Charge
		</a>
	</li>
	<li class="detail_tab  tab_si_merchant_banner">
		<a href="${base}manage/merchant/list_doc.do?merchantId=${merchant.id}&picId=${pic.id}&type=2">
			Banner
		</a>
	</li>
</ul>
<script>
function activeCreationTab(type) {
	$(".detail_tab").removeClass("active");
	$(".tab_"+type).addClass("active");
}
</script>