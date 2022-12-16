package Dao;

import Bean.Teacher;
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
public class UserDAO extends util.GetConn{
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList <User> users = new ArrayList<User>();
    private User user;
    public Boolean deleteUserByUserid(int userid){
        conn=super.getConn(conn);
        sql = "delete from user where userid=?";
        int re =0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userid);
            re = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return re > 0;
    }
    public Boolean UpdateUsernameByuserid(int userid,String username){
        conn=super.getConn(conn);
        sql = "update user set username=? where userid = ?";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setInt(2,userid);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public Boolean addUser(int collegeid, String username, String password, String userid,int key){
        conn=super.getConn(conn);
        sql = "insert into user(userid, username, password, `key`,collegeid) values (?,?,?,?,?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.setString(2,username);
            pstmt.setString(3,password);
            pstmt.setInt(4,key );
            pstmt.setInt(5, collegeid);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }
    public Boolean addUser(String userid, String username, String password, int classid,int key){
        conn=super.getConn(conn);
        sql = "insert into user(userid, username, password, `key`,classid) values (?,?,?,?,?)";
        int result=0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.setString(2,username);
            pstmt.setString(3,password);
            pstmt.setInt(4,key );
            pstmt.setInt(5, classid);
            result = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result > 0;
    }

    public User selectUsernameByuserid(String userid){
        conn=super.getConn(conn);
        sql="select * from user where userid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }
    public User selectCollegeidByUserid(String userid){
        conn = super.getConn(conn);
        sql="select * from user where userid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs).get(0);
    }
    public ArrayList<User> selectUserListByKeyandXueYuan(int key,int collegeid){
        conn=super.getConn(conn);
        sql="select * from user where `key` = ? and collegeid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,key);
            pstmt.setInt(2,collegeid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<User> selectUserListByClassid(int classid){
        conn=super.getConn(conn);
        sql="select * from user where classid = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,classid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<User> selectUserList(int key){
        conn=super.getConn(conn);
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
                    user.setClassid(rs.getInt("classid"));
                    user.setTp(rs.getString("tp"));
                    user.setBz(rs.getString("beizhu"));
                    user.setCollegeid(rs.getInt("collegeid"));
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
