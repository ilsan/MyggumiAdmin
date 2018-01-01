<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<div style="border: red 1px solid;">
		<tiles:insertAttribute name="top" />
	</div>
	
	<div style="border: orange 1px solid; background-color: pink ">
		<tiles:insertAttribute name="menu" />
	</div>
	
	<tiles:insertAttribute name="body"/>
	
	
	<div style="border: blue 1px solid;">
		<tiles:insertAttribute name="foot" />
	</div>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Massively by HTML5 UP</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css"/>
    <noscript>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css"/>
    </noscript>
</head>
<body class="is-loading">

<tiles:insertAttribute name="top"/>
<%-- <tiles:insertAttribute name="menu" /> --%>
<div id="main">
    <tiles:insertAttribute name="body"/>
</div>
<tiles:insertAttribute name="foot"/>

<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>

