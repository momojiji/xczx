package entity.Signinfo;

import com.huashu.pojo.Student;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName SigninfoApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/22 12:04
 * @Version 1.0
 */
@ApiModel(value = "学生签到字段对应信息")
public class SigninfoReportApiVo {
    private String id;//

    @ApiModelProperty(value = "签到日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signdate;//

    private Integer status;//签到状态：0：正常、1：迟到、2：请假

    private String signcount;//签到数量

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSigncount() {
        return signcount;
    }

    public void setSigncount(String signcount) {
        this.signcount = signcount;
    }
}
