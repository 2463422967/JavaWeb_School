<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/4
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师查询</title>
    <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
    function deleteTeacher(userid){
        if (confirm("你确定要删除该教师吗？"))
            window.location="./UserServlet?action=deleteUserByUserid&pd=deTeacher&userid="+userid;
    }
</script>
<%request.setCharacterEncoding("utf-8");%>
<body>
<form action="StudentView.jsp" method="post">
    <input type="text" name="keyword" size="80" value="${requestScope.keyword}" class="scan">
    <input type="submit" value="搜索" class="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="./UserServlet?action=Tz_addTeacher&collegeid=<%=request.getParameter("collegeid")%>">添加教师</a>
</form>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<table border="0" cellpadding="0" cellspacing="0">
    <tr class="twoTr">
        <th>教师号</th>
        <th>姓名</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${teachers}" var="teach">
        <tr>
            <td width=50% align="center">${teach.userid}</td>
            <td width=20% align="center">${teach.username}</td>
            <td width=10% align="center"><a href="./UserServlet?action=SelectKeChengByTeacher&teacherid=${teach.userid}&collegeid=${teach.collegeid}">查看教授课程</a></td>
            <td width=10% align="center"><a href="./UserServlet?action=Tz_UpdateTeacher&userid=${teach.userid}&username=${teach.username}">修改</a></td>
            <td width=10% align="center"><a href="javascript:void(0);" onclick="deleteTeacher(${teach.userid})">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
