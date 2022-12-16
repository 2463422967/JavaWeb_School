<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/12
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>班级课程</title>
    <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>

<form action="StudentView.jsp" method="post">
    <input type="text" name="keyword" size="80" value="${requestScope.keyword}" class="scan">
    <input type="submit" value="搜索" class="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%--  <a href="addStudent.jsp">添加学生</a>--%>
</form>

<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<%--<table border="0" cellpadding="0" cellspacing="0">--%>
<%--    <tr>--%>
<%--        <th colspan="3" ><div class="firstTr">课程</div></th>--%>
<%--    </tr>--%>
<%--    <c:forEach items="${glbs}" var="glb">--%>
<%--        <tr>--%>
<%--            <td width=100% align="center">--%>
<%--                <a href="./KaoqingServlet?action=Tz_kq&courseid=${xk.courseid}&userid=${xk.userid}&classid=${xk.classid}&tzname=<%=request.getParameter("tzname")%>">${xk.coursename}</a>--%>
<%--            </td>--%>
<%--                &lt;%&ndash;      <td width=15% align="center"><a href="handle.jsp?action=selectbyid&id=${cl.classid}">修改</a></td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;      <td width=15% align="center"><a href="javascript:void(0);" onclick="deleteBook(${cl.classid})">删除</a></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

<%--</table>--%>

<table border="0" cellpadding="0" cellspacing="0">
    <tr class="twoTr">
        <th>姓名</th>
        <th>是否签到</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${glbs}" var="glb">
        <tr>
            <td width=50% align="center">${glb.username}</td>
            <td width=20% align="center">${(glb.qdzt == 1) ? "已签到" : "未签到"}</td>
            <td width=15% align="center"><a href="handle.jsp?action=selectbyid&id=${glb.courseid}">修改状态</a></td>
            <td width=15% align="center"><a href="javascript:void(0);" onclick="deleteCourse(${glb.courseid})">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
</body>
</html>
