package Bean;

/**
 * @ClassName: UserBean
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/11/13 11:10
 * @Version: 1.0
 */
public class User {
    private String userid;
    private String username;
    private String password;
    private int key;
    private String tp;
    private String bz;
    private int classid;
    private int collegeid;

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
