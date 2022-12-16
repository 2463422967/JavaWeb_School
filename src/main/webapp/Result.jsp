<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/11/3
  Time: 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="refresh" content="2; <%=session.getAttribute("tzname")%>">
  <title>返回</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<%--<script type="text/javascript">--%>
<%--  function tz(){--%>
<%--      window.location=<%=session.getAttribute("tzname")%>;--%>
<%--  }--%>
<%--</script>--%>
<body >
<h1>${sessionScope.msg}  2秒后跳转</h1>
<a href=<%=session.getAttribute("tzname")%>><button class="butt">立即跳转</button></a>
<%--<button onclick="window.location.href=<%=session.getAttribute("tzname")%>">立即跳转</button>--%>
</body>
</html>
