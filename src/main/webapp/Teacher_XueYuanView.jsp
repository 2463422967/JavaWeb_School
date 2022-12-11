<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/3
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.Class1" %>
<%@ page import="Bean.XueYuan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>学院</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="XYDAO" class="Dao.XueYuanDAO" />
<jsp:useBean id="xy" class="Bean.XueYuan"/>
<jsp:setProperty property="*" name="xy"/>

<%
  ArrayList<XueYuan> xys= XYDAO.selectXueYuanList();
  request.setAttribute("xys",xys);
%>

<form action="StudentView.jsp" method="post">
  <input type="text" name="keyword" size="80" value="${requestScope.keyword}"placeholder="请输入学院" class="scan">
  <input type="submit" value="搜索" class="submit" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%--  <a href="addStudent.jsp">添加学生</a>--%>
</form>
<%--<script type="text/javascript">--%>
<%--  function deleteStudent(id){--%>
<%--    if (confirm("你确定要删除该学生吗？"))--%>
<%--      window.location="handle.jsp?action=delete&id="+id;--%>
<%--  }--%>
<%--</script>--%>
<table border="0" width=70% cellpadding="0" cellspacing="0">
  <tr>
    <th colspan="3" ><div class="firstTr">学院</div></th>
  </tr>
  <c:forEach items="${xys}" var="xy">
    <tr>
      <td width=100% align="center"><a href="./UserServlet?action=SelectTeacherByXueYuan&collegeid=${xy.collegeid}&tzname=student">${xy.collegename}</a></td>
<%--      <td width=15% align="center"><a href="./UserServlet?action=SelectTeacherByXueYuan&collegeid=${xy.collegeid}&tzname=teacher">修改</a></td>--%>
<%--      <td width=15% align="center"><a href="javascript:void(0);"onclick="deleteBook(${xy.collegeid})">删除</a></td>--%>
    </tr>
  </c:forEach>
</table>
</body>
</html>
