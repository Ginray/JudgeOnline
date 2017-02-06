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
    <style type="text/css">
        .h.jumbotron {
            padding: 5px;
            padding-left: 50px;
        }
    </style>

</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <jsp:include page="menu.jsp"></jsp:include>
        </div>
        <div class="col-md-12 column ">
            <h1 class="text-center text-primary">A+B problem</h1>
            <!--
             关于文本字体颜色：text-muted（灰色 色值为#777），text-primary（蓝色 #428bca），
             text-success（绿色 #5cb85c）,text-info（浅蓝色 #5bc0de），
             text-warning（橙色  #f0ad4e），text-danger（红色 #d9534f）

              关于背景颜色：bg-primary（蓝色 #428bca），bg-info（浅蓝色  #5bc0de）,
             bg-waring（橙色 #f0ad4e），bg-success（绿色 #5cb85c），bg-danger（红 #d9534f）
             -->
            <h5 class="text-center text-info">
                Time Limit: 1000ms&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                Memory Limit: 32768KB <br>
                64-bit integer IO format: %lld &nbsp&nbsp&nbsp&nbsp&nbsp&nbspJava class name: Main
            </h5>
            <h3 class="text-info">Problem</h3>
            <div class="h jumbotron">
                <h4 class="text-left">
                    Calculate a+b.
                </h4>
            </div>
            <h3 class="text-info">Input</h3>
            <div class="h jumbotron">
                <h4 class="text-left">
                    Two integer a and b per line.
                </h4>
            </div>
            <h3 class="text-info">Output</h3>
            <div class="h jumbotron">
                <h4 class="text-left">
                    Output a+b for each line.
                </h4>
            </div>
            <h3 class="text-info">Sample Input </h3>
            <div class="h jumbotron">
                <h4 class="text-left">
                    1 2<br>
                    -5 6
                </h4>
            </div>
            <h3 class="text-info">Sample Output </h3>
            <div class="h jumbotron">
                <h4 class="text-left">
                    3<br>
                    1
                </h4>
            </div>
            <h3 class="text-info">Hint </h3>
            <div class="h jumbotron">
                <h4 class="text-left">
                    0.0
                </h4>
            </div>

            <br>
            <center>
                <div class="btn-group ">
                    <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#submit">
                        Submit
                    </button>
                    <button type="button" class="btn btn-default">Status</button>
                    <button type="button" class="btn btn-default">Statistic</button>
                    <button type="button" class="btn btn-default">Discuss</button>
                </div>

                <br><br><br><br>
            </center>
        </div>


    </div>

</div>


</body>

<!--提交  -->
<div class="modal fade form-inline" id="submit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" style="width:800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title text-primary" id="myModalLabel">
                    Submit your code
                </h4>
            </div>
            <%
                String username = (String) request.getSession().getAttribute("username");
            %>
            <center>
                <h4>
                    Username:&nbsp&nbsp&nbsp<%=username %>
                    <br>

                    Language:
                    <select class="combobox form-control">
                        <option value="GNU_C">GNU C</option>
                        <option value="GNU_C++">GNU C++</option>
                        <option value="JAVA">JAVA</option>
                    </select>

                </h4>
            </center>
            <form action="judge_submitCode.action" method="post">
                <div class="modal-body">
                    <center><h4>Source Code: </h4></center>
                    <textarea class="form-control" name="submitproblem.codetext" rows="30" cols="90"></textarea>

                </div>


                <div class="modal-footer ">
                    <button type="submit" class="btn btn-primary btn-center">Submit
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close
                    </button>
                </div>


            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</html>
