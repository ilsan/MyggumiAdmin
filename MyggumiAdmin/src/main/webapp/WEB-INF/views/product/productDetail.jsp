<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세보기</title>
</head>
<body class="body-font-color">
	<div class="container body-min-height">
		<div style="width: 100%;">
			<table width="100%" class="my-tbl" style="border: 1px black solid;">
			  <col width="10%">
			  <col width="40%">
			  <col width="10%">
			  <col width="40%">
			  <tr>
				  <td>상품명 </td>
				  <td colspan="3">
			    	  <div class="my-padding-10 my-width-90">
			    		  <p>${productDetail.productName }</p>
			    	  </div>
				  </td>
			  </tr>
			  <tr>
				  <td>상품타입</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <p>${productDetail.productType }</p>
					  </div>
				  </td>
				  <td>카테고리</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <p>${productDetail.productCategory }</p>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>상품가격</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<p>${productDetail.productPrice }</p>
					  </div>
				  </td>
				  <td>할인율</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<p>${productDetail.productDc }</p>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>사용여부</td>
				  <td colspan="3">
				  	<p>${productDetail.useYn }</p>
				  </td>
			  </tr>		
			  <tr>
				  <td>상품내용</td>
				  <td colspan="3">
			    	  <div>${productDetail.productContent }</div>
				  </td>
			  </tr>
			</table>
		</div>
		<br>
			<div>
				<a class="btnnew noty" href="/admin/product/productUpdate?productNo=${productDetail.productNo}">수정</a>
				<a class="btnnew noty" onclick="javascript:history.back();">취소</a>
			</div>
	</div>

</body>
</html>