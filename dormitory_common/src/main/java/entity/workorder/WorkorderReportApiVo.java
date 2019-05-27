package entity.workorder;

import io.swagger.annotations.ApiModel;

/**
 * @ClassName WorkorderReportApiVo
 * @Description 报修工单的统计信息
 * @Author Administrator
 * @Date 2019/2/22 13:07
 * @Version 1.0
 */
@ApiModel("报修工单的对照表")
public class WorkorderReportApiVo {

    private  int  status;
    private  String  repaircount;//代数量
    private  String  fixcount;//已维修数量

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRepaircount() {
        return repaircount;
    }

    public void setRepaircount(String repaircount) {
        this.repaircount = repaircount;
    }

    public String getFixcount() {
        return fixcount;
    }

    public void setFixcount(String fixcount) {
        this.fixcount = fixcount;
    }
}
