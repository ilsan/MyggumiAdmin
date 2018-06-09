<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet"> -->
<script type="text/javascript">

function search(){
	
	var f = $("<form></form>");
	var input_type = $("#searchOption").clone();
	var keyword = $("#keyword").val();
	var input_keyword = '<input type="hidden" name="keyword" value="'+keyword+'">';
	
	console.log(keyword);
	
	f.attr("name", "searchForm");
	f.append(input_type);
	f.append(input_keyword);
	f.attr('action', '/admin/product/productList');
    f.attr('method', 'get');
    f.appendTo('body');
    f.submit();
}

$(function(){
	$('.search-panel .dropdown-menu').find('a').click(function(e) {
		e.preventDefault();
		var param = $(this).attr("href").replace("#","");
		var concept = $(this).text();
		$('.search-panel span#search_concept').text(concept);
		$('.input-group #searchOption').val(param);
	});
	
})


</script>
<style type="text/css">
@media (max-width:360px){th{font-size:3px;}}
@media (max-width:360px){td{font-size:3px;}}

/* @import url("//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"); */
/* @font-face {
  font-family: 'Glyphicons Halflings';

  src: url('../fonts/glyphicons-halflings-regular.eot');
  src: url('../fonts/glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('../fonts/glyphicons-halflings-regular.woff2') format('woff2'), url('../fonts/glyphicons-halflings-regular.woff') format('woff'), url('../fonts/glyphicons-halflings-regular.ttf') format('truetype'), url('../fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular') format('svg');
}
.glyphicon {
  position: relative;
  top: 1px;
  display: inline-block;
  font-family: 'Glyphicons Halflings';
  font-style: normal;
  font-weight: normal;
  line-height: 1;

  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.glyphicon-search:before {
  content: "\e003";
} */



</style>
<title>상품 리스트</title>
</head>
<body class="body-font-color">
<div class="container body-min-height">
	<h3>상품 리스트</h3>
		<div class="row" style="margin-bottom: 10px">    
         <div class="col-xs-5 pull-right">
 		    <div class="input-group">
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">전체</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                    	<li><a href="#all">전체</a></li>
                    	<li class="divider" style="margin: 0"></li>
						<!-- <li><a href="#contains">상품코드</a></li> -->
						<li><a href="#product_type">상품타입</a></li>
						<li><a href="#product_name">상품명</a></li>
						<li><a href="#product_category">카테고리</a></li>
                    </ul> 
                   	<!-- <select multiple title="Choose one of the following...">
					  	<option>Mustard</option>
					  	<option>Ketchup</option>
						<option>Relish</option>
					</select> -->
				                    
                </div>
                <input type="hidden" name="searchOption" value="all" id="searchOption">         
                <input type="text" class="form-control" id="keyword" name="keyword" placeholder="Search term..." style="height: 34px; color: lightgrey;" value="">
                <div class="input-group-btn search-panel">
                    <button class="btn btn-default" type="button" onclick="fn:search()">훗<!-- <span class="glyphicon glyphicon-search" aria-hidden="true"> </span>--></button>
                </div>
           </div>
        </div>
	</div>
		<!-- margin:0 auto; -->
		<div style="width: 100%;">
			<table width="100%" class="my-tbl">
			  <col width="5%">
			  <col width="auto">
			  <col width="15%">
			  <col width="15%">
			  <col width="15%">
			  <col width="11%">
			  <col width="15%">
			  <tr class="tr-title" style="text-align: center;">
			    <th>No</th>
			    <th>상품명</th>
			    <th>상품타입</th>
			    <th>카테고리</th>
			    <th>가격</th>
			    <th>사용여부</th>
			    <th>등록일</th>
			  </tr>
			  <c:choose>
			  	<c:when test="${empty productList}">
			  		<tr>
			  			<td colspan="7">--------상품이없습니다--------</td>
			  		</tr>
			  	</c:when>
			  	<c:otherwise>
			  		<c:forEach items="${productList }" var="productList">
			  			<tr>
			  				<td>${productList.rnum }</td>
			  				<td><a href="/admin/product/productDetail?productNo=${productList.productNo }">${productList.productName }</a></td>
			  				<td>${productList.typeNm }</td>
			  				<td>${productList.categoryNm }</td>
			  				<td><fmt:formatNumber value="${productList.productPrice }" pattern="#,###"/></td>
			  				<td>${productList.useYn }</td>
			  				<td>${productList.regDate }</td> 
			  			</tr>
			  		</c:forEach>
			  	</c:otherwise>
			  </c:choose>
			</table>
		</div>	 
		<br/>
		<div>
			<button class="btnnew noty" onclick="location.href='/admin/product/productWrite';">등록하기</button>
			<button class="btnnew noty" ><img width="22px" height="22px" src="<%=request.getContextPath()%>/assets/images/excel-icon.png" /> 엑셀 일괄 등록</button>
			                  ${pageResult}
			<input type="hidden" id="currentPage" name="currentPage" >			                  
		</div>	
</div>	
</body>
</html>
