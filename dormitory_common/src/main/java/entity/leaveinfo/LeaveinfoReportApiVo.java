package entity.leaveinfo;

import io.swagger.annotations.ApiModel;

/**
 * @ClassName LeaveinfoReportApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 9:58
 * @Version 1.0
 */
@ApiModel("请假信息报表字段对应信息")
public class LeaveinfoReportApiVo {

    private String id;
    private String leavecount;
    private String studentCount;
    private String leavedate;

    public LeaveinfoReportApiVo() {
    }

    public LeaveinfoReportApiVo(String leavecount, String leavedate) {
        this.leavecount = leavecount;
        this.leavedate = leavedate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeavecount() {
        return leavecount;
    }

    public void setLeavecount(String leavecount) {
        this.leavecount = leavecount;
    }

    public String getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(String studentCount) {
        this.studentCount = studentCount;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }
}
