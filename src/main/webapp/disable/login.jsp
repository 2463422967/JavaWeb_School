<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>登录</title>
</head>
<script type="text/javascript">
function reloadImage(t) {
    t.src="./ImageServlet?flag="+Math.random();
}
</script>
<body>
<div class="loginBox">
    <h2>登录</h2>
    <form action="" method="post" >
        <div class="item" >
            <input type="text" required name="username" id="user">
            <label for="user">用户名</label>
        </div>
        <div class="item">
            <input type="password" required name="password" id="pass">
            <label for="pass">密码</label>
        </div>
        <div class="item">
            <input type="text" required name="code" id="code">
            <label for="code">验证码</label>
            <img src="ImageServlet" align="right" onclick="reloadImage(this)">
        </div>

        <button class="btn">登录
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </button>
    </form>
</div>

</body>
</html>


