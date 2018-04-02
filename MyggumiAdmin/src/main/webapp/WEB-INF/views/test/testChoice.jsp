<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	function goChoice(){
		
		chkCnt = $("input[name=strChk]:checked").val();
		$("#appenDiv").empty();
		var ihtml= "";
		for(var i=0; i<chkCnt; i ++){
			$.post('/admin/test/choice',{'chkCnt':chkCnt},function(data){
	
				if(data=="g"){
					ihtml = '<div style="background-color: green; width: 50px; height: 50px;" >초록</div>';
				}else if(data=="b"){
					ihtml = '<div style="background-color: blue; width: 50px; height: 50px;" >파랑</div>';
				}else if(data=="p"){
					ihtml = '<div style="background-color: purple; width: 50px; height: 50px;" >보라</div>';
				}else if(data=="y"){
					ihtml = '<div style="background-color: yellow; width: 50px; height: 50px;" >노랑</div>';
				}else if(data=="o"){
					ihtml = '<div style="background-color: orange; width: 50px; height: 50px;" >주황</div>';
				}

				$("#appenDiv").append(ihtml);
				
				 
			},'text'); 
		}
// 		alert(ihtml);
	}


</script>
<title>둥지길드 샤카투 뽑기!</title>
</head>
<body class="body-font-color">
<div class="container body-min-height">
	
	<div>
		<img src="<%=request.getContextPath()%>/assets/images/sakato2.PNG"/>
		<h3>샤카투 뽑기! (0.1 ver)</h3> 
	</div>
	</br>
	
	
	<div>
		<img src="<%=request.getContextPath()%>/assets/images/sakato.jpg">
	</div>
	<div>
	
	<input type="radio" name="strChk" id="1c" value="1" checked="checked"/>
	<label for="1c">1개씩뽑기</label>
	</br>
	<input type="radio" name="strChk" id="5c" value="5"/>
	<label for="5c">5개씩뽑기</label>
	</br>
	<input type="radio" name="strChk" id="10c" value="10"/>
	<label for="10c">10개씩뽑기</label>
	</br>
	
	<button class="btnnew noty" onclick="goChoice();">뽑기</button>
	</div>
	</br>
	
	<div id="appenDiv" style="display: inline-flex;">
	</div>
		
</div>	
</body>
</html>
