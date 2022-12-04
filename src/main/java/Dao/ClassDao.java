package Dao;

import Bean.Class1;

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
public class ClassDao extends util.GetConn{
    private Connection conn = null;
    private String sql = "";
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<Class1> classes = new ArrayList<Class1>();
    private Class1 aClass;
//    private Connection getConn(){
//        try {
//            if ((conn==null) || conn.isClosed()){
//                DB db = new DB();
//                conn = db.getConn();
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return conn;
//    }
    public ArrayList<Class1> SelectClassByXueYuan(int collegeid){
        conn=super.getConn(conn);
        sql="select * from banji where collegeid=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,collegeid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<Class1> selectClassList(){
        conn=super.getConn(conn);
        sql="select * from banji";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }

    public ArrayList<Class1> selectClassNameByid(int classid){
        conn=super.getConn(conn);
        sql = "select * from banji where classid = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,classid);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getByRS(rs);
    }
    public ArrayList<Class1> getByRS(ResultSet rs) {
        try {
            if (rs == null || !rs.next()){
                return null;
            }
            classes.clear();
            do{
                aClass = new Class1();
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
