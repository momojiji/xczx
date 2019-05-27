package entity.checksleep;

/**
 * @Auther: wyan
 * @Date: 2019/4/24 11:27
 * @Description:
 */
public class TeacherAndCountVo {

    private String studentCount;
    private String teacherId;

    public String getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(String studentCount) {
        this.studentCount = studentCount;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "[ studentCount "+this.studentCount+",teacherId "+this.teacherId+" ]";
    }
}
