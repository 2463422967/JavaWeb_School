<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/12
  Time: 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加教师</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
  var currentTime = new Date();
  document.getElementById("qdstarttime").value = currentTime.toTimeString();
</script>
<body>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<form method="post" action="./KaoqingServlet?action=AddKaoqing&courseid=<%=request.getParameter("courseid")%>&userid=<%=request.getParameter("userid")%>&classid=<%=request.getParameter("classid")%>">
  <table border="0" cellpadding="0" cellspacing="0">
    <tr class="twoTr">
      <th>签到名称</th>
      <th>开始时间</th>
      <th>结束时间</th>
      <th colspan="2">操作</th>
    </tr>
    <tr>
      <td width=15% align="center"><input type="text" name="qdname"  value="" class="scan"></td>
      <td width=15% align="center"><input type="datetime-local" id="qdstarttime" name="qdstarttime"  value="" class="scan"></td>
      <td width=15% align="center"><input type="datetime-local" id="qdstoptime" name="qdstoptime"  value="" class="scan"></td>
      <td width=20% align="center"><input type="submit" value="发布" size="20" class="submit"></td>
    </tr>
  </table>
</form>
</body>
</html>
