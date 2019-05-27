package entity.allocaterecord;

import com.huashu.pojo.AllocationRecord;
import entity.room.RoomApiVo;
import entity.student.StudentApiVo;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName AllocaterecordApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 15:18
 * @Version 1.0
 */
@ApiModel(value = "学生申请宿舍的对照表")
public class AllocateRecordApiVo  {

    @Id
    private String id;//
    private String studentid;//
    private String classinfoid;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date applydate;//
    private String dormitoryid;//
    private String olddormitoryid;//
    private String targetdormitoryid;//
    private Integer status;//
    private Integer isvalidate;//
    private String reason;//
    private String remarks;//
    private String creator;//
    private String modifitor;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date modifiedate;//
    private String bednum;
    private StudentApiVo student;//学生信息
    private RoomApiVo oldRoom;//就宿舍信息
    private RoomApiVo targetRoom;//目标宿舍信息

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createdate;

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getClassinfoid() {
        return classinfoid;
    }

    public void setClassinfoid(String classinfoid) {
        this.classinfoid = classinfoid;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getOlddormitoryid() {
        return olddormitoryid;
    }

    public void setOlddormitoryid(String olddormitoryid) {
        this.olddormitoryid = olddormitoryid;
    }

    public String getTargetdormitoryid() {
        return targetdormitoryid;
    }

    public void setTargetdormitoryid(String targetdormitoryid) {
        this.targetdormitoryid = targetdormitoryid;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifitor() {
        return modifitor;
    }

    public void setModifitor(String modifitor) {
        this.modifitor = modifitor;
    }

    public Date getModifiedate() {
        return modifiedate;
    }

    public void setModifiedate(Date modifiedate) {
        this.modifiedate = modifiedate;
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }

    public RoomApiVo getOldRoom() {
        return oldRoom;
    }

    public void setOldRoom(RoomApiVo oldRoom) {
        this.oldRoom = oldRoom;
    }

    public RoomApiVo getTargetRoom() {
        return targetRoom;
    }

    public void setTargetRoom(RoomApiVo targetRoom) {
        this.targetRoom = targetRoom;
    }
}
