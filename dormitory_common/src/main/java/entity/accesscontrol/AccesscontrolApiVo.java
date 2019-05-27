package entity.accesscontrol;

import com.huashu.pojo.Accesscontrol;
import entity.student.StudentApiVo;
import entity.student.StudentVo;

/**
 * @ClassName AccesscontrolVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/2 23:14
 * @Version 1.0
 */
public class AccesscontrolApiVo extends Accesscontrol {
    private StudentApiVo student;

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }
}
