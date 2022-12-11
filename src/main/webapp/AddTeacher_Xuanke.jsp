<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/5
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教授课程</title>
    <link href="css/school inf.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.6.1.min.js"></script>
</head>
<script type="text/javascript">
    function add(){
        var courseid = $("#xlk").val();
        var coursename = $("#xlk").find("option:selected").text();
        window.location="./UserServlet?action=AddTeacherXuanKeByUserid&userid=<%=request.getParameter("userid")%>&courseid="
            +courseid+"&coursename="+coursename;
    }
</script>
<body>
<input type="button" value="返回上一级" onclick="history.go(-1);" class="butt">
<form method="post" action="./UserServlet?action=AddTeacherXuanKeByUserid&userid=<%=request.getParameter("userid")%>">
<table border="0" cellpadding="0" cellspacing="0">
  <tr class="twoTr">
    <th>课程名</th>
    <th colspan="2">操作</th>
  </tr>
    <tr>
        <td>
            <label>
              <select name="xzkc" id="xlk">
                  <option value="">请选择课程</option>
                    <c:forEach items="${kechengs}" var="kc">
                        <option value=${kc.courseid}>${kc.coursename}</option>
                    </c:forEach>
              </select>
            </label>
        </td>
<%--      <td width=20% align="center"><input type="submit" value="添加" size="20" class="submit"></td>--%>
        <td width=20% align="center"><a href="javascript:void(0);" onclick="add()" style="size: 20px"><input type="" value="添加" size="20" class="submit"></a></td>
    </tr>
</table>
</form>
</body>
</html>
