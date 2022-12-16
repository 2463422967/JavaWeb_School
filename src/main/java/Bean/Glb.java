package Bean;

import java.sql.Timestamp;

/**
 * @ClassName: Glb
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/12 22:58
 * @Version: 1.0
 */
public class Glb {
    private int classid;
    private String userid;
    private int courseid;
    private Timestamp time;
    private int que;
    private int qj;
    private int cd;
    private int qdid;
    private int zt;
    private int qdzt;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getQue() {
        return que;
    }

    public void setQue(int que) {
        this.que = que;
    }

    public int getQj() {
        return qj;
    }

    public void setQj(int qj) {
        this.qj = qj;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getQdid() {
        return qdid;
    }

    public void setQdid(int qdid) {
        this.qdid = qdid;
    }

    public int getZt() {
        return zt;
    }

    public void setZt(int zt) {
        this.zt = zt;
    }

    public int getQdzt() {
        return qdzt;
    }

    public void setQdzt(int qdzt) {
        this.qdzt = qdzt;
    }
}
