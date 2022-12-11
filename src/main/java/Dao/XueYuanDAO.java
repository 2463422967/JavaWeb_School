package Dao;

import Bean.KeCheng;
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
public class XueYuanDAO extends util.GetConn{
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<XueYuan> xueYuans = new ArrayList<XueYuan>();
    private XueYuan xueYuan;
    public Boolean UpdateXueYuanBycollegeid(int collegeid,String collegename){
        conn=super.getConn(conn);
        sql = "update xueyuan set collegename=? where collegeid = ?";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,collegename);
            pstmt.setInt(2,collegeid);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public Boolean deleteCollegeByCollegeid(int collegeid){
        conn=super.getConn(conn);
        sql = "delete from xueyuan where collegeid=?";
        int re =0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,collegeid);
            re = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return re > 0;
    }
    public Boolean addXueYuan(String collegename){
        conn=super.getConn(conn);
        sql = "insert into xueyuan(collegename) values (?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,collegename);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public ArrayList<XueYuan> selectXueYuanList(){
        conn = super.getConn(conn);
        sql="select * from xueyuan";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<XueYuan> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            xueYuans.clear();
            do{
                xueYuan = new XueYuan();
                try {
                    xueYuan.setCollegeid(rs.getInt("collegeid"));
                    xueYuan.setCollegename(rs.getString("collegename"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                xueYuans.add(xueYuan);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return xueYuans;
    }
}
