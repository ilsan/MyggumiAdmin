<div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">
          	<img src="<%=request.getContextPath()%>/assets/images/logo30.png" alt="">Admin Page</a>
        </div> 
        
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="${pageContext.request.contextPath}/stat">
              <i class="icon-home icon-white"></i> Statistics</a>
              </li>                            
              <li>
              <a href="/product/productList">
              <i class="icon-th icon-white"></i>상품등록</a>
              </li>
              <li>
              <a href="${pageContext.request.contextPath}/statistics">
              <i class="icon-lock icon-white"></i> Login</a>
              </li>
              <li>
              <a href="user.html">
              <i class="icon-user icon-white"></i> User</a>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
</div>