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
    public Boolean AddTeacherXuanKeByUseridandCoursename(String userid,String coursename) {
        Teacher th = new Teacher();
        int collegeid = teacherDAO.selectCollegeidByUserid(Integer.parseInt(userid)).getCollegeid();
        KeCheng kc = new KeCheng();
        kc.setCoursename(coursename);
        kc.setCollegeid(collegeid);
        boolean fh = keChengDAO.addKeCheng(kc);
        if (fh) {
            int courseid = keChengDAO.selectCourseidByCoursename(coursename).getCourseid();
            String username = userDAO.selectUsernameByuserid(Integer.parseInt(userid)).getUsername();
            th.setUserid(userid);
            th.setUsername(username);
            th.setCoursename(coursename);
            th.setCourseid(courseid);
            th.setCollegeid(collegeid);
            return teacherDAO.AddTeacherXuanKe(th);
        }else {
            return false;
        }

    }


}
