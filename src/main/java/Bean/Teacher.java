package Bean;

/**
 * @ClassName: Teacher
 * @Description: TODO
 * @Author: Hard_cheng
 * @Date: 2022/12/5 0:42
 * @Version: 1.0
 */
public class Teacher {
    private String userid;
    private String username;
    private String coursename;
    private int courseid;
    private int collegeid;

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

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(int collegeid) {
        this.collegeid = collegeid;
    }
}
