<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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

    <link rel="Shortcut Icon" href="img/zjgsu.png"/>

</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <jsp:include page="menu.jsp"></jsp:include>
        </div>

    </div>


    <div class="col-md-12 column " style="padding: 100px 100px 10px;">
        <form class="bs-example bs-example-form" role="form">

            <div class="col-lg-6">
                <div class="input-group">
	                    <span class="input-group-btn">
	                        <button class="btn btn-default" type="button">Go!</button>
	                    </span>
                    <input type="text" class="form-control">
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" class="form-control">
                    <span class="input-group-btn">
	                        <button class="btn btn-default" type="button">Go!</button>
	                    </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->

        </form>
    </div>

</div>

</body>

</html>
