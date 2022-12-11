<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/9
  Time: 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学院</title>
    <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<form method="post" action="./UserServlet?action=AddXueYuan">
    <table border="0" width=70% cellpadding="0" cellspacing="0">
        <tr class="twoTr">
            <th>学院名</th>
            <th colspan="2">操作</th>
        </tr>
        <tr>
            <td width=70% align="center"><input type="text" name="collegename"  value="" class="scan"></td>
            <td width=20% align="center"><input type="submit" value="添加"  style="width: 100%" class="submit"></td>
        </tr>
    </table>

</form>
</body>
</html>
