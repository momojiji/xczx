package entity.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName StudentReportApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/20 17:52
 * @Version 1.0
 */
@ApiModel("请假统计的对照类")
public class StudentReportApiVo {

    @ApiModelProperty("主键ID")
    private String id; //主键ID
    @ApiModelProperty("班级ID")
    private String classid;//班级ID
    @ApiModelProperty("班级数量")
    private String classcount;//班级数量
    @ApiModelProperty("学生数量")
    private String  studentcount;//学生数量

    private List<StudentLeaveReportApiVo> leavestudentList;//学生请假的数量

    public String getClasscount() {
        return classcount;
    }

    public void setClasscount(String classcount) {
        this.classcount = classcount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getStudentcount() {
        return studentcount;
    }

    public void setStudentcount(String studentcount) {
        this.studentcount = studentcount;
    }

    public List<StudentLeaveReportApiVo> getLeavestudentList() {
        return leavestudentList;
    }

    public void setLeavestudentList(List<StudentLeaveReportApiVo> leavestudentList) {
        this.leavestudentList = leavestudentList;
    }
}
