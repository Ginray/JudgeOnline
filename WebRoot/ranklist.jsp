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
		</div>
	</div>
	
	<div class="col-md-12 column">
	<div class="row clearfix">
	<div class="col-md-7 column">
		<br><!-- 需要一个换行才能对齐 -->
		<div class="input-group">
    	<input type="text" class="form-control input"><span class="input-group-addon btn btn-primary">Search</span>
		</div>
	</div>
	<div class="col-md-5 column">
		<ul class="pagination ">
			<li>
				 <a href="#">Prev</a>
			</li>
			<li>
				 <a href="#">1</a>
			</li>
			<li>
				 <a href="#">2</a>
			</li>
			<li>
				 <a href="#">3</a>
			</li>
			<li>
				 <a href="#">4</a>
			</li>
			<li>
				 <a href="#">5</a>
			</li>
			<li>
				 <a href="#">6</a>
			</li>
			<li>
				 <a href="#">7</a>
			</li>
			<li>
				 <a href="#">8</a>
			</li>
			<li>
				 <a href="#">Next</a>
			</li>
		</ul>
	</div>

	</div>
	
	
	
<table class="table table-striped">
  <thead>
    <tr>
      <th>Rank</th>
      <th>Username</th>
      <th>Nickname</th>
      <th>AC</th>
    </tr>
  </thead>
  <tbody>
    
  </tbody>
</table>

	</div>

	
	
	
	
	
	</div>

 </body>
  
</html>
