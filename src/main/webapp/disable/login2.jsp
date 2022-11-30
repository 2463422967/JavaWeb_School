<%--
  Created by IntelliJ IDEA.
  User: Hc
  Date: 2022/11/14
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="login2.css">
</head>

<body>
<div id="login_box">
  <h2>LOGIN</h2>
  <div id="input_box">
    <input type="text" placeholder="用户名">
  </div>
  <div class="input_box">
    <input type="password" placeholder="密码" >
  </div>
  <table >
    <tr>
      <td id="tr1">
        <input type="text" placeholder="验证码" >
      </td>
      <td>
        <img src="ImageServlet" align="" onclick="reloadImage(this)">
      </td>
    </tr>
<%--    <div class="input_box">--%>
<%--      <input type="text" placeholder="验证码" >--%>
<%--      <img src="ImageServlet" align="" onclick="reloadImage(this)">--%>
<%--    </div>--%>
  </table>
  <button>登录</button><br>
</div>
</body>
</html>


