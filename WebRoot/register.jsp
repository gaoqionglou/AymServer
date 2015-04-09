<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>注册</title>
  </head>
  
  <body>
   <form action="/AymServer/register.action" method="post"> 
   手机号：<input name ="phonenum" type="text"><br/>
   密码：<input name ="password" type="text"><br/>
  <input type="submit"  value="注册">
  </form>
  </body>
</html>
