package entity.accesscontrol;

import com.huashu.pojo.Accesscontrol;
import entity.student.StudentVo;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName AccesscontrolVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/2 23:14
 * @Version 1.0
 */
public class AccesscontrolVo  {
    private String id;
    private String studentname;
    private String leavedate;
    private String rebackdate;
    private String status;
    private String isvalidate;
    private String visitorreason;
    private String outdoorid;
    private String incomeid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getLeavedate() {
        if(StringUtils.isNotEmpty(leavedate)&&leavedate.endsWith(".0")){
            return leavedate.substring(0,leavedate.length()-2);
        }
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }

    public String getRebackdate() {
        if(StringUtils.isNotEmpty(rebackdate)&&rebackdate.endsWith(".0")){
            return rebackdate.substring(0,rebackdate.length()-2);
        }
        return rebackdate;
    }

    public void setRebackdate(String rebackdate) {
        this.rebackdate = rebackdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(String isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getVisitorreason() {
        return visitorreason;
    }

    public void setVisitorreason(String visitorreason) {
        this.visitorreason = visitorreason;
    }

    public String getOutdoorid() {
        return outdoorid;
    }

    public void setOutdoorid(String outdoorid) {
        this.outdoorid = outdoorid;
    }

    public String getIncomeid() {
        return incomeid;
    }

    public void setIncomeid(String incomeid) {
        this.incomeid = incomeid;
    }
}
