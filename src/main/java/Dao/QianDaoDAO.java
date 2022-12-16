package Dao;




import Bean.QianDao;
import util.GetConn;

import java.sql.*;
import java.util.ArrayList;

/**
 * @ClassName: QianDaoDAO
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/12 6:06
 * @Version: 1.0
 */
public class QianDaoDAO extends GetConn {
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<QianDao> qianDaos = new ArrayList<QianDao>();
    private QianDao qianDao;


    public Boolean addQianDao(String userid, int courseid, int classid, int qdflag, Timestamp qdstarttime,Timestamp qdstoptime,String qdname){
        conn=super.getConn(conn);
        sql = "insert into qd(userid, courseid, classid, qdflag, qdstarttime,qdstoptime,qdname) values (?,?,?,?,?,?,?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.setInt(2, courseid);
            pstmt.setInt(3, classid);
            pstmt.setInt(4, qdflag);
            pstmt.setTimestamp(5, qdstarttime);
            pstmt.setTimestamp(6, qdstoptime);
            pstmt.setString(7,qdname);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public ArrayList<QianDao> SelectQdByUseridandCourseidandClassid(String userid,int courseid,int classid){
        conn=super.getConn(conn);
        sql="select * from qd where userid=? and courseid=? and classid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.setInt(2,courseid);
            pstmt.setInt(3,classid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public QianDao SelectQdByUseridandCourseidandClassidandQdname(String userid,int courseid,int classid,String qdname){
        conn=super.getConn(conn);
        sql="select * from qd where userid=? and courseid=? and classid=? and qdname=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.setInt(2,courseid);
            pstmt.setInt(3,classid);
            pstmt.setString(4,qdname);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }
    public QianDao SelectQdByQdid(int qdid){
        conn=super.getConn(conn);
        sql="select * from qd where qdid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,qdid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }

    public ArrayList<QianDao> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            qianDaos.clear();
            do{
                qianDao = new QianDao();
                try {
                    qianDao.setClassid(rs.getInt("classid"));
                    qianDao.setCourseid(rs.getInt("courseid"));
                    qianDao.setQdflag(rs.getInt("qdflag"));
                    qianDao.setQdid(rs.getInt("qdid"));
                    qianDao.setQdname(rs.getString("qdname"));
                    qianDao.setUserid(rs.getString("userid"));
                    qianDao.setQdstarttime(rs.getTimestamp("qdstarttime"));
                    qianDao.setQdstoptime(rs.getTimestamp("qdstoptime"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                qianDaos.add(qianDao);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return qianDaos;
    }
}
