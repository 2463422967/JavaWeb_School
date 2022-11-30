<%@ page import="Bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生查询</title>
</head>
<body>
    <%request.setCharacterEncoding("utf-8");%>
    <jsp:useBean id="UserDAO" class="Dao.UserDAO" />
    <jsp:useBean id="user" class="Bean.User"/>
    <jsp:setProperty property="*" name="user"/>
    <%
//        String keyword=request.getParameter("keyword");
//        request.setAttribute("keyword",keyword);
//        ArrayList<User> studetns = studentkDAO.getALL();
//        request.setAttribute("students",studetns);
        ArrayList<User> students= UserDAO.selectUserList(3);
        request.setAttribute("students",students);%>
    <form action="student.jsp" method="post">
    <input type="text" name="keyword" size="80" value="${requestScope.keyword}">
    <input type="submit" value="搜索">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="addStudent.jsp">添加学生</a>
    </form>
    <script type="text/javascript">
        function deleteStudent(id){
            if (confirm("你确定要删除该学生吗？"))
                window.location="handle.jsp?action=delete&id="+id;
        }
    </script>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>123</th>
        <th>123</th>
        <th>123</th>
        <th>123</th>
        <th>123</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.userid}</td><td><a href="handle.jsp?action=viewbyid&id=${student.userid}">${student.username}</a></td>
            <td>${student.username}</td><td>${student.username}</td>
            <td>${student.userid}</td><td><a href="handle.jsp?action=selectbyid&id=${student.userid}">修改</a></td>
            <td><a href="javascript:void(0);"onclick="deleteBook(${student.userid})">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
