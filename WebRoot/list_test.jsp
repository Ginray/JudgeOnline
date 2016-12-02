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

<body onLoad="goPage(1,10);">
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
	
	
<table id="idData"  class="table table-striped"  >  
   
        <tr><td>测试</td><td>1</td><td>test</td><td>list_TEST</td></tr>  
        <tr><td>测试</td><td>2</td><td>test</td><td>list_TEST</td></tr>  
        <tr><td>测试</td><td>3</td><td>test</td><td>list_TEST</td></tr>  
        <tr><td>测试</td><td>4</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>5</td><td>test</td><td>list_TEST</td></tr>   
  		<tr><td>测试</td><td>6</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>7</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>8</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>9</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>10</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>11</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>12</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>13</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>14</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>15</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>16</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>17</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>18</td><td>test</td><td>list_TEST</td></tr> 
  		<tr><td>测试</td><td>19</td><td>test</td><td>list_TEST</td></tr> 
        <tr><td>测试</td><td>20</td><td>test</td><td>list_TEST</td></tr>   
        <tr><td>测试</td><td>21</td><td>test</td><td>list_TEST</td></tr>        
    </table>

    <table width="60%" align="right">
        <tr><td><div id="barcon" name="barcon"></div></td></tr>
    </table>

	</div>

	
	
	
	
	
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
    if(num/pageSize > parseInt(num/pageSize)){   
            totalPage=parseInt(num/pageSize)+1;   
       }else{   
           totalPage=parseInt(num/pageSize);   
       }   
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize+1;//开始显示的行  31 
    var endRow = currentPage * pageSize;//结束显示的行   40
    endRow = (endRow > num)? num : endRow;    
    console.log(endRow);
       //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){    
        var irow = itable.rows[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "";    
        }else{
            irow.style.display = "none";
        }
    }
    var pageEnd = document.getElementById("pageEnd");
    var tempStr = "共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页";
    if(currentPage>1){
        tempStr += "<a href=\"javascript:void(0);\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
        tempStr += "<a href=\"javascript:void(0);\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
    }else{
        tempStr += "首页";
        tempStr += "<上一页";    
    }

    if(currentPage<totalPage){
        tempStr += "<a href=\"javascript:void(0);\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
        tempStr += "<a href=\"javascript:void(0);\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
    }else{
        tempStr += "下一页>";
        tempStr += "尾页";    
    }

    document.getElementById("barcon").innerHTML = tempStr;
    
}


</script>
  
  
</html>