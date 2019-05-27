package entity.allocationstudent;

import com.huashu.pojo.Allocation;
import com.huashu.pojo.Student;
import entity.allocation.AllocationApiVo;
import io.swagger.annotations.ApiModel;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName AllocationStudentApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/27 10:35
 * @Version 1.0
 */
@ApiModel(value = "学生入住宿舍信息对照表")
public class AllocationStudentApiVo {
    private String id;
    private String roomid;
    private String buildid;
    private String floorid;
    private String roomnum;
    private String bednum;
    private String bedtype;
    private String floorname;
    private String buildname;
    private String status;
    private String allocationdate;

    private Student student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getBuildid() {
        return buildid;
    }

    public void setBuildid(String buildid) {
        this.buildid = buildid;
    }

    public String getFloorid() {
        return floorid;
    }

    public void setFloorid(String floorid) {
        this.floorid = floorid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAllocationdate() {
        return allocationdate;
    }

    public void setAllocationdate(String allocationdate) {
        this.allocationdate = allocationdate;
    }
}