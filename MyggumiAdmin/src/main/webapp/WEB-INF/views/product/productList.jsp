<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

function productWrite() {
	
}


</script>
<style type="text/css">
@media (max-width:360px){th{font-size:3px;}}
@media (max-width:360px){td{font-size:3px;}}
</style>
<title>상품 리스트</title>
</head>
<body class="body-font-color">
<div class="container body-min-height">
	<h3>상품 리스트</h3>
	
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
			  				<td>${productList.productNo }</td>
			  				<td><a href="/admin/product/productDetail?productNo=${productList.productNo }">${productList.productName }</a></td>
			  				<td>${productList.productType }</td>
			  				<td>${productList.productCategory }</td>
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
			                  ------------------------- 페이징 처리 필요 ------------------------------
		</div>	
</div>	
</body>
</html>
