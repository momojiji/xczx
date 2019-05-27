package entity.violatediscipline;

import entity.room.RoomApiVo;
import entity.student.StudentApiVo;
import io.swagger.annotations.ApiModel;

import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName Violatediscipline
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/21 1:12
 * @Version 1.0
 */
@ApiModel("违纪信息统计对照信息")
public class ViolatedisciplineReportApiVo {
    @Id
    private String id;//
    private String validatecount="0";
    private String validatetype;
    private String reportnoticedate;
    private String validateDesp;

    public ViolatedisciplineReportApiVo() {

    }
    public ViolatedisciplineReportApiVo(String validatecount, String reportnoticedate) {
        this.validatecount = validatecount;
        this.validatetype = validatetype;
        this.reportnoticedate = reportnoticedate;
        this.validateDesp = validateDesp;
    }

    public String getReportnoticedate() {
        return reportnoticedate;
    }

    public void setReportnoticedate(String reportnoticedate) {
        this.reportnoticedate = reportnoticedate;
    }

    public String getValidateDesp() {
        return validateDesp;
    }

    public void setValidateDesp(String validateDesp) {
        this.validateDesp = validateDesp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidatecount() {
        return validatecount;
    }

    public void setValidatecount(String validatecount) {
        this.validatecount = validatecount;
    }

    public String getValidatetype() {
        return validatetype;
    }

    public void setValidatetype(String validatetype) {
        this.validatetype = validatetype;
    }
}
