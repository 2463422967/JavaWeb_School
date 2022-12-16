package Bean;

import java.sql.Timestamp;

/**
 * @ClassName: QianDao
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/12 6:04
 * @Version: 1.0
 */
public class QianDao {
    private String userid;
    private int courseid;
    private int classid;
    private Timestamp qdstarttime;
    private Timestamp qdstoptime;
    private int qdflag;
    private String qdname;
    private int qdid;

    public int getQdid() {
        return qdid;
    }

    public void setQdid(int qdid) {
        this.qdid = qdid;
    }

    public String getQdname() {
        return qdname;
    }

    public void setQdname(String qdname) {
        this.qdname = qdname;
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

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public Timestamp getQdstarttime() {
        return qdstarttime;
    }

    public void setQdstarttime(Timestamp qdstarttime) {
        this.qdstarttime = qdstarttime;
    }

    public Timestamp getQdstoptime() {
        return qdstoptime;
    }

    public void setQdstoptime(Timestamp qdstoptime) {
        this.qdstoptime = qdstoptime;
    }

    public int getQdflag() {
        return qdflag;
    }

    public void setQdflag(int qdflag) {
        this.qdflag = qdflag;
    }
}
