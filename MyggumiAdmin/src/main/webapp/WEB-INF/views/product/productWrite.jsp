<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" id="viewport" content="width=device-width, user-scalable=no">
<script type="text/javascript">


$(function(){
    //전역변수
    var obj = [];               
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "editor",
        sSkinURI: "<%=request.getContextPath()%>/assets/editor/SmartEditor2Skin.html", 
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true, 
        }
    });
    
    
    
  //전송버튼
    $("#savebutton").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
        
        var form = document.writeForm;
        form.submit();

    });

});



</script>
<title>Insert title here</title>
</head>
<body class="body-font-color">
 <div class="container body-min-height">
	<h3>상품 등록</h3>
	<div style="width: 100%;">
<%-- 		<form id="writeForm" name="writeForm" action="/admin/product/productWriteAfter" method="post"> --%>
		<form:form modelAttribute="productForm" name="writeForm" action="/admin/product/productWriteAfter" method="post">
		<input type="hidden" name="regUser" value="test"/>
			<table width="100%" class="my-tbl" style="border: 1px black solid;">
			  <col width="10%">
			  <col width="40%">
			  <col width="10%">
			  <col width="40%">
			  <tr>
				  <td>상품명 </td>
				  <td colspan="3">
			    	  <div class="my-padding-10 my-width-90">
<!-- 			    		  <input type="text" name="productName"/> -->
			    		  <form:input path="productName" />
			    		  <form:errors path="productName" />
			    	  </div>
				  </td>
			  </tr>
			  <tr>
				  <td>상품타입</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <div class="select">
							<form:select path="productType">
							  <form:option value="선택" /> 
						      <form:options items="${productType}" itemValue="comCd" itemLabel="comNm"/>
							</form:select>
<!-- 						    <select name="productType" id="slct"> -->
<!-- 						      <option>선택</option> -->
<%-- 						      <c:forEach items="${productType}" var="typeList"> --%>
<%-- 						      	<option value="${typeList.comCd}">${typeList.comNm}</option> --%>
<%-- 						      </c:forEach> --%>
<!-- 						    </select> -->
						  </div>
					  </div>
				  </td>
				  <td>카테고리</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <div class="select">
						 	<form:select path="productCategory">
							  <form:option value="선택" /> 
						      <form:options items="${productCategory}" itemValue="comCd" itemLabel="comNm"/>
							</form:select>
<!-- 						    <select name="productCategory" id="slct"> -->
<!-- 						      <option value="">선택</option> -->
<%-- 						      <c:forEach items="${productCategory}" var="categoryList"> --%>
<%-- 						      	<option value="${categoryList.comCd}">${categoryList.comNm}</option> --%>
<%-- 						      </c:forEach> --%>
<!-- 						    </select> -->
						  </div>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>상품가격</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<input type="text" name="productPrice"/>
						<form:errors path="productPrice" />
					  </div>
				  </td>
				  <td>할인율</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<input type="text" name="productDc" value="1"/>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>사용여부</td>
				  <td colspan="3">
				  	<div class="my-margin-left-10 text-align-left">
					 <p class="btn-switch">					
					  <input type="radio" checked id="yes" value="Y" name="useYn" class="btn-switch__radio btn-switch__radio_yes" />
					  <input type="radio" id="no" name="useYn" value="N" class="btn-switch__radio btn-switch__radio_no" />		
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
			    	  	  <textarea style="height: 400px;" id="editor" name="productContent" ></textarea>
			    	  </div>
				  </td>
			  </tr>
			</table>
			
			<br></br>
			<div>
			
			<input type="button" id="savebutton" class="btnnew noty" value="확인"/>
			<a class="btnnew noty" onclick="javascript:history.back();">취소</a>
			</div>
<%-- 		</form> --%>
		</form:form>
	</div>
		
		<br/>
		<div>
			
		</div>
</div>
</body>
</html>
