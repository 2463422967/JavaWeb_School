package service.impl;
//import service.UserService;

import Bean.*;
import Dao.*;
import service.UserService;

import java.util.ArrayList;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/30 3:41
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    private final ClassDao classDao = new ClassDao();
    private final UserDAO userDAO = new UserDAO();
    private final KeChengDAO keChengDAO = new KeChengDAO();
    private final XuanKeDAO xuanKeDAO = new XuanKeDAO();
    private final XueYuanDAO xueYuanDAO = new XueYuanDAO();
    private final TeacherDAO teacherDAO = new TeacherDAO();
    @Override
    public User SelectUserByname(String name, int key) {
        return null;
    }

    @Override
    public User SelectUserByid(String id, int key) {
        return null;
    }

    @Override
    public ArrayList<User> selectUserListByClassid(int classid) {
        return userDAO.selectUserListByClassid(classid);
    }

    @Override
    public ArrayList<User> selectUserListByKeyandXueYuan(int key,int collegeid) {
        return userDAO.selectUserListByKeyandXueYuan(key,collegeid);
    }

    @Override
    public ArrayList<KeCheng> selectKeChengListByXueYuan(int collegeid) {
        return keChengDAO.SelectClassByXueYuan(collegeid);
    }

    @Override
    public ArrayList<KeCheng> getAllKeCheng() {
        return keChengDAO.getAllKeCheng();
    }

    @Override
    public ArrayList<Class1> selectClassListByCollegeid(int collegeid) {
        return classDao.SelectClassByXueYuan(collegeid);
    }

    @Override
    public ArrayList<XuanKe> SelectKeChengByClassid(int classid) {
        return xuanKeDAO.SelectKeChengByClassid(classid);
    }

    @Override
    public ArrayList<Teacher> SelectKeChengByTeacher(int userid) {
        return teacherDAO.SelectKeChengByTeacher(userid);
    }

    @Override
    public ArrayList<Teacher> SelectTeacherBycourseid(int courseid) {
        return teacherDAO.SelectTeacherBycourseid(courseid);
    }

    @Override
    public Boolean AddTeacherXuanKeByUseridandCoursename(String userid,String coursename) {
        Teacher th = new Teacher();
        int collegeid = userDAO.selectCollegeidByUserid(Integer.parseInt(userid)).getCollegeid();
//        KeCheng kc = new KeCheng();
//        kc.setCoursename(coursename);
//        kc.setCollegeid(collegeid);
//        boolean fh = keChengDAO.addKeCheng(kc);
        int courseid = keChengDAO.selectCourseidByCoursename(coursename).getCourseid();
        String username = userDAO.selectUsernameByuserid(Integer.parseInt(userid)).getUsername();
        th.setUserid(userid);
        th.setUsername(username);
        th.setCoursename(coursename);
        th.setCourseid(courseid);
        th.setCollegeid(collegeid);
        return teacherDAO.AddTeacherXuanKe(th);
    }

    @Override
    public Boolean AddClassBycollegeid(String classname, int collegeid) {
        return classDao.AddClassBycollegeid(classname,collegeid);
    }

    @Override
    public Boolean AddXueYuan(String collegename) {
        return xueYuanDAO.addXueYuan(collegename);
    }

    @Override
    public Boolean addUser(int collegeid, String username, String password, String userid,int key) {
        return userDAO.addUser(collegeid,username,password,userid,key);
    }

    @Override
    public Boolean addUser(String userid, String username, String password, int classid,int key) {
        return userDAO.addUser(userid,username,password,classid,key);
    }


    @Override
    public Boolean AddClassXuanKe(String userid, int courseid,int classid) {
        XuanKe xk = new XuanKe();
        String username = userDAO.selectUsernameByuserid(Integer.parseInt(userid)).getUsername();
        String coursename = keChengDAO.SelectCourseByCourseid(courseid).getCoursename();
        int collegeid = keChengDAO.SelectCourseByCourseid(courseid).getCollegeid();
        xk.setCollegeid(collegeid);
        xk.setCoursename(coursename);
        xk.setClassid(classid);
        xk.setCourseid(courseid);
        xk.setUserid(userid);
        xk.setUsername(username);
        return xuanKeDAO.AddClassXuanKe(xk);
    }

    @Override
    public Boolean deleteCourseByCourseid(int courseid) {
        return keChengDAO.deleteCourseByCourseid(courseid);
    }

    @Override
    public Boolean deleteTeacherXuanKeByCourseid(int courseid, String userid) {
        return teacherDAO.deleteTeacherXuanKeByCourseid(courseid,userid);
    }

    @Override
    public Boolean deleteCollegeByCollegeid(int collegeid) {
        return xueYuanDAO.deleteCollegeByCollegeid(collegeid);
    }

    @Override
    public Boolean deleteClassByClassid(int classid) {
        return classDao.deleteClassByClassid(classid);
    }

    @Override
    public Boolean deleteUserByUserid(int userid) {
        return userDAO.deleteUserByUserid(userid);
    }

    @Override
    public Boolean UpdateXueYuanBycollegeid(int collegeid,String collegename) {
        return xueYuanDAO.UpdateXueYuanBycollegeid(collegeid,collegename);
    }

    @Override
    public Boolean UpdateTaecherByuserid(String userid, String username) {
        return teacherDAO.UpdateTaecherByuserid(userid,username);
    }

    @Override
    public Boolean UpdateUsernameByuserid(int userid, String username) {
        return userDAO.UpdateUsernameByuserid(userid,username);
    }

    @Override
    public Boolean UpdateClassByclassid(int classid, String classname) {
        return classDao.UpdateClassByclassid(classid,classname);
    }

    @Override
    public Boolean addKeCheng(int collegeid,String coursename) {
        KeCheng kc = new KeCheng();
        kc.setCollegeid(collegeid);
        kc.setCoursename(coursename);
        return keChengDAO.addKeCheng(kc);
    }


}
