package entity.major;

import com.huashu.pojo.Classinfo;
import com.huashu.pojo.Student;

import java.io.Serializable;
import java.util.List;

public class MajorApiVo  implements Serializable {

    private String id;
    private String majorname;//
    private String majornum;//
    private String majorcode;//
    private String collegeid;//
    private List<Classinfo> classinfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getMajornum() {
        return majornum;
    }

    public void setMajornum(String majornum) {
        this.majornum = majornum;
    }

    public String getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(String majorcode) {
        this.majorcode = majorcode;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }

    public List<Classinfo> getClassinfoList() {
        return classinfoList;
    }

    public void setClassinfoList(List<Classinfo> classinfoList) {
        this.classinfoList = classinfoList;
    }
}
