<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

function productWrite() {
	
}

function funcGoPageNo(page){
	var frm = document.frmPage;
	frm.currentPage.value = page;
	funcSubmit('Y');
}

function funcSubmit(pageYN){
	var frm = document.frmPage;
	if(pageYN != 'Y'){
		frm.currentPage.value = 1;
	}
	frm.method = "POST";
	frm.action = "/admin/product/productList";
	frm.submit();
}


</script>
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
			  <!-- 
			  <tr>
			    <td>1</td>
			    <td>iphone</td>
			    <td>NEW</td>
			    <td>아이폰</td>
			    <td>750,000</td>
			    <td>Y</td>
			    <td>2018-01-25</td>
			  </tr>
			  <tr>
			    <td>2</td>
			    <td>삼성탭</td>
			    <td>NEW</td>
			    <td>테블릿</td>
			    <td>450,000</td>
			    <td>Y</td>
			    <td>2018-01-26</td>
			  </tr>
			   <tr>
			    <td>3</td>
			    <td>MSI</td>
			    <td>HIT</td>
			    <td>노트북</td>
			    <td>1,150,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>4</td>
			    <td>LG그램</td>
			    <td>DC</td>
			    <td>노트북</td>
			    <td>950,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>5</td>
			    <td>MAC-BOOK</td>
			    <td>HIT</td>
			    <td>노트북</td>
			    <td>2,000,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>6</td>
			    <td>MAC-BOOK6</td>
			    <td>HIT</td>
			    <td>노트북</td>
			    <td>1,800,000</td>
			    <td>N</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>7</td>
			    <td>MAC-BOOK7</td>
			    <td>DC</td>
			    <td>노트북</td>
			    <td>2,200,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>8</td>
			    <td>MAC-BOOK8</td>
			    <td>HIT</td>
			    <td>노트북</td>
			    <td>2,300,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>9</td>
			    <td>MAC-BOOK9</td>
			    <td>NEW</td>
			    <td>노트북</td>
			    <td>2,000,000</td>
			    <td>N</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>10</td>
			    <td>MAC-BOOK10</td>
			    <td>HIT</td>
			    <td>노트북</td>
			    <td>2,000,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>11</td>
			    <td>MAC-BOOK11</td>
			    <td>HIT</td>
			    <td>노트북</td>
			    <td>1,800,000</td>
			    <td>N</td>
			    <td>2018-01-27</td>
			  </tr>
			  <tr>
			    <td>12</td>
			    <td>MAC-BOOK12</td>
			    <td>NEW</td>
			    <td>노트북</td>
			    <td>1,300,000</td>
			    <td>Y</td>
			    <td>2018-01-27</td>
			  </tr> -->
			  <c:forEach var="item" items="${productList}">
				  <tr>
				    <td>${item.RNUM}</td>
				    <td>${item.productName}</td>
				    <td>${item.productType}</td>
				    <td>${item.productCategory}</td>
				    <td>${item.productPrice}</td>
				    <td>${item.useYn}</td>
				    <td>${item.regDate}</td>
				  </tr>
			  </c:forEach>
			</table>
		</div>
		 
		 
		 
		<br/>
		<div>
			<button class="btnnew noty" onclick="location.href='/admin/product/productWrite';">등록하기</button>
			<button class="btnnew noty" ><img width="22px" height="22px" src="<%=request.getContextPath()%>/assets/images/excel-icon.png" /> 엑셀 일괄 등록</button>
			
			                 <!--  ------------------------- 페이징 처리 필요 ------------------------------ -->
			<span class="page" >	<!-- row c rowMargin -->
				<c:import url="/include/page">
					<c:param name="currentPage" value="${param.currentPage == null ? 1 : param.currentPage}"/>	<%-- ${param.currentPage == null ? 1 : param.currentPage }" --%>
					<c:param name="totalCnt" value="${totalCnt}"/>	<%-- ${noticeCnt} --%>
				</c:import>
			</span>
			<form name="frmPage"> <!-- action="/admin/product/productList" -->
				<input type="hidden" name="currentPage" value="${param.currentPage == null ? 1 : param.currentPage}">
			</form>
		</div>
		
		
</div>	
</body>
</html>
