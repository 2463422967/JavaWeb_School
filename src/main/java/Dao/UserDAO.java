package Dao;

import Bean.User;
import util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @ClassName: SchoolDAO
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/12 20:28
 * @Version: 1.0
 */
public class UserDAO {
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList <User> users = new ArrayList<User>();
    private User user;

    private Connection getConn(){
        try {
            if ((conn==null) || conn.isClosed()){
                DB db = new DB();
                conn = db.getConn();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public ArrayList<User> selectUserList(int key){
        getConn();
        sql="select * from user where `key` = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,key);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<User> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            users.clear();
            do{
                user = new User();
                try {
                    user.setUserid(rs.getString("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setKey(rs.getInt("key"));
                    user.setTp(rs.getString("tp"));
                    user.setBz(rs.getString("bz"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                users.add(user);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}
