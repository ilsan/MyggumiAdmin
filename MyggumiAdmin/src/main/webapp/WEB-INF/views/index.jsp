
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>

 <script type="text/javascript">
 
 </script>



<form action="" id="form_ex" method="post">

 <div class="container">

	  <!-- FIRST ROW OF BLOCKS -->     
      <div class="row">

      <!-- USER PROFILE BLOCK -->
        <div class="col-sm-3 col-lg-3">
      		<div class="dash-unit">
	      		<dtitle>User Profile</dtitle>
	      		<hr>
				<div class="thumbnail">
					<img src="assets/images/face80x80.jpg" alt="Marcel Newman" class="img-circle">
				</div><!-- /thumbnail -->
				<h1>Marcel Newman</h1>
				<h3>Madrid, Spain</h3>
				<br>
					<div class="info-user">
						<span aria-hidden="true" class="li_user fs1"></span>
						<span aria-hidden="true" class="li_settings fs1"></span>
						<span aria-hidden="true" class="li_mail fs1"></span>
						<span aria-hidden="true" class="li_key fs1"></span>
					</div>
				</div>
        </div>

      <!-- DONUT CHART BLOCK -->
        <div class="col-sm-3 col-lg-3">
      		<div class="dash-unit">
		  		<dtitle>Site Bandwidth</dtitle>
		  		<hr>
	        	<div id="load"></div>
	        	<h2>45%</h2>
			</div>
        </div>

      <!-- DONUT CHART BLOCK -->
        <div class="col-sm-3 col-lg-3">
      		<div class="dash-unit">
		  		<dtitle>Disk Space</dtitle>
		  		<hr>
	        	<div id="space"></div>
	        	<h2>65%</h2>
			</div>
        </div>
        
        <div class="col-sm-3 col-lg-3">

      <!-- LOCAL TIME BLOCK -->
      		<div class="half-unit">
	      		<dtitle>Local Time</dtitle>
	      		<hr>
		      		<div class="clockcenter">
			      		<digiclock>12:45:25</digiclock>
		      		</div>
			</div>

      <!-- SERVER UPTIME -->
			<div class="half-unit">
	      		<dtitle>Server Uptime</dtitle>
	      		<hr>
	      		<div class="cont">
					<p><img src="assets/images/up.png" alt=""> <bold>Up</bold> | 356ms.</p>
				</div>
			</div>

        </div>
      </div><!-- /row -->
      
      
	  <!-- SECOND ROW OF BLOCKS -->     
      <div class="row">
        <div class="col-sm-3 col-lg-3">
       <!-- MAIL BLOCK -->
      		<div class="dash-unit">
      		<dtitle>Inbox (1)</dtitle>
      		<hr>
      		<div class="framemail">
    			<div class="window">
			        <ul class="mail">
			            <li>
			                <i class="unread"></i>
			                <img class="avatar" src="assets/images/photo01.jpeg" alt="avatar">
			                <p class="sender">Adam W.</p>
			                <p class="message"><strong>Working</strong> - This is the last...</p>
			                <div class="actions">
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/undo.png" alt="reply"></a>
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/star_fav.png" alt="favourite"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/tag.png" alt="label"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/trash.png" alt="delete"></a>
			                </div>
			            </li>
			            <li>
			                <i class="read"></i>
			                <img class="avatar" src="assets/images/photo02.jpg" alt="avatar">
			                <p class="sender">Dan E.</p>
			                <p class="message"><strong>Hey man!</strong> - You have to taste ...</p>
			                <div class="actions">
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/undo.png" alt="reply"></a>
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/star_fav.png" alt="favourite"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/tag.png" alt="label"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/trash.png" alt="delete"></a>
			                </div>
			            </li>
			            <li>
			                <i class="read"></i>
			                <img class="avatar" src="assets/images/photo03.jpg" alt="avatar">
			                <p class="sender">Leonard N.</p>
			                <p class="message"><strong>New Mac :D</strong> - So happy with ...</p>
			                <div class="actions">
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/undo.png" alt="reply"></a>
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/star_fav.png" alt="favourite"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/tag.png" alt="label"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/trash.png" alt="delete"></a>
			                </div>
			            </li>
			            <li>
			                <i class="read"></i>
			                <img class="avatar" src="assets/images/photo04.jpg" alt="avatar">
			                <p class="sender">Peter B.</p>
			                <p class="message"><strong>Thank you</strong> - Finally I can ...</p>
			                <div class="actions">
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/undo.png" alt="reply"></a>
			                    <a><img src="http://png-1.findicons.com/files//icons/2232/wireframe_mono/16/star_fav.png" alt="favourite"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/tag.png" alt="label"></a>
			                    <a><img src="http://png-4.findicons.com/files//icons/2232/wireframe_mono/16/trash.png" alt="delete"></a>
			                </div>
			            </li>
			        </ul>
    			</div>
			</div>
		</div><!-- /dash-unit -->
    </div><!-- /span3 -->

	  <!-- GRAPH CHART - lineandbars.js file -->     
        <div class="col-sm-3 col-lg-3">
      		<div class="dash-unit">
      		<dtitle>Other Information</dtitle>
      		<hr>
			    <div class="section-graph">
			      <div id="importantchart"></div>
			      <br>
			      <div class="graph-info">
			        <i class="graph-arrow"></i>
			        <span class="graph-info-big">634.39</span>
			        <span class="graph-info-small">+2.18 (3.71%)</span>
			      </div>
			    </div>
			</div>
        </div>

	  <!-- LAST MONTH REVENUE -->     
        <div class="col-sm-3 col-lg-3">
      		<div class="dash-unit">
	      		<dtitle>Last Month Revenue</dtitle>
	      		<hr>
	      		<div class="cont">
					<p><bold>$879</bold> | <ok>Approved</ok></p>
					<br>
					<p><bold>$377</bold> | Pending</p>
					<br>
					<p><bold>$156</bold> | <bad>Denied</bad></p>
					<br>
					<p><img src="assets/images/up-small.png" alt=""> 12% Compared Last Month</p>

				</div>

			</div>
        </div>
        
	  <!-- 30 DAYS STATS - CAROUSEL FLEXSLIDER -->     
        <div class="col-sm-3 col-lg-3">
      		<div class="dash-unit">
	      		<dtitle>Last 30 Days Stats</dtitle>
	      		<hr>
	      		<br>
	      		<br>
	            <div class="flexslider">
					<ul class="slides">
						<li><img src="assets/images/slide01.png" alt="slider"></li>
						<li><img src="assets/images/slide02.png" alt="slider"></li>
					</ul>
            </div>
				<div class="cont">
					<p>StatCounter Information</p>
				</div>   
			</div>
        </div>
      </div><!-- /row -->
     
 
      
	  <!-- FOURTH ROW OF BLOCKS -->     
	<div class="row">
	
	  <!-- TWITTER WIDGET BLOCK -->     
		<div class="col-sm-3 col-lg-3">
			<div class="dash-unit">
	      		<dtitle>Twitter Widget</dtitle>
	      		<hr>
				<div class="info-user">
					<span aria-hidden="true" class="li_megaphone fs2"></span>
				</div>
				<br>
		 		<div id="jstwitter" class="clearfix">
					<ul id="twitter_update_list"></ul>
				</div>
				<!-- To show your tweets replace "wrapbootstrap", in the line above, with your user. -->
				<div class="text">
				<p><grey>Show your tweets here!</grey></p>
				</div>
			</div>
		</div>

	  <!-- NOTIFICATIONS BLOCK -->     
		<div class="col-sm-3 col-lg-3">
			<div class="dash-unit">
	      		<dtitle>Notifications</dtitle>
	      		<hr>
	      		<div class="info-user">
					<span aria-hidden="true" class="li_bubble fs2"></span>
				</div>
	      		<div class="cont">
	      			<p><button class="btnnew noty" data-noty-options="{&quot;text&quot;:&quot;This is a success notification&quot;,&quot;layout&quot;:&quot;topRight&quot;,&quot;type&quot;:&quot;success&quot;}">Top Right</button></p>
	      			<p><button class="btnnew noty" data-noty-options="{&quot;text&quot;:&quot;This is an informaton notification&quot;,&quot;layout&quot;:&quot;topLeft&quot;,&quot;type&quot;:&quot;information&quot;}">Top Left</button></p>
	      			<p><button class="btnnew noty" data-noty-options="{&quot;text&quot;:&quot;This is an alert notification with fade effect.&quot;,&quot;layout&quot;:&quot;topCenter&quot;,&quot;type&quot;:&quot;alert&quot;,&quot;animateOpen&quot;: {&quot;opacity&quot;: &quot;show&quot;}}">Top Center (fade)</button></p>
	      		</div>
			</div>
		</div>

	  <!-- SWITCHES BLOCK -->     
		<div class="col-sm-3 col-lg-3">
			<div class="dash-unit">
	      		<dtitle>Switches</dtitle>
	      		<hr>
	      		<div class="info-user">
					<span aria-hidden="true" class="li_params fs2"></span>
				</div>
				<br>
				<div class="switch">
					<input type="radio" class="switch-input" name="view" value="on" id="on" checked="">
					<label for="on" class="switch-label switch-label-off">On</label>
					<input type="radio" class="switch-input" name="view" value="off" id="off">
					<label for="off" class="switch-label switch-label-on">Off</label>
					<span class="switch-selection"></span>
				</div>
				<div class="switch switch-blue">
					<input type="radio" class="switch-input" name="view2" value="week2" id="week2" checked="">
					<label for="week2" class="switch-label switch-label-off">Week</label>
					<input type="radio" class="switch-input" name="view2" value="month2" id="month2">
					<label for="month2" class="switch-label switch-label-on">Month</label>
					<span class="switch-selection"></span>
				</div>
				
				<div class="switch switch-yellow">
					<input type="radio" class="switch-input" name="view3" value="yes" id="yes" checked="">
					<label for="yes" class="switch-label switch-label-off">Yes</label>
					<input type="radio" class="switch-input" name="view3" value="no" id="no">
					<label for="no" class="switch-label switch-label-on">No</label>
					<span class="switch-selection"></span>
				</div>
			</div>
		</div>

	  <!-- GAUGE CHART BLOCK -->     
		<div class="col-sm-3 col-lg-3">
			<div class="dash-unit">
	      		<dtitle>Gauge Chart</dtitle>
	      		<hr>
	      		<div class="info-user">
					<span aria-hidden="true" class="li_lab fs2"></span>
				</div>
				<canvas id="canvas" width="300" height="300">
			</canvas></div>
		</div>
	
	</div><!--/row -->   



	
	
	

</form>
	
</body>
</html>
