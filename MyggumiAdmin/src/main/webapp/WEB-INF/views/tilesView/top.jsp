<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">
          	<img src="<%=request.getContextPath()%>/assets/images/logo30.png" alt="">Myggumi Admin</a>
        </div>
        <%--
         ${requestScope['javax.servlet.forward.servlet_path']}; el로 해당 url 가져올때
         <%=request.getAttribute("javax.servlet.forward.request_uri").equals("/admin/product/productList")%> java코드로 해당url 가져올때 
        --%>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            <c:if test='<%=request.getAttribute("javax.servlet.forward.request_uri").equals("/admin/product/productList")%>'> 
 				 <c:set value="active" var="cssClass1"></c:set>
			</c:if>
              <li class="${cssClass1}"><a href="/admin/product/productList">
              <i class="icon-home icon-white"></i>상품 등록</a>
              </li>
            <c:if test='<%=request.getAttribute("javax.servlet.forward.request_uri").equals("/admin/member/memberList")%>'> 
 				 <c:set value="active" var="cssClass2"></c:set>
			</c:if>                         
              <li class="${cssClass2}">
              <a href="/admin/member/memberList">
              <i class="icon-th icon-white"></i>회원관리</a>
              </li>
              <li>
              <a href="${pageContext.request.contextPath}/statistics">
              <i class="icon-lock icon-white"></i> Login</a>
              </li>
              <li>
              <a href="">
              <i class="icon-user icon-white"></i>뽑기</a>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
</div>