package entity.worksleep;

import util.DateUtil;

import java.util.Date;

/**
 * @Auther: wyan
 * @Date: 2019/3/11 23:13
 * @Description:
 */
public class WorkSleepListVo {

    private String id;//
    private String studentname;//
    private String studentnum;//
    private String classinfoname;//
    private String buildname;// ;//
    private String floorname;//
    private String roomnum;//
    private String bennumber;//
    private String status;//
    private java.util.Date beddate;//
    private String bedDateStr;

    public String getBedDateStr() {
        return DateUtil.formatDateToStr(this.beddate);
    }

    public void setBedDateStr(String bedDateStr) {
        this.bedDateStr = bedDateStr;
    }

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

    public String getClassinfoname() {
        return classinfoname;
    }

    public void setClassinfoname(String classinfoname) {
        this.classinfoname = classinfoname;
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

    public String getBennumber() {
        return bennumber;
    }

    public void setBennumber(String bennumber) {
        this.bennumber = bennumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBeddate() {
        return beddate;
    }

    public void setBeddate(Date beddate) {
        this.beddate = beddate;
    }

}
