<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>修改密码</title>
  </head>
  
  <body>
   <form action="/AymServer/modify.action" method="post"> 
   手机号：<input name ="phonenum" type="text"><br/>
   密码：<input name ="password" type="text"><br/>
  <input type="submit"  value="提交">
  </form>
  </body>
</html>
