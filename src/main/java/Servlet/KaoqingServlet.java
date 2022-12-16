package Servlet; /**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/12 1:35
 * @Version: 1.0
 */

import Bean.Class1;
import Bean.Glb;
import Bean.QianDao;
import Bean.XuanKe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "KaoqingServlet", value = "/KaoqingServlet/*")
public class KaoqingServlet extends BaseServlet {
    private final UserService service = new UserServiceImpl();

    String msg="";
    protected void FbKaoqing_Class(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        ArrayList<Class1> class1s = new ArrayList<Class1>();
        ArrayList<XuanKe> xuanKes = service.SelectKeChengByUserid(userid);
        for (XuanKe xk : xuanKes) {
            Class1 class1 = new Class1();
            class1.setClassid(xk.getClassid());
            class1.setClassname(service.selectClassByClassid(xk.getClassid()).getClassname());
            class1s.add(class1);
        }
        try {
            String tzname = request.getParameter("tzname");
            request.setAttribute("tzname",tzname);
        }catch (Exception e){

        }
        request.setAttribute("userid",userid);
        request.setAttribute("classes",class1s);
        try {
            request.getRequestDispatcher("/Teacher/ShowClassView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void ShowClassKecheng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        int classid = Integer.parseInt(request.getParameter("classid"));
        ArrayList<XuanKe> xuanKes = service.SelectKeChengByUseridadnClassid(userid,classid);
        try {
            String tzname = request.getParameter("tzname");
            request.setAttribute("tzname",tzname);
        }catch (Exception e){

        }
        try {
            request.setAttribute("userid",userid);
            request.setAttribute("classid",classid);
            request.setAttribute("xks",xuanKes);
            request.getRequestDispatcher("/Teacher/ShowXuankeView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void ShowStudentQd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        String pd = request.getParameter("pd");
        ArrayList<Glb> glbs = service.selectGlbListByUserid(userid);
        ArrayList<QianDao> qianDaos = new ArrayList<QianDao>();
        String tzname="";
        for (Glb glb:glbs) {
            QianDao qianDao = new QianDao();
            int qdid = glb.getQdid();
            qianDao = service.SelectQdByQdid(qdid);
            if ("qd".equals(pd)){
                if (qianDao.getQdflag() == 0) {
                    qianDaos.add(qianDao);
                }
                tzname="/Student/ShowStudentQdListView.jsp";
            } else if ("noqd".equals(pd)) {
                if (qianDao.getQdflag() == 1) {
                    qianDaos.add(qianDao);
                }
                tzname="/Student/ShowStudentNoQdListView.jsp";
            }
        }
        try {
            request.setAttribute("userid",userid);
            request.setAttribute("qds",qianDaos);
            request.getRequestDispatcher(tzname).forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void Tz_kq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        int classid = Integer.parseInt(request.getParameter("classid"));
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        String tz = "/Teacher/KaoqingListView.jsp";
        String tzname = request.getParameter("tzname");
        if ("kqgl".equals(tzname)) {
            tz = "/Teacher/ShowQdListView.jsp";
        }
        ArrayList<QianDao> qianDaos = service.SelectQdByUseridandCourseidandClassid(userid,courseid,classid);
        try {
            request.setAttribute("qds",qianDaos);
            request.setAttribute("userid",userid);
            request.setAttribute("classid",classid);
            request.setAttribute("courseid",courseid);
            request.getRequestDispatcher(tz).forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void Tz_QdStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userid = request.getParameter("userid");
        int classid = Integer.parseInt(request.getParameter("classid"));
        int qdid = Integer.parseInt(request.getParameter("qdid"));
        ArrayList<Glb> glbs = service.selectGlbListByClassidandQdid(classid,qdid);
        try {
            request.setAttribute("glbs",glbs);
            request.getRequestDispatcher("/Teacher/ShowStudentKaoqingView.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void AddKaoqing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String userid = request.getParameter("userid");
        String qdname = request.getParameter("qdname");
        int classid = Integer.parseInt(request.getParameter("classid"));
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        String stime = request.getParameter("qdstarttime");
        String ptime = request.getParameter("qdstoptime");
        Timestamp qdstarttime = null;
        Timestamp qdstoptime = null;
        try {
            Date sdate = format.parse(stime);
            Date pdate = format.parse(ptime);
            qdstarttime = new Timestamp(sdate.getTime());
            qdstoptime = new Timestamp(pdate.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean fh = service.addQianDao(userid,courseid,classid,1,qdstarttime,qdstoptime,qdname);
        if (fh) {
            msg = "发布签到成功";
        }else {
            msg = "发布签到失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname",request.getContextPath()+"/Teacher/ShowClassView.jsp");
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void StudentQd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userid = request.getParameter("userid");
        int qdid = Integer.parseInt(request.getParameter("qdid"));
        int qdflag = service.SelectQdByQdid(qdid).getQdflag();
        if (qdflag == 1) {
            boolean fh = service.UpdatGlb_qdztByUseridAndQdid(userid,qdid);
            if (fh) {
                msg = "发布签到成功";
            }else {
                msg = "发布签到失败";
            }
        }else {
            msg = "签到时间已过，签到失败";
        }
        try{
            session.setAttribute("msg",msg);
            session.setAttribute("tzname","./KaoqingServlet?action=ShowStudentQd&userid="+userid);
            request.getRequestDispatcher("Result.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


