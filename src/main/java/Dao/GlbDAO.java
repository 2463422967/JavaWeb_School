package Dao;

import Bean.Glb;
import Bean.QianDao;
import util.GetConn;


import java.sql.*;
import java.util.ArrayList;

/**
 * @ClassName: GlbDAO
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/12 23:01
 * @Version: 1.0
 */
public class GlbDAO extends GetConn {
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<Glb> glbs = new ArrayList<Glb>();
    private Glb glb;

    public Boolean UpdatGlb_qdztByUseridAndQdid(String userid,int qdid){
        conn=super.getConn(conn);
        sql = "update glb set qdzt=? where userid = ? and qdid=?";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            pstmt.setString(2,userid);
            pstmt.setInt(3,qdid);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public Boolean addStudent(int classid,String userid,int courseid,int qdid, int qdzt,String username){
        conn=super.getConn(conn);
        sql = "insert into glb(classid, userid, courseid,qdid,qdzt,username) values (?,?,?,?,?,?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,classid);
            pstmt.setString(2, userid);
            pstmt.setInt(3, courseid);
            pstmt.setInt(4, qdid);
            pstmt.setInt(5, qdzt);
            pstmt.setString(6, username);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public ArrayList<Glb> selectGlbListByUseridandClassidandQdid(int classid, int qdid){
        conn = super.getConn(conn);
        sql="select * from glb where classid=? and qdid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,classid);
            pstmt.setInt(2,qdid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<Glb> selectGlbListByUserid(String userid){
        conn = super.getConn(conn);
        sql="select * from glb where userid=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }

    public ArrayList<Glb> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            glbs.clear();
            do{
                glb = new Glb();
                try {
                    glb.setClassid(rs.getInt("classid"));
                    glb.setCourseid(rs.getInt("courseid"));
                    glb.setUserid(rs.getString("userid"));
                    glb.setCd(rs.getInt("cd"));
                    glb.setQdid(rs.getInt("qdid"));
                    glb.setQdzt(rs.getInt("qdzt"));
                    glb.setTime(rs.getTimestamp("time"));
                    glb.setZt(rs.getInt("zt"));
                    glb.setQue(rs.getInt("que"));
                    glb.setQj(rs.getInt("qj"));
                    glb.setUsername(rs.getString("username"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                glbs.add(glb);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return glbs;
    }
}
