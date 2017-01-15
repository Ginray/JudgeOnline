<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="index.jsp">ZJGSU JudgeOnline</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li >
					 <a href="problem_list.jsp">Problem</a>
				</li>
				<li>
					 <a href="status.jsp">Status</a>
				</li>
				<li>
					 <a href="ranklist.jsp">Ranklist</a>
				</li>
				<li class="dropdown">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown">More<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="counter.jsp">Show online acmer</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="#">Separated link</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="#">One more separated link</a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
				   String username = (String)request.getSession().getAttribute("username"); 
				%>
				<%
					if(username!=null){
				%>
				<li class="dropdown">
					 <a href="personal_info.jsp" class="dropdown-toggle" data-toggle="dropdown"><%=username %>&nbsp&nbsp <strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="personal_info.jsp">Show My Information</a>
						</li>
						<li>
							 <a href ="#" data-toggle="modal" data-target="#modify">Modify My Information</a>
						</li>
						<li>
							 <a href="user_userlogout.action">Logout</a>
						</li>
					</ul>
				</li>
				
				<%
					}
					else{
				%>
				<li><a>
				<button class="btn btn-primary-sm " data-toggle="modal" data-target="#register">
					Register
				</button>
				</a></li>
				<li><a>
				<button class="btn btn-primary " data-toggle="modal" data-target="#login">
					Login
				</button>
				</a></li>
				
				<%
					}
				%>
			
			</ul>
		</div>
		
</nav>




<!--登陆  -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					Login
				</h4>
			</div>
			
			
			<form  action ="user_userlogin.action" method = "post">
			<div class="modal-body">
				
				<div class="input-group">
					<span class="input-group-addon">Username:</span>
					<input type="text" name ="userinfo.username" class="form-control" placeholder="Username">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Password:</span>
					<input type="password" name ="userinfo.password" class="form-control" placeholder="Password">
				</div><br>


			</div>
			
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">Submit
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close
				</button>
			</div>
			
			</form>
			
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!--注册 -->

<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					Register
				</h4>
			</div>
			
			<form  action ="user_userregister.action" method = "post" onsubmit="return check();"  >
			<div class="modal-body">
				
				<div class="input-group">
					<span class="input-group-addon">Username:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" name ="userinfo.username" class="form-control" placeholder="Username">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Password:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="password" name ="userinfo.password" id="password" class="form-control" placeholder="Password">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Repeat Password:</span>
					<input type="password" class="form-control" id="repsword"  placeholder="Repeat Password">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Nickname:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" name ="userinfo.nickname" class="form-control" placeholder="Nickname">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Email:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" name ="userinfo.email" class="form-control" placeholder="Email">
				</div><br>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">Register
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close
				</button>
			</div>
			
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>



<!--修改  -->
<div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					Modify
				</h4>
			</div>
			
			<form  action ="user_usermodify.action" method = "post" onsubmit="return checkmo();" >
			<div class="modal-body">
				
				<div class="input-group">
					<span class="input-group-addon">Username:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" name ="userinfo.username" class="form-control" placeholder=<%=username %> disabled>
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">New Password:&nbsp&nbsp&nbsp&nbsp</span>
					<input type="password" name ="userinfo.password" id= "mopassword" class="form-control" placeholder="New Password">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Repeat Password:</span>
					<input type="password" class="form-control" id="morepsword" placeholder="Repeat Password">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Nickname:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" name ="userinfo.nickname" class="form-control" placeholder="Nickname">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Email:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" name ="userinfo.email" class="form-control" placeholder="Email">
				</div><br>
				
			</div>
			
			
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">Modify
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close
				</button>
			</div>
			
			</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<script>
function check(){
	   var password = document.getElementById("password").value;
	   var repsword = document.getElementById("repsword").value;
	   if(password === ''){
	      alert('密码不能为空');
	      return false;
	   }
	   if(password != repsword) {
	      alert("两次密码不同，请重新输入");
	      return false;
	   }
}

function checkmo(){
	   var password = document.getElementById("mopassword").value;
	   var repsword = document.getElementById("morepsword").value;
	   if(password === ''){
	      alert('密码不能为空');
	      return false;
	   }
	   if(password != repsword) {
	      alert("两次密码不同，请重新输入");
	      return false;
	   }
}
</script>

</html>
