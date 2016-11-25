<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.zjgsu.service.*"%>
<%@ page language="java" import="model.*"%>
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
      <th>RunID</th>
      <th>Problem ID</th>
      <th>Username</th>
      <th>Result</th>
      <th>Language</th>
      <th>Time</th>
      <th>Memory</th>
      <th>Code Length</th>
      <th>Submit Time</th>
    </tr>
  </thead>
  <tbody>
    
    <%
		try {
			ProblemService problemservice = new ProblemServiceImpl();
			List<Submitstate> sumitStates = problemservice.showState();
			for (int i = 0; i < sumitStates.size(); i++) {
				Submitstate s = sumitStates.get(i);
				String nickname = problemservice.findUsername(s.getUserId());
	%>
    <tr>
      <td><%=s.getId() %></td>
      <td><%=s.getProblemId() %></td>
      <td><%=nickname%></td>
      <%
      		String color;
      		String state=s.getState();
      		if("rightAnswer".equals(state))
      			color="text-success";
      		else if("compileError".equals(state))
      			color="text-primary";
      		else
      			color="text-danger";
      		
      		int memory =Integer.valueOf(s.getMemory())/1024;
      %>
      <td class =<%=color %>><%=s.getState()%></td>
      <td><%=s.getCodeType() %></td>
      <td><%=s.getRuntime() %> ms</td>
      <td><%=memory%> byte</td>
      <td><%=s.getCodeLength() %></td>
      <td><%=s.getSubmitDate() %></td>
    </tr>
    
    
    
    <%
		}
		} catch (Exception e) {
			System.out.println(e);
		}
    %>
    
    
  </tbody>
</table>

	</div>
	
	</div>

 </body>
  
</html>
