package Servlet;

import Bean.*;
import service.UserService;
import service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import Dao.CheckLoginDAO;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

@WebServlet(name = "UserServlet", value = "/UserServlet/*")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();
    String msg="";
    protected void Checklogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CheckLoginDAO ch=new CheckLoginDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String yzcode = (String) session.getAttribute("piccode");
        if (code.equals(yzcode)) {
            if (ch.CheckLoin(username,password)) {
                request.setAttribute("username",username);
                request.getRequestDispatcher("home.jsp").forward(request,response);
            }else {
                response.sendRedirect("login.jsp");
            }
        }else {
            response.sendRedirect("login.jsp");
        }
    }


    protected void getImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        int wight = 78;
        int height = 20;
        //创建对象
        BufferedImage bim = new BufferedImage(68,20,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bim.getGraphics();
        Random rm = new Random();
        g.setColor(new Color(rm.nextInt(100),205,rm.nextInt(100)));
        g.fillRect(0,0,wight,height);
        StringBuffer sbf = new StringBuffer("");
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.black);
            g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,22));
            int n = rm.nextInt(10);
            sbf.append(n);
            g.drawString(""+n,i*15+5,18);
        }
        //将生成的验证码存到session
        HttpSession session = request.getSession(true);
        session.setAttribute("piccode",sbf.toString());
        //禁止缓存
        response.setHeader("Prama","no-cache");
        response.setHeader("Coche=Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        //将bim图片返回浏览器
        ImageIO.write(bim,"JPG",response.getOutputStream());
        response.getOutputStream().close();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @Description: 根据classid获取学生列表
     */
    protected void SelectStudentByClassid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int classid = Integer.parseInt(request.getParameter("classid"));
        ArrayList<User> userArrayList = service.selectUserListByClassid(classid);
        try{
            request.setAttribute("students",userArrayList);
            request.setAttribute("classid",classid);
            request.getRequestDispatcher("StudentView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @Description: 根据学院获取班级列表
     */
    protected void SelectClassByXueYuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String tzname = request.getParameter("tzname");
        ArrayList<Class1> classArrayList = service.selectClassListByCollegeid(collegeid);
        try{
            request.setAttribute("cls",classArrayList);
            if (tzname.equals("class1")) {
                request.setAttribute("collegeid",collegeid);
                request.getRequestDispatcher("ClassView.jsp").forward(request,response);
            } else if (tzname.equals("student")) {
                request.getRequestDispatcher("Student_ClassView.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void SelectTeacherByXueYuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String tzname = request.getParameter("tzname");
        ArrayList<User> userArrayList = service.selectUserListByKeyandXueYuan(2,collegeid);
        try{
            request.setAttribute("collegeid",collegeid);
            request.setAttribute("teachers",userArrayList);
            request.getRequestDispatcher("TeacherView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void SelectTeacherBycourseid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        ArrayList<Teacher> teachers=service.SelectTeacherBycourseid(courseid);
        //组合方式:课程id_课程名称,课程id_课程名称,...
        StringBuffer sbd=new StringBuffer();
//        sbd.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
//        sbd.append("<users>");
//        System.out.println(teachers);
        if(teachers!=null&&teachers.size()>0){
            for(Teacher teacher:teachers){
                sbd.append(teacher.getUserid()).append(",").append(teacher.getUsername()).append("|");
            }
        }
        //去掉最后一个逗号
        System.out.println(sbd);
        //响应在页面
        out.write(sbd.toString());
        out.flush();
        out.close();
    }
    protected void SelectKeChengByXueYuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String tzname = request.getParameter("tzname");
        ArrayList<KeCheng> keChengArrayList = service.selectKeChengListByXueYuan(collegeid);
        try{
            request.setAttribute("collegeid",collegeid);
            request.setAttribute("kechengs",keChengArrayList);
            request.getRequestDispatcher("KeChengView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void SelectKeChengByClassid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int classid = Integer.parseInt(request.getParameter("classid"));
        ArrayList<XuanKe> xuanKes = service.SelectKeChengByClassid(classid);
        try{
            request.setAttribute("classid",classid);
            request.setAttribute("xuankes",xuanKes);
            request.getRequestDispatcher("Class_KeChengView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void AddXuanke(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int classid = Integer.parseInt(request.getParameter("classid"));
        ArrayList<KeCheng> keCheng = service.getAllKeCheng();
        try{
            request.setAttribute("classid",classid);
            request.setAttribute("kechengs",keCheng);
            request.getRequestDispatcher("AddClassXuanKeView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void AddClassXuanKe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int classid = Integer.parseInt(request.getParameter("classid"));
        String userid = request.getParameter("userid");
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        boolean fh = service.AddClassXuanKe(userid,courseid,classid);
        if (fh) {
            msg = "添加班级选课成功";
        }else {
            msg = "添加班级选课失败";
        }
        try{

            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Class_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void SelectKeChengByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int userid = Integer.parseInt(request.getParameter("teacherid"));
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        ArrayList<Teacher> teachers = service.SelectKeChengByTeacher(userid);
        try{
            request.setAttribute("collegeid",collegeid);
            session.setAttribute("userid",userid);
            request.setAttribute("teachers",teachers);
            request.getRequestDispatcher("Teacher_XuanKeView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //携带userid collegeid参数跳转到AddTeacher_Xuanke.jsp(教师添加课程界面)
    protected void Tz_AddTeacher_Xuanke(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        ArrayList<KeCheng> keCheng = service.selectKeChengListByXueYuan(collegeid);
        try{
            request.setAttribute("kechengs",keCheng);
            request.setAttribute("collegeid",collegeid);
            request.setAttribute("userid",userid);
            request.getRequestDispatcher("AddTeacher_Xuanke.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        try{
            request.setAttribute("collegeid",collegeid);
            request.getRequestDispatcher("AddTeacherView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int classid = Integer.parseInt(request.getParameter("classid"));
        try{
            request.setAttribute("classid",classid);
            request.getRequestDispatcher("AddStudentView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_addClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        try{
            request.setAttribute("collegeid",collegeid);
            request.getRequestDispatcher("AddClassView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_UpdateXueYuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String collegename = request.getParameter("collegename");
        try{
            request.setAttribute("collegeid",collegeid);
            request.setAttribute("collegename",collegename);
            request.getRequestDispatcher("Update_XueYuanView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_UpdateTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        try{
            request.setAttribute("userid",userid);
            request.setAttribute("username",username);
            request.getRequestDispatcher("Update_TeacherView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_UpdateUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        try{
            request.setAttribute("userid",userid);
            request.setAttribute("username",username);
            request.getRequestDispatcher("Update_StudentView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_UpdateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int classid = Integer.parseInt(request.getParameter("classid"));
        String classname = request.getParameter("classname");
        try{
            request.setAttribute("classid",classid);
            request.setAttribute("classname",classname);
            request.getRequestDispatcher("Update_ClassView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void Tz_addKeCheng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        try{
            request.setAttribute("collegeid",collegeid);
            request.getRequestDispatcher("AddKeChengView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void AddXueYuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String collegename = request.getParameter("collegename");

        boolean fh = service.AddXueYuan(collegename);
        if (fh) {
            msg = "添加学院成功";
        }else {
            msg = "添加学院失败";
        }
        try{

            session.setAttribute("msg",msg);
            session.setAttribute("tzname","XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void AddClassBycollegeid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String classname = request.getParameter("classname");
        boolean fh = service.AddClassBycollegeid(classname,collegeid);
        if (fh) {
            msg = "添加班级成功";
        }else {
            msg = "添加班级失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Class_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void AddTeacherXuanKeByUserid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userid = request.getParameter("userid");
        String coursename = request.getParameter("coursename");
//        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        boolean fh = service.AddTeacherXuanKeByUseridandCoursename(userid,coursename);
        if (fh) {
            msg = "添加教授课程成功";
        }else {
            msg = "添加教授课程失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Teacher_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void addKeCheng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String coursename = request.getParameter("coursename");
        boolean fh = service.addKeCheng(collegeid,coursename);
        if (fh) {
            msg = "添加课程成功";
        }else {
            msg = "添加课程失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","KeCheng_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        boolean fh =false;
        String msg1 = "";
//        String tzname = "";
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int key = Integer.parseInt(request.getParameter("key"));
        if (key == 2) {
            //添加教师
            int collegeid = Integer.parseInt(request.getParameter("collegeid"));
            fh = service.addUser(collegeid,username,password,userid,key);
            msg1 = "教师";
            session.setAttribute("tzname","Teacher_XueYuanView.jsp");
        } else if (key == 3) {
            //添加学生
            int classid = Integer.parseInt(request.getParameter("classid"));
            fh = service.addUser(userid,username,password,classid,key);
            msg1 = "学生";
            session.setAttribute("tzname","Student_XueYuanView.jsp");
        }
        if (fh) {
            msg = "添加"+msg1+"成功";
        }else {
            msg = "添加"+msg1+"失败";
        }
        try{
            session.setAttribute("msg",msg);
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void deleteCourseByCourseid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        boolean fh = service.deleteCourseByCourseid(courseid);
        if (fh) {
            msg = "删除课程成功";
        }else {
            msg = "删除课程失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","KeCheng_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void deleteCollegeByCollegeid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        boolean fh = service.deleteCollegeByCollegeid(collegeid);
        if (fh) {
            msg = "删除学院成功";
        }else {
            msg = "删除学院失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void deleteClassByClassid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int classid = Integer.parseInt(request.getParameter("classid"));
        boolean fh = service.deleteClassByClassid(classid);
        if (fh) {
            msg = "删除班级成功";
        }else {
            msg = "删除班级失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Class_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void deleteUserByUserid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int userid = Integer.parseInt(request.getParameter("userid"));
        String pd = request.getParameter("pd");
        boolean fh = service.deleteUserByUserid(userid);
        if (fh) {
            if (pd.equals("deTeacher")) {
                msg = "删除教师成功";
            } else if (pd.equals("deStudent")) {
                msg = "删除学生成功";
            } else {
                msg = "删除用户成功";
            }
        }else {
            if (pd.equals("deTeacher")) {
                msg = "删除教师失败";
            }else if (pd.equals("deStudent")) {
                msg = "删除学生成功";
            }else {
                msg = "删除用户失败";
            }
        }
        try{
            session.setAttribute("msg",msg);
            if (pd.equals("deTeacher")) {
                session.setAttribute("tzname","Teacher_XueYuanView.jsp");
            } else if (pd.equals("deStudent")) {
                session.setAttribute("tzname","Student_XueYuanView.jsp");
            } else {
                session.setAttribute("tzname","XueYuanView.jsp");
            }
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void deleteTeacherXuanKeByCourseid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        String userid = request.getParameter("userid");
        boolean fh = service.deleteTeacherXuanKeByCourseid(courseid,userid);
        if (fh) {
            msg = "删除课程成功";
        }else {
            msg = "删除课程失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Teacher_XuanYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void UpdateXueYuanBycollegeid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String collegename = request.getParameter("collegename");
        boolean fh = service.UpdateXueYuanBycollegeid(collegeid,collegename);
        if (fh) {
            msg = "修改学院成功";
        }else {
            msg = "修改学院失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void UpdateTaecherByuserid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        boolean fh = service.UpdateTaecherByuserid(userid,username);
        if (fh) {
            msg = "修改教师信息成功";
        }else {
            msg = "修改教师信息失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Teacher_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void UpdateStudentByuserid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        boolean fh = service.UpdateTaecherByuserid(userid,username);
        if (fh) {
            msg = "修改学生信息成功";
        }else {
            msg = "修改学生信息失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Student_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void UpdateClassByclassid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int classid = Integer.parseInt(request.getParameter("classid"));
        String classname = request.getParameter("classname");
        boolean fh = service.UpdateClassByclassid(classid,classname);
        if (fh) {
            msg = "修改班级成功";
        }else {
            msg = "修改班级失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","Class_XueYuanView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
