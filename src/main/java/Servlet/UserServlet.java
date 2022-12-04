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
            request.setAttribute("teachers",userArrayList);
            request.getRequestDispatcher("TeacherView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void SelectKeChengByXueYuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int collegeid = Integer.parseInt(request.getParameter("collegeid"));
        String tzname = request.getParameter("tzname");
        ArrayList<KeCheng> keChengArrayList = service.selectKeChengListByXueYuan(collegeid);
        try{
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
            request.setAttribute("xuankes",xuanKes);
            request.getRequestDispatcher("Class_KeChengView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void AddXuanke(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        int classid = Integer.parseInt(request.getParameter("classid"));
        try{
//            request.setAttribute("classid",classid);
            request.getRequestDispatcher("AddXuanKeView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void SelectKeChengByTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int teacherid = Integer.parseInt(request.getParameter("teacherid"));
        ArrayList<Teacher> teachers = service.SelectKeChengByTeacher(teacherid);
        try{
            request.setAttribute("teachers",teachers);
            request.getRequestDispatcher("Teacher_XuanKeView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //携带userid参数跳转到AddTeacher_Xuanke.jsp(教师添加课程界面)
    protected void Tz_AddTeacher_Xuanke(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        try{
            request.setAttribute("userid",userid);
            request.getRequestDispatcher("AddTeacher_Xuanke.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void AddTeacherXuanKeByUserid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        String coursename = request.getParameter("coursename");
        boolean fh = service.AddTeacherXuanKeByUseridandCoursename(userid,coursename);
        if (fh) {
            msg = "添加课程成功";
        }else {
            msg = "添加课程失败";
        }
        try{
            request.setAttribute("msg",msg);
            request.setAttribute("userid",userid);
            Tz_AddTeacher_Xuanke(request,response);
//            request.getRequestDispatcher("AddTeacher_Xuanke.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void deleteCourseByCourseid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

}
