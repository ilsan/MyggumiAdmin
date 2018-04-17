<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        
			var bool = false; 
		        $(".Data").each(function() { // infoData 반복
					
					var val = $(this).val(); // 1 각각 자기의 벨류가
					
					if(val==""){ // 2 비어있으면 bool 을 true로 바꿔준다.
						bool = true;  
					} 
					
				}); // end of each()---------------------
			
			if(bool) { // 5 bool이 true 라면 비어있는 항목이 있다는뜻이기 때문에
				alert(" 제목*, 본문*, 첨부파일* 항목에 빠짐없이 입력하여 주세요."); //  6 클릭 이벤트를 막는다.
			}else{ // 모두 들어와서 false 라면 
				 //폼 submit
		        $("#frm").submit();
			}
        
       
    });
});

</script>
<title>상품 수정</title>
</head>
<body class="body-font-color">
 <div class="container body-min-height">
	<h3>상품 수정</h3>
	<div style="width: 100%;">
		<form action="/admin/product/productUpdateAfter">
		<input type="hidden" name="updatePno" value="${productDetail.productNo }">
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
			    		  <input type="text" name="productName" value="${productDetail.productName }"/>
			    	  </div>
				  </td>
			  </tr>
			  <tr>
				  <td>상품타입</td>
				  <td>
				  
				 	 <div class="my-padding-10 my-width-75">
						 <div class="select">
						 
						    <select name="productType" id="slct" class="productType">
						      <option>선택</option>
						      <option value="NEW" <c:if test="${productDetail.productType == 'NEW'}">selected</c:if>>NEW</option>
						      <option value="HIT" <c:if test="${productDetail.productType == 'HIT'}">selected</c:if>>HIT</option>
						      <option value="DC" <c:if test="${productDetail.productType == 'DC'}">selected</c:if>>DC</option>
						    </select>
						  </div>
					  </div>
				  </td>
				  <td>카테고리</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						 <div class="select">
						 
						    <select name="productCategory" id="slct" class="productCategory">
						      <option>선택</option>
						      <option value="01" <c:if test="${productDetail.productCategory == 1}">selected</c:if>>아이폰</option>
						      <option value="02" <c:if test="${productDetail.productCategory == 2}">selected</c:if>>삼성</option>
						      <option value="03" <c:if test="${productDetail.productCategory == 3}">selected</c:if>>태블릿</option>
						      <option value="04" <c:if test="${productDetail.productCategory == 4}">selected</c:if>>노트북</option>
						      <option value="05" <c:if test="${productDetail.productCategory == 5}">selected</c:if>>기타</option>
						    </select>
						  </div>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>상품가격</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<input type="text" name="productPrice" value="${productDetail.productPrice }"/>
					  </div>
				  </td>
				  <td>할인율</td>
				  <td>
				 	 <div class="my-padding-10 my-width-75">
						<input type="text" name="productDc" value="${productDetail.productDc }"/>
					  </div>
				  </td>
			  </tr>		
			  <tr>
				  <td>사용여부</td>
				  <td colspan="3">
				  	<div class="my-margin-left-10 text-align-left">
					 <p class="btn-switch">					
					  <input type="radio" <c:if test="${productDetail.useYn == 'Y'}">checked</c:if> id="yes" value="Y" name="useYn" class="btn-switch__radio btn-switch__radio_yes" />
					  <input type="radio" <c:if test="${productDetail.useYn == 'N'}">checked</c:if> id="no" name="useYn" value="N" class="btn-switch__radio btn-switch__radio_no" />		
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
			    	  	  <textarea style="height: 400px;" id="editor" name="productContent" >${productDetail.productContent }</textarea>
			    	  </div>
				  </td>
			  </tr>
			</table>
			
			<br></br>
			<div>
			<button id="savebutton" class="btnnew noty">수정 완료</button>
			<a class="btnnew noty" onclick="javascript:history.back();">취소</a>
			</div>
		</form>
	</div>
</div>
</body>
</html>