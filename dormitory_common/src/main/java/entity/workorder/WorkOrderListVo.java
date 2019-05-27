package entity.workorder;

import entity.StatusCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @Auther: wyan
 * @Date: 2019/3/11 21:09
 * @Description:
 */
public class WorkOrderListVo {

    private String id;//
    private String ordername;//
    private String ordernum;//
    private String position;//
    private String usertel;
    private String repairname;
    private String studentname;
    private String repairtel;//
    private String isartificial;
    private String checkindate;//
    private String imgurl;
    private String attention;
    private String classinfoname;
    private String status;//
    private String dormitoryname;
    private String roomnum;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public String getRepairname() {
        return repairname;
    }

    public void setRepairname(String repairname) {
        this.repairname = repairname;
    }

    public String getRepairtel() {
        return repairtel;
    }

    public void setRepairtel(String repairtel) {
        this.repairtel = repairtel;
    }

    public String getCheckindate() {

        if(StringUtils.isNotEmpty(checkindate)&&checkindate.endsWith(".0")){
            return checkindate.substring(0,checkindate.length()-2);
        }
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getStatus() {

        if(status.equals(StatusCode.SAVE+"")){
            return "新增";
        }if(status.equals(StatusCode.APPLY+"")){
            return "申请";
        }
        if(status.equals(StatusCode.AGREE+"")){
            return "审核通过";
        }
        if(status.equals(StatusCode.REFUND+"")){
            return "REFUND";
        }
        if(status.equals(StatusCode.OTHERS+"")){
            return "已过期";
        }
        if(status.equals(StatusCode.REPAIRED+"")){
            return "已维修";
        }
        return status;
    }

    public String getIsartificial() {
        return isartificial;
    }

    public void setIsartificial(String isartificial) {
        this.isartificial = isartificial;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getClassinfoname() {
        return classinfoname;
    }

    public void setClassinfoname(String classinfoname) {
        this.classinfoname = classinfoname;
    }

    public String getDormitoryname() {
        return dormitoryname;
    }

    public void setDormitoryname(String dormitoryname) {
        this.dormitoryname = dormitoryname;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }
}
