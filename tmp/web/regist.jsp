<%--
  Created by IntelliJ IDEA.
  User: Chancey
  Date: 2020/3/20
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8080/tmp/registServlet" method="get">
    用户名：<input type="text" name="username"/> <br>
    验证码：<input type="text" style="width: 80px" name="code">
    <img style="width: 100px;height: 30px" src="http://localhost:8080/tmp/kaptcha.jpg">
    <input type="submit" value="注册"/>
  </form>
  </body>
</html>
