package Dao;

import util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: CheckLogin
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/1 21:30
 * @Version: 1.0
 */
public class CheckLoginDAO {
    private Connection conn = null;
    public Boolean CheckLoin(String username,String password){
        try {
            if ((conn==null) || conn.isClosed()){
                DB db = new DB();
                conn = db.getConn();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String sql = "select password from user where userid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                return false;
            } else if (rs.getString("password").equals(password)) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
