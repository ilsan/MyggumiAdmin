<%--
  Created by IntelliJ IDEA.
  User: jihoonlee
  Date: 2017. 12. 31.
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>

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

<div id="main">
    <tiles:insertAttribute name="body"/>
</div>
</body>
</html>

