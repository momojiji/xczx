package entity.student;

/**
 * @Auther: wyan
 * @Date: 2019/2/21 16:44
 * @Description:
 */
public class StudentVo {

    private String id;
    private String studentname;
    private String collegecode;
    private String classinfoname;
    private String sex;
    private String collegename;
    private String majorname;
    private String presentage;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getCollegecode() {
        return collegecode;
    }

    public void setCollegecode(String collegecode) {
        this.collegecode = collegecode;
    }

    public String getClassinfoname() {
        return classinfoname;
    }

    public void setClassinfoname(String classinfoname) {
        this.classinfoname = classinfoname;
    }

    public String getSex() {
        return sex.equals("0")?"男":"女";
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getPresentage() {
        return presentage;
    }

    public void setPresentage(String presentage) {
        this.presentage = presentage;
    }

    public String getStatus() {
        return status.equals("0")?"在校":"请假";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
