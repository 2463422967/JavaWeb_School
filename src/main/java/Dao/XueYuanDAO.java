package Dao;

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
