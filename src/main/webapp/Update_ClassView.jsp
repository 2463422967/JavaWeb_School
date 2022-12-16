<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/10
  Time: 0:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改班级</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<form method="post" action="./UserServlet?action=UpdateClassByclassid&classid=<%=request.getParameter("classid")%>">
  <table border="0" cellpadding="0" cellspacing="0">
    <tr class="twoTr">
      <th>班级名</th>
      <th colspan="2">操作</th>
    </tr>
    <tr>
      <td width=30% align="center"><input type="text" name="classname"  value="<%=request.getParameter("classname")%>" class="scan"></td>
      <td width=50% align="center"><input type="submit" value="修改" size="20" class="butt"></td>
    </tr>
  </table>
</form>
</body>
</html>
