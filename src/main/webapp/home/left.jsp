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
            background-color: #708090;
        }
        .h2{
            background-color: #00B5F9;
            margin: -8px;
            color: white;
            font-style: italic;
        }
        .h3{
            background-color: white;

        }
    </style>
    <link href="../css/welcome.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="h2">
        <h2>学生考勤<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理系统</h2><br>
    </div>
    <h3 class="h3">信息管理</h3><hr>
    <a href=../XueYuanView.jsp target=main class="line">学院信息管理</a><br><br>
    <a href=../Class_XueYuanView.jsp target=main class="line">班级信息管理</a><br><br>
    <a href=../Teacher_XueYuanView.jsp target=main class="line">教师信息管理</a><br><br>
    <a href=../Student_XueYuanView.jsp target=main class="line">学生信息管理</a><br><br>
    <a href=../KeCheng_XueYuanView.jsp target=main class="line">课程信息管理</a><br><br>
    <a href=viewBook.jsp target=main class="line">新&nbsp;&nbsp;增&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;户</a><br>
    <h3 class="h3">考勤管理</h3><hr>
    <a href=../login.jsp target=main class="line">考&nbsp;&nbsp;勤&nbsp;&nbsp;管&nbsp;&nbsp;理</a>
</body>
</html>
