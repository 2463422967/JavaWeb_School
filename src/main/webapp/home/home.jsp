<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/11/9
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎访问考勤管理系统</title>
</head>
<body>
<table width="100%" cellpadding="0" cellspacing="0">
    <tr>
        <td rowspan="2" width="15%" height="900px">
            <iframe src = "<%=session.getAttribute("leftname")%>" width="100%" height="900px" frameborder="0"></iframe>
        </td>
        <td width="78%" height="100px">
            <iframe src="top.jsp" width="100%" height="100px" frameborder="0"></iframe>
        </td>
    </tr>
    <tr>
        <td width="78%" height="800px">
            <iframe src="welcome.jsp" name="main" width="100%" height="800px" frameborder="0"></iframe>
        </td>
    </tr>
</table>
</body>
</html>
