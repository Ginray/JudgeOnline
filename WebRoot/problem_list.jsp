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

<body onLoad="goPage(1,20);">
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<jsp:include page = "menu.jsp"></jsp:include>
		</div>
	</div>
	<form id ="form1" action="" method="post">
	<div class="col-md-12 column">
	<div class="row clearfix">
	<div class="col-md-7 column">
		<br><!-- 需要一个换行才能对齐 -->
		<div class="input-group">		
    	<input name="search_keyword" id="search_keyword" type="text" class="form-control input">

		<a  onClick= "clickScript()" class="input-group-addon btn btn-info btn">
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
	</form>
<table id="idData"  class="table table-striped"  >  
     <thead>
	    <tr>
	      <th>PID</th>
	      <th>Title</th>
	      <th>Source</th>
	      <th>AC</th>
	      <th>All</th>
	    </tr>
	  </thead>
  
    <tbody>
  
  
   <%
		try {
			ProblemService problemservice = new ProblemServiceImpl();
			List<Problem> problemList = problemservice.showProblem();
			for (int i = 0; i < problemList.size(); i++) {
				Problem p = problemList.get(i);
	%>
  			<tr>
		    <td><%=p.getProblemId() %></td>
		    <td><a href="problem_showProblem.action?problemId=<%=p.getProblemId() %>"><%=p.getTitle() %></a></td>
		    <td><%=p.getSource() %></td>
		    <td><%=p.getAccepted() %></td>
		    <td><%=p.getSubmit() %></td>
		    </tr>
    <%
			}
		}catch (Exception e) {
			System.out.println(e);
		}
  
    %>
  
  
    <tr>
      <td>1001</td>
      <td><a href ="problem_test.jsp">A + B Problem</a></td>
      <td>HDU</td>
      <td>192636</td>
      <td>616339</td>
    </tr>
	<tr><td>1002</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1003</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1004</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1005</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1006</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1007</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1008</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1009</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1010</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1011</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1012</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1013</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1014</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1015</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1016</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1017</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1018</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1019</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1020</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1021</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1022</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1023</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1024</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1025</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1026</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1027</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1028</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1029</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1030</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1031</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1032</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1033</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1034</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
    <tr><td>1035</td><td>A + B Problem IV</td><td>HDU</td><td>63683</td><td>328034</td></tr>
   
    </tbody>
    
    </table>


	
	
	

	
	
	
	
	
 </div>

 </body>
  

  
  <script>
	function clickScript(){
		  var s =  "problem_searchProblem.action?keyword="+document.getElementById("search_keyword").value;
	      document.getElementById("form1").action= s;
	      document.getElementById("form1").submit();

	}
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