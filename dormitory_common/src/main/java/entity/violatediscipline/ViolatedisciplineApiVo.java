package entity.violatediscipline;

import entity.TypeResult;
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
@ApiModel("违纪信息对照信息")
public class ViolatedisciplineApiVo {
    @Id
    private String id;//
    private String studentid;//
    private StudentApiVo student;
    private RoomApiVo room;//
    private String roomid;
    private String validatetype;//
    private String userid;//
    private java.util.Date noticedate;//
    private Integer status;//
    private Integer isvalidate;//
    private String validatedetail;//
    private String remarks;//

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }

    public RoomApiVo getRoom() {
        return room;
    }

    public void setRoom(RoomApiVo room) {
        this.room = room;
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

    public String getValidatetype() {

        if("1".equals(validatetype)){
            validatetype="违规电器";
        }else if("2".equals(validatetype)){
            validatetype="违规打牌";
        }else if("3".equals(validatetype)){
            validatetype="违规打架";
        }else if("4".equals(validatetype)){
            validatetype="违规不归宿";
        }else if("5".equals(validatetype)){
            validatetype="违规锁门";
        }else if("6".equals(validatetype)){
            validatetype="违规喝酒";
        }
        return validatetype;
    }

    public void setValidatetype(String validatetype) {
        this.validatetype = validatetype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getNoticedate() {
        return noticedate;
    }

    public void setNoticedate(Date noticedate) {
        this.noticedate = noticedate;
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

    public String getValidatedetail() {
        return validatedetail;
    }

    public void setValidatedetail(String validatedetail) {
        this.validatedetail = validatedetail;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
