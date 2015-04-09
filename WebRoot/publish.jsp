<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>发布</title>
  </head>

  <body>
   <form action="/AymServer/publish.action" method="post"> 
   手机号：<input name ="phonenum" type="text"><br/>
   图片链接：<input name ="image_uri" type="text"><br/>
    话题：<input name ="topic" type="text"><br/>
       内容：<input name ="msg" type="text"><br/>
       地址：<input name ="location" type="text"><br/>
         评论数：<input name ="comment_num" type="text"><br/>
           点赞数：<input name ="like_num" type="text"><br/>

  <input type="submit"  value="登录">
  </form>
  </body>
</html>
