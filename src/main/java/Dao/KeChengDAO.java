package Dao;

import Bean.Class1;
import Bean.KeCheng;
import Bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ClassName: ClassDao
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/30 6:55
 * @Version: 1.0
 */
public class KeChengDAO extends util.GetConn{
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<KeCheng> keChengs = new ArrayList<KeCheng>();
    private KeCheng keCheng;

    public Boolean deleteCourseByCourseid(int courseid){
        conn=super.getConn(conn);
        sql = "delete from kecheng where courseid=?";
        String sql1 = "delete from teacher where courseid=?";
        int re =0;
        try {
            pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt.setInt(1,courseid);
            pstmt1.setInt(1,courseid);
            re = pstmt1.executeUpdate();
            re = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return re > 0;
    }
    public Boolean addKeCheng(KeCheng kc){
        conn=super.getConn(conn);
        sql = "insert into kecheng(coursename, collegeid) values (?,?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,kc.getCoursename());
            pstmt.setInt(2, kc.getCollegeid());
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public KeCheng selectCourseidByCoursename(String coursename){
        conn = super.getConn(conn);
        sql="select courseid from kecheng where coursename=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,coursename);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }
    public KeCheng SelectCourseByCourseid(int courseid){
        conn=super.getConn(conn);
        sql="select * from kecheng where courseid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }
    public ArrayList<KeCheng> SelectClassByXueYuan(int collegeid){
        conn=super.getConn(conn);
        sql="select * from kecheng where collegeid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,collegeid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<KeCheng> getAllKeCheng(){
        conn=super.getConn(conn);
        sql="select * from kecheng";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }

    public ArrayList<KeCheng> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            keChengs.clear();
            do{
                keCheng = new KeCheng();
                try {
                    keCheng.setCourseid(rs.getInt("courseid"));
                    keCheng.setCoursename(rs.getString("coursename"));
                    keCheng.setCollegeid(rs.getInt("collegeid"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                keChengs.add(keCheng);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return keChengs;
    }
}
