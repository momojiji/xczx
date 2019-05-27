package entity.student;

import com.huashu.pojo.Dormitory;
import entity.classinfo.ClassinfoApiVo;
import entity.room.RoomApiVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: wyan
 * @Date: 2019/3/21 22:27
 * @Description:
 */
public class CheckSleepStudentVo {

    @ApiModelProperty("主键ID")
    private String id;//
    @ApiModelProperty("学生名称")
    private String studentname;//学生名称
    @ApiModelProperty("头像")
    private String personphone;// 	人像识别
    @ApiModelProperty("班级名称")
    private String classname;//classid
    @ApiModelProperty("楼名称") //班级信息
    private String buildname;//宿舍楼信息
    @ApiModelProperty("楼层") //层信息
    private String floorname;//层信息
    @ApiModelProperty("宿舍号") //宿舍信息
    private String roomnum;//宿舍信息
    @ApiModelProperty("院系")
    private String collegename;//专业代码
    @ApiModelProperty("专业")
    private String majorname;//专业代码
    @ApiModelProperty("学生状态")
    private String status;//学生状态


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

    public String getPersonphone() {
        return personphone;
    }

    public void setPersonphone(String personphone) {
        this.personphone = personphone;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
