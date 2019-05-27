package entity.workorder;

import entity.classinfo.ClassinfoApiVo;
import entity.room.RoomApiVo;
import entity.student.StudentApiVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "报修工单列表返回值对照")
public class WorkorderApiVo {

    private String id;


    @ApiModelProperty(value = "班级ID")
    private String classid;//

    private ClassinfoApiVo classinfo;

    @ApiModelProperty(value = "保修工单名称")
    private String ordername;//

    private String position;//

    private String workorderid;

    private String ordertype;//

    private String userid;

    private StudentApiVo student;

    @ApiModelProperty(value = "报修工单状态：0:新增数据，1:申请修 ,2:审核通过, 3:拒绝 ,4：已过期(未审核已过期)， 5：已维修" )
    private Integer status;//

    @ApiModelProperty(value = "是否认为：0为是 ， 1为否")
    private Integer isartificial;//

    @ApiModelProperty(value = "登记时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date checkindate;//

    private RoomApiVo room;

    private String roomname;

    private String cengname;

    private String dormitoryname;

    private String dormitoryid;

    private String roomview;

    private String attention;//

    private String remarks;//

    private String creator;//

    private String usertel;

    private String imgurl;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createdate;//

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    private Integer isvalidate;//

    public Integer getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Integer isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

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

    public ClassinfoApiVo getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(ClassinfoApiVo classinfo) {
        this.classinfo = classinfo;
    }

    public RoomApiVo getRoom() {
        return room;
    }

    public void setRoom(RoomApiVo room) {
        this.room = room;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid;
    }

    public String getRoomview() {
        return dormitoryname+"-"+cengname+"-"+roomname;
    }

    public void setRoomview(String roomview) {
        this.roomview = roomview;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getCengname() {
        return cengname;
    }

    public void setCengname(String cengname) {
        this.cengname = cengname;
    }

    public String getDormitoryname() {
        return dormitoryname;
    }

    public void setDormitoryname(String dormitoryname) {
        this.dormitoryname = dormitoryname;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsartificial() {
        return isartificial;
    }

    public void setIsartificial(Integer isartificial) {
        this.isartificial = isartificial;
    }

    public Date getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Date checkindate) {
        this.checkindate = checkindate;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImgurl() {
        return imgurl==null?"":imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
