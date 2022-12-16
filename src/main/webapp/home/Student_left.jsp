<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/14
  Time: 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color: #708090;
        }
        .h2{
            width: 1000px;
            height: 100px;
            background-color: #00B5F9;
            margin: -10px;
        }
        .h3{
            background-color: #00B5F9;
            text-align: center;
            Letter-spacing: 5px;
        }
    </style>
    <link href="../css/welcome.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="h2">
    <div class="xskz">学生考勤</div>
    <div class="glxt">管理系统</div>
</div>

<h3 class="h3">考勤</h3><hr>
<div class="yuan">
    <a href=../KaoqingServlet?action=ShowStudentQd&userid=<%=session.getAttribute("userid")%>&pd=qd target=main class="line">待签到</a>
    <a href=../KaoqingServlet?action=ShowStudentQd&userid=<%=session.getAttribute("userid")%>&pd=noqd target=main class="line">已经签到</a>
<%--    <a href=../KaoqingServlet?action=FbKaoqing_Class&userid=<%=session.getAttribute("userid")%> target=main class="line">发布签到</a>--%>
</div>
</body>
</html>
