    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>My JSP 'index.jsp' starting page</title>  
      </head>  
        
      <body>  
        <a href="${pageContext.request.contextPath }/test_update.action?category.username=w&category.password=w&category.nickname=w&category.email=w">访问update</a>  
        <a href="test_save.action">访问save</a>  
      </body>  
    </html>  