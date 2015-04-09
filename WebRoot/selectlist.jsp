<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>select</title>
  </head>
  
  <body>
   <form action="/AymServer/select.action" method="post"> 
    type：<input name ="type" type="text"><br/>
    Loc：<input name ="location" type="text"><br/>
   from: <input name ="from" type="text"><br/>
   to:<input name ="to" type="text"><br/>
  <input type="submit"  value="确定">
  </form>
  </body>
</html>
