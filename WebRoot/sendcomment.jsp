<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>评论</title>
  </head>
  
  <body>
   <form action="/AymServer/sendComment.action" method="post"> 
   id：<input name ="id" type="text"><br/>
   手机号：<input name ="phonenum" type="text"><br/>
   内容：<input name ="msg" type="text"><br/>
   时间：<input name ="date" type="text"><br/>
  <input type="submit"  value="提交">
  </form>
  </body>
</html>
