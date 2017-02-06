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
				<%
				   String username = (String)request.getSession().getAttribute("username"); 
				   String nickname = (String)request.getSession().getAttribute("nickname");
				   String email = (String)request.getSession().getAttribute("email"); 
				%>
				<h3>
					<strong>Information of <%=username %>:</strong>
				</h3>
				<ul class="list-group">
				<li class="list-group-item">Username :&nbsp&nbsp&nbsp<%=username %></li>
				<li class="list-group-item">Nickname :&nbsp&nbsp&nbsp<%=nickname %> </li>
				<li class="list-group-item">Email&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :&nbsp&nbsp&nbsp<%=email %></li>
								
				</ul>

			</div>
		</div>

		
	</div>

</div>

 </body>
  
</html>
