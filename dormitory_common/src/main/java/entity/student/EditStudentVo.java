package entity.student;

import com.huashu.pojo.Classinfo;
import com.huashu.pojo.College;
import com.huashu.pojo.Major;
import com.huashu.pojo.Student;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/18 20:44
 * @Description:
 */
public class EditStudentVo {

    private Student student;

    private List<Major> majorList;

    private List<College> instituteList;

    private List<Classinfo> classList;

    private String collegeParentId;

    public String getCollegeParentId() {
        return collegeParentId;
    }

    public void setCollegeParentId(String collegeParentId) {
        this.collegeParentId = collegeParentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }

    public List<College> getInstituteList() {
        return instituteList;
    }

    public void setInstituteList(List<College> instituteList) {
        this.instituteList = instituteList;
    }

    public List<Classinfo> getClassList() {
        return classList;
    }

    public void setClassList(List<Classinfo> classList) {
        this.classList = classList;
    }
}
