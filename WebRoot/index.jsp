<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ZJGSU Judge Online</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" href="css/bootstrap.css">  
  	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    
    <link rel="Shortcut Icon" href="img/zjgsu.png" /> 
    
  </head>
  
  <body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<jsp:include page = "menu.jsp"></jsp:include>
			<div class="jumbotron">
				<h1>
					Hello!
				</h1>
				<p>
					&nbsp&nbsp&nbsp&nbspWe had to be rescued from our folly by a rebel alliance of obsessive geeks and creative misfits—who then proceeded to show us that professionalism and dedication really meant what we had been doing before we succumbed to the mundane persuasions of "sound business practices".					
				</p>
				<p  class="text-right">
					-- The Art of Unix Programming
				</p>
				<p>
					 <a class="btn btn-primary btn-large" href="http://www.catb.org/esr/writings/taoup/html/">Learn more</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		

	</div>
</div>

 </body>
  
</html>
