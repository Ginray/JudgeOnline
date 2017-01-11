<%@page import="model.UserInfo"%>
<%@page import="com.zjgsu.service.UserServiceImpl"%>
<%@page import="com.zjgsu.service.UserService"%>
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

<body onLoad="goPage(1,20);">
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
    	<input type="text" class="form-control input">
		<a href="#" class="input-group-addon btn btn-info btn">
         	 <span class="glyphicon glyphicon-search"></span> Search
       	</a>
		</div>
	</div>
	<div class="col-md-5 column">
	 <ul id="sbar"  class="pagination ">
		
    </ul>
	</div>

	</div>
	</div>
	
	
<table  id="idData"   class="table table-striped">
  <thead>
    <tr>
      <th>Rank</th>
      <th>Username</th>
      <th>Nickname</th>
      <th>AC</th>
      <th>Submit</th>
      <th>AC Ratio</th>
    </tr>
  </thead>
 <tbody>
    
    <%
		try {
			UserService userService = new UserServiceImpl();
			List<UserInfo> userInfo = userService.getUser();
			for (int i = 0; i < userInfo.size(); i++) {
				UserInfo u = userInfo.get(i);
				double ratio=0;
				if(u.getSubmit()!=0)
					ratio =100*u.getAccept()/u.getSubmit();
	%>
	
    <tr>
      <td><%=i+1 %></td>
      <td><%=u.getUsername() %></td>
      <td><%=u.getNickname()%></td>
      <td><%=u.getAccept()%></td>
      <td><%=u.getSubmit() %></td>
      <td><%=ratio %>%</td>
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
	function goPage(pno,psize){ 
		  
    var itable = document.getElementById("idData");
    var num = itable.rows.length;//表格所有行数(所有记录数)
    console.log(num);
    var totalPage = 0;//总页数
    var pageSize = psize;//每页显示行数
    //总共分几页 
    if((num-1)/pageSize > parseInt((num-1)/pageSize)){   
          totalPage=parseInt((num-1)/pageSize)+1;   
    }else{   
          totalPage=parseInt((num-1)/pageSize);   
    }   
    var currentPage = pno;//当前页数
	var startRow="";
    var endRow="";
    if(currentPage==1){
    	startRow=  (currentPage - 1) * pageSize+1;//开始显示的行  
    }
    else{
		startRow = (currentPage - 1) * pageSize+2;//开始显示的行  
    }
	endRow = currentPage * pageSize+1;//结束显示的行  
	endRow = (endRow > num)? num : endRow;    
	console.log(endRow);
	
    //遍历显示数据实现分页
    //itable.rows该集合包括 <thead>、<tfoot> 和 <tbody> 中定义的所有行。
    for(var i=2;i<=num;i++){    
        var irow = itable.rows[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "";    
        }else{
            irow.style.display = "none";
        }
    }
       
  
    var tempStr = "";

    //"共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
    if(currentPage>1){
        tempStr += "<li>"+"<a href=\"javascript:void(0);\" onClick=\"goPage("+(1)+","+psize+")\">First</a>"+"</li>";
        tempStr += "<li>"+"<a href=\"javascript:void(0);\" onClick=\"goPage("+(currentPage-1)+","+psize+")\">Prev</a>"+"</li>";
    }else{
        tempStr += "<li>"+"<a class=\"btn btn-default active \" disabled=\"disabled\">"+"First"+"</a>"+"</li>";
        tempStr += "<li>"+"<a class=\"btn btn-default active\" disabled=\"disabled\">"+"Prev"+"</a>"+"</li>";    
    }
    
    var fpage=1;
    while(currentPage-fpage>3){
    	fpage+=1;
    }
   
    for(var i=fpage;i<currentPage;i++){
    	 tempStr += "<li>"+"<a href=\"javascript:void(0);\" onClick=\"goPage("+(i)+","+psize+")\">"+(i)+"</a>"+"</li>";
    }
    
    tempStr += "<li>"+"<a class=\"btn btn-info active\" disabled=\"disabled\">"+(currentPage)+"</a>"+"</li>";    

    fpage=currentPage;
    
    while(fpage<totalPage&&(fpage-currentPage<=3)){
    	fpage+=1;
    	tempStr += "<li>"+"<a href=\"javascript:void(0);\" onClick=\"goPage("+(fpage)+","+psize+")\">"+(fpage)+"</a>"+"</li>";
    }
    
    
    if(currentPage<totalPage){
        tempStr += "<li>"+"<a href=\"javascript:void(0);\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">Next</a>"+"</li>";
        tempStr += "<li>"+"<a href=\"javascript:void(0);\" onClick=\"goPage("+(totalPage)+","+psize+")\">Last</a>"+"</li>";
        
    }else{
        tempStr += "<li>"+"<a class=\"btn btn-default active\" disabled=\"disabled\">"+"Last"+"</a>"+"</li>";
        tempStr += "<li>"+"<a class=\"btn btn-default active\" disabled=\"disabled\">"+"Next"+"</a>"+"</li>";    
    }

    document.getElementById("sbar").innerHTML = tempStr;
    
}    



</script>
</html>
