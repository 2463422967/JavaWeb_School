<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/11
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加教师</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<form method="post" action="./UserServlet?action=addUser&classid=<%=request.getParameter("classid")%>&key=3">
  <table border="0" cellpadding="0" cellspacing="0">
    <tr class="twoTr">
      <th>学生账号</th>
      <th>姓名</th>
      <th>密码</th>
      <th colspan="2">操作</th>
    </tr>
    <tr>
      <td width=15% align="center"><input type="text" name="userid"  value="" class="scan"></td>
      <td width=15% align="center"><input type="text" name="username"  value="" class="scan"></td>
      <td width=15% align="center"><input type="text" name="password"  value="" class="scan"></td>
      <td width=20% align="center"><input type="submit" value="添加" size="20" class="submit"></td>
    </tr>
  </table>
</form>
</body>
</html>
