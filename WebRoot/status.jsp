<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="com.zjgsu.service.*" %>
<%@ page language="java" import="model.*" %>
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

    <link rel="Shortcut Icon" href="img/zjgsu.png"/>

    <!-- 自动刷新 -->
    <!--
        <meta http-equiv="refresh" content="2;url=status.jsp">
    -->

</head>

<body onLoad="goPage(1,20);">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <jsp:include page="menu.jsp"></jsp:include>
        </div>
    </div>
    <form id="form1" action="" method="post">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-7 column">
                    <br><!-- 需要一个换行才能对齐 -->
                    <div class="input-group">
                        <input name="search_keyword" id="search_keyword" type="text"
                               placeholder="please input the problem id " class="form-control input">

                        <a onClick="clickScript()" class="input-group-addon btn btn-info btn">
                            <span class="glyphicon glyphicon-search"></span> Search
                        </a>

                    </div>
                </div>
                <div class="col-md-5 column">
                    <ul id="sbar" class="pagination ">

                    </ul>
                </div>

            </div>
        </div>

    </form>
    <table id="idData" class="table table-striped">
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
            <td><%=s.getId() %>
            </td>
            <td><%=s.getProblemId() %>
            </td>
            <td><%=nickname%>
            </td>
            <%
                String color;
                String state = s.getState();
                String showState;
                if ("rightAnswer".equals(state)) {
                    color = "text-success";
                    showState="Accepted";
                }
                else if ("compileError".equals(state)){
                    color = "text-primary";
                    showState="Compilation Error";
                }
                else if("wrongAnswer".equals(state)){
                    color = "text-danger";
                    showState="Wrong Answer";
                }
                else {
                    color = "text-danger";
                    showState=state;
                }
                int memory = Integer.valueOf(s.getMemory()) / 1024;
            %>
            <td class=<%=color %>><%=showState%>
            </td>
            <td><%=s.getCodeType() %>
            </td>
            <td><%=s.getRuntime() %> MS</td>
            <td><%=memory%> K</td>
            <td><%=s.getCodeLength() %> B
            </td>
            <td><%=s.getSubmitDate() %>
            </td>
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

</body>


<script>
    function clickScript() {
        var s = "problem_searchStatus.action?keyword=" + document.getElementById("search_keyword").value;
        document.getElementById("form1").action = s;
        document.getElementById("form1").submit();

    }
    function goPage(pno, psize) {

        var itable = document.getElementById("idData");
        var num = itable.rows.length;//表格所有行数(所有记录数)
        console.log(num);
        var totalPage = 0;//总页数
        var pageSize = psize;//每页显示行数
        //总共分几页
        if ((num - 1) / pageSize > parseInt((num - 1) / pageSize)) {
            totalPage = parseInt((num - 1) / pageSize) + 1;
        } else {
            totalPage = parseInt((num - 1) / pageSize);
        }
        var currentPage = pno;//当前页数
        var startRow = "";
        var endRow = "";
        if (currentPage == 1) {
            startRow = (currentPage - 1) * pageSize + 1;//开始显示的行
        }
        else {
            startRow = (currentPage - 1) * pageSize + 2;//开始显示的行
        }
        endRow = currentPage * pageSize + 1;//结束显示的行
        endRow = (endRow > num) ? num : endRow;
        console.log(endRow);

        //遍历显示数据实现分页
        //itable.rows该集合包括 <thead>、<tfoot> 和 <tbody> 中定义的所有行。
        for (var i = 2; i <= num; i++) {
            var irow = itable.rows[i - 1];
            if (i >= startRow && i <= endRow) {
                irow.style.display = "";
            } else {
                irow.style.display = "none";
            }
        }


        var tempStr = "";

        //"共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
        if (currentPage > 1) {
            tempStr += "<li>" + "<a href=\"javascript:void(0);\" onClick=\"goPage(" + (1) + "," + psize + ")\">First</a>" + "</li>";
            tempStr += "<li>" + "<a href=\"javascript:void(0);\" onClick=\"goPage(" + (currentPage - 1) + "," + psize + ")\">Prev</a>" + "</li>";
        } else {
            tempStr += "<li>" + "<a class=\"btn btn-default active \" disabled=\"disabled\">" + "First" + "</a>" + "</li>";
            tempStr += "<li>" + "<a class=\"btn btn-default active\"  disabled=\"disabled\">" + "Prev" + "</a>" + "</li>";
        }

        var fpage = 1;
        while (currentPage - fpage > 3) {
            fpage += 1;
        }

        for (var i = fpage; i < currentPage; i++) {
            tempStr += "<li>" + "<a href=\"javascript:void(0);\" onClick=\"goPage(" + (i) + "," + psize + ")\">" + (i) + "</a>" + "</li>";
        }

        tempStr += "<li>" + "<a class=\"btn btn-info active\" disabled=\"disabled\">" + (currentPage) + "</a>" + "</li>";

        fpage = currentPage;

        while (fpage < totalPage && (fpage - currentPage <= 3)) {
            fpage += 1;
            tempStr += "<li>" + "<a href=\"javascript:void(0);\" onClick=\"goPage(" + (fpage) + "," + psize + ")\">" + (fpage) + "</a>" + "</li>";
        }


        if (currentPage < totalPage) {
            tempStr += "<li>" + "<a href=\"javascript:void(0);\" onClick=\"goPage(" + (currentPage + 1) + "," + psize + ")\">Next</a>" + "</li>";
            tempStr += "<li>" + "<a href=\"javascript:void(0);\" onClick=\"goPage(" + (totalPage) + "," + psize + ")\">Last</a>" + "</li>";

        } else {
            tempStr += "<li>" + "<a class=\"btn btn-default active\" disabled=\"disabled\">" + "Last" + "</a>" + "</li>";
            tempStr += "<li>" + "<a class=\"btn btn-default active\" disabled=\"disabled\">" + "Next" + "</a>" + "</li>";
        }

        document.getElementById("sbar").innerHTML = tempStr;

    }


</script>
</html>
