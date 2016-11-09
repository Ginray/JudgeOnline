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
					 <a href="problem.jsp">Problem</a>
				</li>
				<li>
					 <a href="#">Status</a>
				</li>
				<li>
					 <a href="#">Ranklist</a>
				</li>
				<li class="dropdown">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown">More<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 <a href="#">Action</a>
						</li>
						<li>
							 <a href="#">Another action</a>
						</li>
						<li>
							 <a href="#">Something else here</a>
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
				<li><a>
				<button class="btn btn-primary-sm " data-toggle="modal" data-target="#login">
					Login
				</button>
				</a></li>
				<li><a>
				<button class="btn btn-primary " data-toggle="modal" data-target="#register">
					Register
				</button>
				</a></li>
			
			</ul>
		</div>
		
</nav>

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
			<div class="modal-body">
				
				<div class="input-group">
					<span class="input-group-addon">Username:</span>
					<input type="text" class="form-control" placeholder="Username">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Password:</span>
					<input type="text" class="form-control" placeholder="Password">
				</div><br>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Submit
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close
				</button>
			</div>
			
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


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
			<div class="modal-body">
				
				<div class="input-group">
					<span class="input-group-addon">Username:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" class="form-control" placeholder="Username">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Password:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" class="form-control" placeholder="Password">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Repeat Password:</span>
					<input type="text" class="form-control" placeholder="Repeat Password">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Nickname:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" class="form-control" placeholder="Nickname">
				</div><br>
				<div class="input-group">
					<span class="input-group-addon">Email:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
					<input type="text" class="form-control" placeholder="Email">
				</div><br>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">Register
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close
				</button>
			</div>
			
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>



</html>
