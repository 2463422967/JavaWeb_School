package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @ClassName: DB
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/3 0:43
 * @Version: 1.0
 */
public class DB {
    private Properties p;
    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection conn;

    public Connection  getConn() {
        return conn;
    }

    public DB(){
        try {
            p = new Properties();
            InputStream is = this.getClass().getResourceAsStream("/config.ini");
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            Class.forName(driver);
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
