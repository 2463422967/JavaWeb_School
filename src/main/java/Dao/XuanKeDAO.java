package Dao;

import Bean.XuanKe;
import Bean.XueYuan;

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
public class XuanKeDAO extends util.GetConn{
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<XuanKe> xuanKes = new ArrayList<XuanKe>();
    private XuanKe xuanKe;
    public Boolean AddClassXuanKe(XuanKe xk){
        conn=super.getConn(conn);
        sql = "insert into xuanke(userid, username, classid, coursename, courseid, collegeid) values (?,?,?,?,?,?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,xk.getUserid());
            pstmt.setString(2, xk.getUsername());
            pstmt.setInt(3, xk.getClassid());
            pstmt.setString(4, xk.getCoursename());
            pstmt.setInt(5, xk.getCourseid());
            pstmt.setInt(6, xk.getCollegeid());
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public ArrayList<XuanKe> SelectKeChengByClassid(int classid){
        conn = super.getConn(conn);
        sql="select * from xuanke where classid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,classid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<XuanKe> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            xuanKes.clear();
            do{
                xuanKe = new XuanKe();
                try {
                    xuanKe.setUserid(rs.getString("userid"));
                    xuanKe.setUsername(rs.getString("username"));
                    xuanKe.setClassid(rs.getInt("classid"));
                    xuanKe.setCourseid(rs.getInt("courseid"));
                    xuanKe.setCoursename(rs.getString("coursename"));
                    xuanKe.setCollegeid(rs.getInt("collegeid"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                xuanKes.add(xuanKe);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return xuanKes;
    }
}
