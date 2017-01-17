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
				<li>
					 <a href="counter.jsp">SOLO!</a>
					 <!--  
					 <a href="counter.jsp">SOLO! <span class="label label-warning">Alpha</span></a>
					 -->
					
				</li>
				<li class="dropdown">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown">More<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href=#>action</a>
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
		   $.bootstrapGrowl("Empty Password !", {  
			   ele: 'body', // which element to append to  绑定到某个元素  
			   type: 'danger', // (null, 'info', 'danger', 'success')  提示的类型  
			   offset: {from: 'top', amount: 30}, // 'top', or 'bottom' 相对顶部或者底部的距离  
			   align: 'center', // ('left', 'right', or 'center')    位置 左右居中  
			   width: 400, // (integer, or 'auto') 宽度  
			   delay: 2000, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!  自动消失时间设置  
			   allow_dismiss: true, // If true then will display a cross to close the popup. 是否出现小叉叉点击就取消提示框  
			   stackup_spacing: 10 // spacing between consecutively stacked growls. 相邻提示框的间距   
			 });  
	      return false;
	   }
	   if(password != repsword) {
		   $.bootstrapGrowl("Password doesn't match !", {  
			   ele: 'body',
			   type: 'danger',
			   offset: {from: 'top', amount: 30},   
			   align: 'center',  
			   width: 400, 
			   delay: 2000, 
			   allow_dismiss: true, 
			   stackup_spacing: 10
			 });  
	      return false;
	   }
	   $.bootstrapGrowl("Success !", {  
		   ele: 'body',   
		   type: 'success', 
		   offset: {from: 'top', amount: 30},
		   align: 'center', 
		   width: 400, 
		   delay: 2000, 
		   allow_dismiss: true, 
		   stackup_spacing: 10 
		 });   
}

function checkmo(){
	   var password = document.getElementById("mopassword").value;
	   var repsword = document.getElementById("morepsword").value;
	   if(password === ''){
		   $.bootstrapGrowl("Empty Password !", {  
			   ele: 'body',  
			   type: 'danger', 
			   offset: {from: 'top', amount: 30},   
			   align: 'center', 
			   width: 400,
			   delay: 2000,
			   allow_dismiss: true, 
			   stackup_spacing: 10  
			 });  
	      return false;
	   }
	   if(password != repsword) {
		   $.bootstrapGrowl("Password doesn't match !", {  
			   ele: 'body',
			   type: 'danger',
			   offset: {from: 'top', amount: 30},   
			   align: 'center',  
			   width: 400, 
			   delay: 2000, 
			   allow_dismiss: true, 
			   stackup_spacing: 10
			 });  
	      return false;
	   }
	   $.bootstrapGrowl("Success !", {  
		   ele: 'body',   
		   type: 'success', 
		   offset: {from: 'top', amount: 30},
		   align: 'center', 
		   width: 400, 
		   delay: 2000, 
		   allow_dismiss: true, 
		   stackup_spacing: 10 
		 });  
}
</script>

</html>
