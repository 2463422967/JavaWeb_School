package util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: GetConn
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/3 2:54
 * @Version: 1.0
 */
public class GetConn {
    public Connection getConn(Connection conn){
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
}
