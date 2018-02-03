<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" id="viewport" content="width=device-width, user-scalable=no">
<script type="text/javascript">

function productWrite() {
	
}


</script>
<title>Insert title here</title>
</head>
<body class="body-font-color">
<div class="container body-min-height">
	<h3>상품 등록</h3>
	
		<!-- margin:0 auto; -->
	<div style="width: 100%;">
		<form action="">
			<table width="100%" class="my-tbl" style="border: 1px black solid;">
			  <col width="10%">
			  <col width="40%">
			  <col width="10%">
			  <col width="40%">
			  <tr>
				  <td>상품명 </td>
				  <td colspan="3">
			    	  <div class="my-padding-10 my-width-90">
			    		  <input type="text"/>
			    	  </div>
				  </td>
			  </tr>
			  <tr>
				  <td>상품타입</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <div class="select">
						    <select name="slct" id="slct">
						      <option>선택</option>
						      <option value="01">NEW</option>
						      <option value="02">HIT</option>
						      <option value="03">DC</option>
						    </select>
						  </div>
					  </div>
				  </td>
				  <td>카테고리</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <div class="select">
						    <select name="slct" id="slct">
						      <option>선택</option>
						      <option value="01">아이폰</option>
						      <option value="02">삼성</option>
						      <option value="03">태블릿</option>
						      <option value="04">노트북</option>
						      <option value="05">기타</option>
						    </select>
						  </div>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>상품가격</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<input type="text"/>
					  </div>
				  </td>
				  <td>할인율</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<input type="text" value="0"/>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>사용여부</td>
				  <td colspan="3">
				  	<div class="my-margin-left-10 text-align-left">
					 <p class="btn-switch">					
					  <input type="radio" checked id="yes" value="Y" name="switch" class="btn-switch__radio btn-switch__radio_yes" />
					  <input type="radio" id="no" name="switch" value="N" class="btn-switch__radio btn-switch__radio_no" />		
					  <label for="yes" class="btn-switch__label btn-switch__label_yes"><span class="btn-switch__txt">Yes</span></label>
					  <label for="no" class="btn-switch__label btn-switch__label_no"><span class="btn-switch__txt">No</span></label>							
					 </p>
					</div>
				  </td>
			  </tr>		
			  <tr>
				  <td>상품내용</td>
				  <td colspan="3">
			    	  <div class="my-padding-10 my-width-90">
			    	  	  <textarea style="height: 400px;"  value="!!에디터 들어갈 공간!!"></textarea>
			    	  </div>
				  </td>
			  </tr>
			</table>
			
			<br></br>
			<div>
			<button class="btnnew noty" >확인</button>
			<a class="btnnew noty" onclick="javascript:history.back();">취소</a>
			</div>
		</form>
	</div>
		
		<br/>
		<div>
			
		</div>
</div>	
</body>
</html>
