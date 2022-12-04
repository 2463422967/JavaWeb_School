<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/3
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Bean.Class1" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.Class1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>班级</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>

<form action="StudentView.jsp" method="post">
  <input type="text" name="keyword" size="80" value="${requestScope.keyword}" class="scan">
  <input type="submit" value="搜索" class="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="addStudent.jsp">添加学生</a>
</form>
<script type="text/javascript">
  function deleteStudent(id){
    if (confirm("你确定要删除该学生吗？"))
      window.location="handle.jsp?action=delete&id="+id;
  }
</script>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<table border="0" cellpadding="0" cellspacing="0">
  <tr>
    <th colspan="3" class="firstTr">班级</th>
  </tr>
  <c:forEach items="${cls}" var="cl">
    <tr>
      <td width=70% align="center"><a href="./UserServlet?action=SelectStudentByClassid&classid=${cl.classid}">${cl.classname}</a></td>
      <td width=15% align="center"><a href="handle.jsp?action=selectbyid&id=${cl.classid}">修改</a></td>
      <td width=15% align="center"><a href="javascript:void(0);" onclick="deleteBook(${cl.classid})">删除</a></td>
    </tr>
  </c:forEach>

</table>
</body>
</html>

