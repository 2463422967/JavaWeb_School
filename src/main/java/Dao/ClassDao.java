package Dao;

import Bean.Class;
import Bean.User;
import util.DB;

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
public class ClassDao {
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<Class> classes = new ArrayList<Class>();
    private Class aClass;
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
    public ArrayList<Class> selectClassList(){
        getConn();
        sql="select * from banji";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<Class> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            classes.clear();
            do{
                aClass = new Class();
                try {
                    aClass.setClassid(rs.getInt("classid"));
                    aClass.setClassname(rs.getString("classname"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                classes.add(aClass);
            }while (rs.next());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return classes;
    }
}
