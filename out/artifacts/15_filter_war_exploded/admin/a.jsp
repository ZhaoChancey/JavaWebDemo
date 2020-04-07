<%--
  Created by IntelliJ IDEA.
  User: Chancey
  Date: 2020/3/21
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("a.jsp页面执行了");
        Object user = request.getSession().getAttribute("user");
        // 如果为null，说明还没有登录
        if (user == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    %>
    我是a.jsp文件
</body>
</html>
