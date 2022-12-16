<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生查询</title>
    <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
    function deleteStudent(userid){
        if (confirm("你确定要删除该学生吗？"))
            window.location="./UserServlet?action=deleteUserByUserid&pd=deStudent&userid="+userid;
    }
</script>
<%request.setCharacterEncoding("utf-8");%>
<body>
<form action="StudentView.jsp" method="post">

    <input type="text" name="keyword" size="80" value="${requestScope.keyword}" class="scan">
    <input type="submit" value="搜索" class="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="./UserServlet?action=Tz_addStudent&classid=<%=request.getParameter("classid")%>" class="submit">添加学生</a>
</form>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<table border="0" cellpadding="0" cellspacing="0">
    <tr class="twoTr">
        <th>学号</th>
        <th>姓名</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td width=50% align="center">${student.userid}</td>
            <td width=20% align="center">${student.username}</td>
            <td width=15% align="center"><a href="./UserServlet?action=Tz_UpdateUsername&userid=${student.userid}&username=${student.username}">修改</a></td>
            <td width=15% align="center"><a href="javascript:void(0);" onclick="deleteStudent(${student.userid})">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
