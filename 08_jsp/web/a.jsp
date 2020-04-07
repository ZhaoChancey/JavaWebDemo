<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.sound.midi.Soundbank" %><%--
  Created by IntelliJ IDEA.
  User: Chancey
  Date: 2020/3/13
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--练习：
--%>
<%--1、声明类属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>

<%--2、声明static静态代码块--%>
    <%!
        static{
            map = new HashMap<>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>

<%--3、声明类方法--%>
    <%!
        public int abc(){
            return 12;
        }
    %>
<%--4、声明内部类--%>
    <%!
        public static class A{
            private Integer id = 11;
            private String abc = "abc";
        }
    %>


<%--练习：表达式脚本
1.输出整型
2.输出浮点型
3.输出字符串
4.输出对象    --%>
<%= 12 %> <br/>
<%= 12.545 %> <br/>
<%= "字符串啊"%> <br/>
<%= map %> <br/>
<%= request.getParameter("username")%>

<%--练习：代码脚本--%>
<%--1.代码脚本----if 语句--%>
<%
    int i = 2;
    if (i == 1){
%>
    <h1>11111111</h1>
<%
    }else {
%>
    <h1>2222222</h1>
<%    }
%><br/>

<%--2.代码脚本----for 循环语句--%>
    <table border="1" cellspacing="0">
        <%
            for (int j = 0;j < 10;j++){
        %>
            <tr>
                <td>
                    第<%=j %>行 <br/>
                </td>
            </tr>

        <%
            }
        %>
    </table>


<%--3.翻译后java文件中_jspService方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println(username);
%>
</body>
</html>
