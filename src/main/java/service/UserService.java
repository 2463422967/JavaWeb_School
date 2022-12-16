package service;

import Bean.*;

import java.sql.Timestamp;
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
    ArrayList<KeCheng> getAllKeCheng();
    ArrayList<Class1> selectClassListByCollegeid(int collegeid);
    Class1 selectClassByClassid(int classid);
    ArrayList<XuanKe> SelectKeChengByClassid(int classid);
    ArrayList<XuanKe> SelectKeChengByUserid(String userid);
    ArrayList<XuanKe> SelectKeChengByUseridadnClassid(String userid,int classid);
    ArrayList<Teacher> SelectKeChengByTeacher(int userid);
    ArrayList<QianDao> SelectQdByUseridandCourseidandClassid(String userid,int courseid,int classid);
    QianDao SelectQdByQdid(int qdid);

    int selectKeyByuserid(String userid);
    String selectUsernameByuserid(String userid);
    ArrayList<Teacher> SelectTeacherBycourseid(int courseid);
    ArrayList<Glb> selectGlbListByClassidandQdid(int classid,int qdid);
    ArrayList<Glb> selectGlbListByUserid(String userid);
    Boolean AddTeacherXuanKeByUseridandCoursename(String userid,String coursename);
    Boolean AddClassBycollegeid(String classname,int collegeid);
    Boolean AddXueYuan(String collegename);
    Boolean addUser(int collegeid,String username,String password,String userid,int key);
    Boolean addQianDao(String userid, int courseid, int classid, int qdflag, Timestamp qdstarttime, Timestamp qdstoptime,String qdname);
    Boolean addUser(String userid,String username,String password,int classid,int key);
    Boolean AddClassXuanKe(String userid,int courseid,int classid);
    Boolean addKeCheng(int collegeid,String coursename);
    Boolean deleteCourseByCourseid(int courseid);
    Boolean deleteTeacherXuanKeByCourseid(int courseid, String userid);
    Boolean deleteCollegeByCollegeid(int collegeid);
    Boolean deleteClassByClassid(int classid);
    Boolean deleteUserByUserid(int userid);
    Boolean UpdateXueYuanBycollegeid(int collegeid,String collegename);
    Boolean UpdateTaecherByuserid(String userid,String username);
    Boolean UpdateUsernameByuserid(int userid,String username);
    Boolean UpdateClassByclassid(int classid,String classname);
    Boolean UpdatGlb_qdztByUseridAndQdid(String userid,int qdid);
}
