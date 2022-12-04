<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hc
  Date: 2022/11/14
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css?v=<%=System.currentTimeMillis()%>">
</head>
<script type="text/javascript">
    function reloadImage(t) {
        t.src="./UserServlet?action=getImage&flag="+Math.random();
    }
</script>
<body>
<form method="post" action="./UserServlet?action=Checklogin">
<div class="container">
    <div class="login-wrapper">
        <div class="header">Login</div>
        <div class="form-wrapper">
            <input type="text" name="username" placeholder="用户名" class="input-item">
            <input type="password" name="password" placeholder="密码" class="input-item">
            <table>
                <tr>
                    <td width=130%>
                        <input type="text" name="code" placeholder="验证码" class="input-item">
                    </td>
                    <td>
                        <img src="./UserServlet?action=getImage" align="right" onclick="reloadImage(this)">
                    </td>
                </tr>
            </table>
            <input type="submit" value="Login" class="btn">
<%--            <div class="btn">Login</div>--%>
        </div>
        <div class="msg">
            Don't have account?
            <a href="#">Sign up</a>
        </div>
    </div>
</div>
</form>
</body>
</html>



