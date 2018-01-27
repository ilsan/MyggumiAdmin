<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  
    <title>마이구미 어드민 페이지</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Carlos Alvarez - Alvarez.is">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.min.css" />

    <link href="<%=request.getContextPath()%>/assets/css/main.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/font-style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/flexslider.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/mycss.css" rel="stylesheet">

    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>    
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lineandbars.js"></script>
    
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/dash-charts.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/gauge.js"></script>
	
	<!-- NOTY JAVASCRIPT -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/noty/jquery.noty.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/noty/layouts/top.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/noty/layouts/topLeft.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/noty/layouts/topRight.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/noty/layouts/topCenter.js"></script>
	
	<!-- You can add more layouts if you want -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/noty/themes/default.js"></script>
    <!-- <script type="text/javascript" src="assets/js/dash-noty.js"></script> This is a Noty bubble when you init the theme-->
	<script type="text/javascript" src="http://code.highcharts.com/highcharts.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/jquery.flexslider.js" type="text/javascript"></script>

    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/admin.js"></script>
      
    <style type="text/css">
      body {
        padding-top: 60px;
      }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
   

  	<!-- Google Fonts call. Font Used Open Sans & Raleway -->
	<link href="http://fonts.googleapis.com/css?family=Raleway:400,300" rel="stylesheet" type="text/css">
  	<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">

<script type="text/javascript">
    $(document).ready(function () {

        $("#btn-blog-next").click(function () {
            $('#blogCarousel').carousel('next')
        });
        $("#btn-blog-prev").click(function () {
            $('#blogCarousel').carousel('prev')
        });

        $("#btn-client-next").click(function () {
            $('#clientCarousel').carousel('next')
        });
        $("#btn-client-prev").click(function () {
            $('#clientCarousel').carousel('prev')
        });

    });

    $(window).load(function () {

      /*   $('.flexslider').flexslider({
            animation: "slide",
            slideshow: true,
            start: function (slider) {
                $('body').removeClass('loading');
            }
        }); */
    });

</script>    



</head>
<body>

	<tiles:insertAttribute name="top" />
	<%-- <tiles:insertAttribute name="menu" /> --%>
	<tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="foot" />
	
</body>
</html>

