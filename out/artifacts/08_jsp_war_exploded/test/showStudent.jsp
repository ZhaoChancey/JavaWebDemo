<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.bjtu.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Chancey
  Date: 2020/3/14
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
        }
    </style>
</head>
<body>
<%--练习二：jsp输出一个表格，里面有10个学生信息。--%>
    <%
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("stuList");
    %>

    <table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
    <%
        for (Student s1 : students){
    %>
    <tr>
        <td> <%=s1.getId()%></td>
        <td> <%=s1.getName()%></td>
        <td> <%=s1.getAge()%></td>
        <td> <%=s1.getPhone()%></td>
        <td>删除、修改</td>
    </tr>

    <%
        }
    %>
    </table>
</body>
</html>
