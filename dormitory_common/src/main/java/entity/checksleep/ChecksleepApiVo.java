package entity.checksleep;

import com.huashu.pojo.Classinfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Room;
import entity.room.RoomApiVo;
import entity.student.StudentApiVo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @ClassName ChecksleepApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/11 23:30
 * @Version 1.0
 */
public class ChecksleepApiVo {

    @Id
    private String id;//

    private String studentname;//
    private String studentnum;//
    private StudentApiVo student;
    private Classinfo classinfoid;//

    private Dormitory dormitorypid;//

    private Dormitory dormitoryid;//

    private RoomApiVo room;

    private String bennumber;
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date beddate;//
    private Integer isvalidate;//
    private String remarks;//
    private String creator;//
    private java.util.Date createdate;//
    private String modifitor;//
    private java.util.Date modifiedate;//

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

    public String getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(String studentnum) {
        this.studentnum = studentnum;
    }

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }

    public Classinfo getClassinfoid() {
        return classinfoid;
    }

    public void setClassinfoid(Classinfo classinfoid) {
        this.classinfoid = classinfoid;
    }

    public Dormitory getDormitorypid() {
        return dormitorypid;
    }

    public void setDormitorypid(Dormitory dormitorypid) {
        this.dormitorypid = dormitorypid;
    }

    public Dormitory getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(Dormitory dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public RoomApiVo getRoom() {
        return room;
    }

    public void setRoom(RoomApiVo room) {
        this.room = room;
    }

    public String getBennumber() {
        return bennumber;
    }

    public void setBennumber(String bennumber) {
        this.bennumber = bennumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeddate() {
        return beddate;
    }

    public void setBeddate(Date beddate) {
        this.beddate = beddate;
    }

    public Integer getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Integer isvalidate) {
        this.isvalidate = isvalidate;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
}
