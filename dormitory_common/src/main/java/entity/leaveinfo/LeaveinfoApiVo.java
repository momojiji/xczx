package entity.leaveinfo;

import com.huashu.pojo.Student;
import entity.student.StudentApiVo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName LeaveinfoApiVo
 * @Description 请假信息的接口类
 * @Author Administrator
 * @Date 2019/1/21 10:05
 * @Version 1.0
 */
public class LeaveinfoApiVo{
    private String id;//
    private StudentApiVo student;
    private String studentid;
    private String leavetype;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date applydate;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date begindate;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date rebackdate;//
    private String duration;//
    private Integer status;//  申请状态：0:新增、 1： 申请、2：同意、3：拒绝 4、 其他
    private Integer isvalidate;//
    private String leavereason;//
    private String remarks;//
    private java.util.Date  createdate;
    private String creator;
    private String classid;
    private String userid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getRebackdate() {
        return rebackdate;
    }

    public void setRebackdate(Date rebackdate) {
        this.rebackdate = rebackdate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Integer isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(String leavereason) {
        this.leavereason = leavereason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
