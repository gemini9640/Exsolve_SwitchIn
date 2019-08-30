<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav nav-tabs padding-16">
	<li class="detail_tab  tab_si_member">
		<a href="${base}manage/member/detail.do?id=${result.member.id}">
			SI-Member
		</a>
	</li>
</ul>
<script>
function activeCreationTab(type) {
	$(".detail_tab").removeClass("active");
	$(".tab_"+type).addClass("active");
}
</script>