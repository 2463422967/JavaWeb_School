<%--
  Created by IntelliJ IDEA.
  User: Hc
  Date: 2022/11/15
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>主页</title>
</head>
<body>
<table border="1" width="100%">
  <tr>
    <td rowspan="2" width="20%" height="900px">
      <iframe src = "frame list.html" width="100%" height="900px" frameborder="1"></iframe>
    </td>
    <td width="78%" height="100px">
      <iframe src="welcome.jsp" width="100%" height="100px" frameborder="0"></iframe>
    </td>
  </tr>
  <tr>
    <td width="78%" height="800px">
      <iframe src="login.jsp" name="right" width="100%" height="800px" frameborder="1"></iframe>
    </td>
  </tr>
</table>
</body>
</html>
