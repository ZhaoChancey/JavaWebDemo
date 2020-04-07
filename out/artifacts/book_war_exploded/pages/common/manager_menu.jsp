<%--
  Created by IntelliJ IDEA.
  User: Chancey
  Date: 2020/3/17
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<%--    通过点击图书管理进入servlet程序中，进行相应操作后，再转发到book_manager.jsp页面显示在浏览器上
        action=list表明要调用servlet中的list方法
    --%>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="pages/manager/order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
