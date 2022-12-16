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
            width: 1000px;
            height: 100px;
            background-color: #00B5F9;
            margin: -10px;
            padding: 2%;
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
    <h3 class="h3">信息管理</h3><hr>
    <div class="yuan">
    <a href=../XueYuanView.jsp target=main class="line">学院信息管理</a>
    <a href=../Class_XueYuanView.jsp target=main class="line">班级信息管理</a>
    <a href=../Teacher_XueYuanView.jsp target=main class="line">教师信息管理</a>
    <a href=../Student_XueYuanView.jsp target=main class="line">学生信息管理</a>
    <a href=../KeCheng_XueYuanView.jsp target=main class="line">课程信息管理</a>
    <a href=viewBook.jsp target=main class="line">新&nbsp;&nbsp;增&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;户</a>
    </div>
    <h3 class="h3">考勤管理</h3><hr>
    <div class="yuan">
    <a href=../login.jsp target=main class="line">考&nbsp;&nbsp;勤&nbsp;&nbsp;管&nbsp;&nbsp;理</a>
    </div>
</body>
</html>
