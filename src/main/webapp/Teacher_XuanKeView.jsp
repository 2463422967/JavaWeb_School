<%@ page import="Bean.Teacher" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/5
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>课程查询</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
  function deletecourse (id){
    if (confirm("你确定要删除该课程吗？"))
      window.location="./UserServlet?action=deleteTeacherXuanKeByCourseid&courseid="+id
      +"&userid=<%=session.getAttribute("userid")%>";
  }
</script>
<%request.setCharacterEncoding("utf-8");%>
<body>
<form action="StudentView.jsp" method="post">
  <input type="text" name="keyword" size="80" value="${requestScope.keyword}" class="scan">
  <input type="submit" value="搜索" class="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="./UserServlet?action=Tz_AddTeacher_Xuanke&userid=<%=session.getAttribute("userid")%>&collegeid=<%=request.getParameter("collegeid")%>">添加教授课程</a>
</form>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<table border="0" cellpadding="0" cellspacing="0">
  <tr class="twoTr">
    <th>课程号</th>
    <th>课程名</th>
    <th colspan="2">操作</th>
  </tr>
  <c:forEach items="${teachers}" var="teacher">
    <tr>
      <td width=15% align="center">${teacher.courseid}</td>
      <td width=40% align="center">${teacher.coursename}</td>
<%--      <td width=10% align="center"><a href="handle.jsp?action=selectbyid&id=${teacher.courseid}">修改</a></td>--%>
      <td width=10% align="center"><a href="javascript:void(0);"onclick="deletecourse(${teacher.courseid})">删除</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
