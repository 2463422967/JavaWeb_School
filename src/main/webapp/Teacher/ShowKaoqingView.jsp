<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/12
  Time: 1:29
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
</form>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <th colspan="3" ><div class="firstTr">课程</div></th>
    </tr>
    <c:forEach items="${xks}" var="xk">
        <tr>
            <td width=100% align="center">
                <a href="./KaoqingServlet?action=Tz_kq&courseid=${xk.courseid}&userid=${xk.userid}&classid=${xk.classid}">${xk.coursename}</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
