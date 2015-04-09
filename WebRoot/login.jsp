<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
   <form action="/AymServer/login.action" method="post"> 
   手机号：<input name ="phonenum" type="text"><br/>
   密码：<input name ="password" type="text"><br/>
  <input type="submit"  value="登录">
  </form>
  </body>
</html>
