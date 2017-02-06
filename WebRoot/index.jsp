<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <%
        String re_URL = request.getRequestURL().toString();
        session.setAttribute("re_URL", re_URL);
    %>
    <title>ZJGSU Judge Online</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-growl.js"></script>
    <link rel="Shortcut Icon" href="img/zjgsu.png"/>

</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <jsp:include page="menu.jsp"></jsp:include>
            <div class="jumbotron">
                <h1>
                    Hello!
                </h1>
                <p>
                    &nbsp&nbsp&nbsp&nbspWe had to be rescued from our folly by a rebel alliance of obsessive geeks and
                    creative misfits—who then proceeded to show us that professionalism and dedication really meant what
                    we had been doing before we succumbed to the mundane persuasions of "sound business practices".
                </p>
                <p class="text-right">
                    -- The Art of Unix Programming
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="http://www.catb.org/esr/writings/taoup/html/">Learn
                        more</a>
                </p>
            </div>
        </div>
    </div>


    <div class="panel panel-info">
        <div class="col-md-6 column ">
            <h2 class="panel-heading text text-info">
                <font face="Kristen ITC">
                    Happy New Year !!!
                </font>
            </h2>
            <p class="panel-body">
                <font size="4" face="Segoe Script">
                    Much joy to you in the up coming year. May the warmest wishes, happy thoughts and friendly greetings
                    come at New Year and stay with you all the year through.
                    <br/><br/>May the coming new year bring you peace, love and new bug &nbsp&nbsp : )
                </font>
            </p>

        </div>
        <div class="col-md-6 column">
            <img src="img/new_year.jpg"/>
        </div>


    </div>
</div>

</body>

</html>