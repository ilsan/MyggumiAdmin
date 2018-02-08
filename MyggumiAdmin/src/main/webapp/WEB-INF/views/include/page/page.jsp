<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="pagination" style="margin-top:0px;">
	<li class="page-item leftPage">
		<a class="page-link" href="#" aria-label="Previous">
			<span aria-hidden="true">&laquo;</span>
			<span class="sr-only">Previous</span>
		</a>
	</li>
		<c:forEach var="item" begin="${startPageNo}" end="${endPageNo}">
			<li class="page-item"><a href="javascript:funcGoPageNo('${item}');" class="page-link">${item}</a></li>
		</c:forEach>
	<li class="page-item rightPage">
		<a class="page-link" href="#" aria-label="Next">
			<span aria-hidden="true">&raquo;</span>
			<span class="sr-only">Next</span>
		</a>
	</li>
</ul>

<form name="frmPage">
	<input type="hidden" name="currentPage" value="${currentPage}">
</form>

<script>
	
function funcGoPageNo(page){
	var frm = document.frmPage;
	frm.currentPage.value = page;
	frm.method = "GET";
	frm.action = "${requestURI}";
	frm.submit();
}

	var crPage  = ${param.currentPage};
	var maxPage = ${maxPageNo};
	var pageCnt = ${pageCnt};
	var naviCnt = ${naviCnt};
	
	if(crPage <= naviCnt){
		$(".leftPage").addClass("disabled");
	}else if(crPage > naviCnt){
		if(crPage % naviCnt == 0){
			$(".leftPage > a").attr("href", "javascript:funcGoPageNo(" + (crPage - naviCnt * 2 + 1) + ");");
		}else{
			$(".leftPage > a").attr("href", "javascript:funcGoPageNo(" + (crPage - naviCnt - (crPage % naviCnt) + 1) + ");");
		}
	}
	
	var maxFirstPage = maxPage - (maxPage % naviCnt) - (maxPage % naviCnt == 0 ? 10 : 0) + 1;
	
	if(crPage >= maxFirstPage){
		$(".rightPage").addClass("disabled");
	}else{
		if(crPage % naviCnt == 0){
			$(".rightPage > a").attr("href", "javascript:funcGoPageNo(" + (crPage + 1) + ");");
		}else{
			$(".rightPage > a").attr("href", "javascript:funcGoPageNo(" + (crPage + naviCnt - (crPage % naviCnt) + 1) + ");");
		}
	}
	$(".page-item").each(function(){
		if($(this).text() == crPage)
		{
			$(this).addClass("active");
		}
	});
</script>

