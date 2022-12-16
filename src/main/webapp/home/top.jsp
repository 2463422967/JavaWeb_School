<%--
  Created by IntelliJ IDEA.
  User: Hc
  Date: 2022/11/15
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #444C63;
        }
        td{
            width: 100%;
            height: 70px;
            text-align: center;
            font-size: 30px;
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>
<table align="center">
    <tr><td><%=session.getAttribute("username")%>欢迎使用系统</td></tr>
</table>
</body>
</html>
