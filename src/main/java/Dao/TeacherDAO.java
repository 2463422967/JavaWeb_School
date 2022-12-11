package Dao;

import Bean.Teacher;
import Bean.XuanKe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ClassName: XueYuanDAO
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/3 2:51
 * @Version: 1.0
 */
public class TeacherDAO extends util.GetConn{
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private Teacher teacher;

    public ArrayList<Teacher> SelectTeacherBycourseid(int courseid){
        conn = super.getConn(conn);
        sql="select * from teacher where courseid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<Teacher> SelectKeChengByTeacher(int userid){
        conn = super.getConn(conn);
        sql="select * from teacher where userid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public Boolean deleteTeacherXuanKeByCourseid(int courseid,String userid){
        conn=super.getConn(conn);
        sql = "delete from teacher where courseid=? and userid=?";
        int re =0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseid);
            pstmt.setString(2,userid);
            re = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return re > 0;
    }
    public Boolean AddTeacherXuanKe(Teacher th){
        conn = super.getConn(conn);
        int result=0;
        sql="insert into teacher(userid, username, coursename, courseid, collegeid) VALUE (?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,th.getUserid());
            pstmt.setString(2,th.getUsername());
            pstmt.setString(3,th.getCoursename());
            pstmt.setInt(4,th.getCourseid());
            pstmt.setInt(5,th.getCollegeid());
            result = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public Boolean UpdateTaecherByuserid(String userid,String username){
        conn=super.getConn(conn);
        sql = "update user set username=? where userid = ?";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,userid);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    //废弃
    public Teacher selectCollegeidByUserid(int userid){
        conn = super.getConn(conn);
        sql="select * from teacher where userid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }
    public ArrayList<Teacher> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            teachers.clear();
            do{
                teacher = new Teacher();
                try {
                    teacher.setUserid(rs.getString("userid"));
                    teacher.setUsername(rs.getString("username"));
                    teacher.setCourseid(rs.getInt("courseid"));
                    teacher.setCoursename(rs.getString("coursename"));
                    teacher.setCollegeid(rs.getInt("collegeid"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                teachers.add(teacher);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }
}
