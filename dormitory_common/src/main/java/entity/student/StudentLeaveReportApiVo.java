package entity.student;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName StudentLeaveReportApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 11:25
 * @Version 1.0
 */
public class StudentLeaveReportApiVo {

    @ApiModelProperty("学生请假的数量")
    private String leavescount;
    private Integer status;//状态 0 在校  1 ：是请假

    public String getLeavescount() {
        return leavescount;
    }

    public void setLeavescount(String leavescount) {
        this.leavescount = leavescount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
