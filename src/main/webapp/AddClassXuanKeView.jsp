<%--
  Created by IntelliJ IDEA.
  User: Hard_cheng
  Date: 2022/12/4
  Time: 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="./js/jquery-3.6.1.min.js"></script>
</head>
<script type="text/javascript">
    $(function(){
        //绑定下拉列表改变的事件
        $("#sel_term").bind("change",function(){
            const course_id = $(this).val();
            const $sel_teacher = $("#sel_teacher");
            //选择的value值,
            //使用jQuery的get函数发送ajax请求
            //url为请求的服务器路径，data是发送请求的参数，callback是请求成功后的回调函数,请求的数据类型
            //$.get(url,data,callback,dataType);
            $.get("./UserServlet?action=SelectTeacherBycourseid",{courseid:course_id},function(data){
                $sel_teacher.find("option:gt(0)").remove();//清除
                const courses = data.split("|");
                for(let i=0; i<courses.length-1; i++){
                    const course = courses[i].split(",");
                    //获取课程id与name
                    const id = course[0];
                    const name = course[1];
                    //构建option对象
                    const $option = $("<option value=" + id + ">" + name + "</option>");
                    //把option追加到sel下拉对象中里
                    $sel_teacher.append($option);
                }
            });
        });
    });
</script>
<body>
<form method="post" action="./UserServlet?action=AddClassXuanKe&classid=<%=request.getParameter("classid")%>">
    <label for="sel_term">选择课程:</label>
        <select id="sel_term" name="courseid">
        <option value="-1">--请选择--</option>
        <c:forEach items="${kechengs}" var="kecheng">
            <option value="${kecheng.courseid}">${kecheng.coursename}</option>
        </c:forEach>
    </select>
    <label for="sel_teacher">教师:</label>
    <select id="sel_teacher" name="userid">
        <option value="-1">--请选择--</option>
    </select>
    <input type="submit" value="添加"  class="submit">
</form>
</body>
</html>
