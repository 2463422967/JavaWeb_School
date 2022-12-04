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
<body>
选择课程:
<select id="sel_term">
    <option value="-1">--请选择--</option>
    <c:forEach items="${kechengs}" var="kecheng">
        <option value="${kecheng.courseid}">${kecheng.coursename}</option>
    </c:forEach>
</select>
教师:
<select id="sel_teacher">
    <option value="-1">--请选择--</option>
</select>
<script type="text/javascript">
    $(function(){
        //绑定下拉列表改变的事件
        $("#sel_term").on("change",function(){
            var teacher_id=$(this).val();
            var $sel_teacher=$("#sel_teacher");
            //选择的value值,
            //使用jQuery的get函数发送ajax请求
            //url为请求的服务器路径，data是发送请求的参数，callback是请求成功后的回调函数,请求的数据类型
            //$.get(url,data,callback,dataType);
            $.get("/UserServlet?action=SelectTeacherByXueYuan",{teacherid:teacherid},function(data){
                $selcourse.find("option:gt(0)").remove();//清除
                var courses=data.split(",");
                for(var i=0;i<courses.length;i++){
                    var course=courses[i].split("_");
                    //获取课程id与name
                    var id=course[0];
                    var name=course[1];
                    //构建option对象
                    var $option=$("<option value="+id+">"+name+"</option>");
                    //把option追加到sel下拉对象中里
                    $selcourse.append($option);

                }
            });
        });
    });
</script>
</body>
</html>
