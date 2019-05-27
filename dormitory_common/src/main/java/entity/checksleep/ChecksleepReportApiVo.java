package entity.checksleep;

import com.huashu.pojo.Classinfo;
import com.huashu.pojo.Dormitory;
import entity.room.RoomApiVo;
import entity.student.StudentApiVo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName ChecksleepApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/11 23:30
 * @Version 1.0
 */
public class ChecksleepReportApiVo {

    @Id
    private String id;//
    private String beddate;//查寝日期
    private String  status;//就寝状态 就寝状态： 就寝：0 , 为就寝：1  请假：2
    private String  bedcount;//人数
    private String  classcount;//班级人数
    private String  leavecount;//请假人数

    public ChecksleepReportApiVo(){

    }

    public ChecksleepReportApiVo(String bedcount, String beddate) {
        this.beddate = beddate;
        this.bedcount = bedcount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeddate() {
        return beddate;
    }

    public void setBeddate(String beddate) {
        this.beddate = beddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBedcount() {
        return bedcount;
    }

    public void setBedcount(String bedcount) {
        this.bedcount = bedcount;
    }

    public String getClasscount() {
        return classcount;
    }

    public void setClasscount(String classcount) {
        this.classcount = classcount;
    }

    public String getLeavecount() {
        return leavecount;
    }

    public void setLeavecount(String leavecount) {
        this.leavecount = leavecount;
    }
}
