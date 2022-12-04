package service;

import Bean.*;

import java.util.ArrayList;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/29 23:26
 * @Version: 1.0
 */
public interface UserService {
    User SelectUserByname(String name, int key);
    User SelectUserByid(String id, int key);
    ArrayList<User> selectUserListByClassid(int classid);
    ArrayList<User> selectUserListByKeyandXueYuan(int key,int collegeid);
    ArrayList<KeCheng> selectKeChengListByXueYuan(int collegeid);
    ArrayList<Class1> selectClassListByCollegeid(int collegeid);
    ArrayList<XuanKe> SelectKeChengByClassid(int classid);
    ArrayList<Teacher> SelectKeChengByTeacher(int userid);
    Boolean AddTeacherXuanKeByUseridandCoursename(String userid,String coursename);
}
