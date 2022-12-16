<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/12
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>未签到列表</title>
  <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<script type="text/javascript">
  function qd(userid,qdid){
      window.location="./KaoqingServlet?action=StudentQd&userid="+userid+"&qdid="+qdid;
  }
</script>
<%request.setCharacterEncoding("utf-8");%>
<body>
<form action="StudentView.jsp" method="post">
  <a href="./KaoqingServlet?action=Tz_addStudent&classid=<%=request.getParameter("classid")%>">添加学生</a>
</form>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<table border="0" cellpadding="0" cellspacing="0">
  <tr class="twoTr">
    <th>未签到名称</th>
<%--    <th colspan="1">操作</th>--%>
  </tr>
  <c:forEach items="${qds}" var="qd">
    <tr>
      <td width=15% align="center">${qd.qdname}</td>
<%--      <td width=15% align="center"><a href="javascript:void(0);" onclick="qd(<%=request.getParameter("userid")%>,${qd.qdid})">签到</a></td>--%>
    </tr>
  </c:forEach>
</table>
</body>
</html>
