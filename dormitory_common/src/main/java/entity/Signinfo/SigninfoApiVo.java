package entity.Signinfo;

import com.huashu.pojo.Student;
import entity.student.StudentApiVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName SigninfoApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/22 12:04
 * @Version 1.0
 */
@ApiModel(value = "学生签到字段对应信息")
public class SigninfoApiVo {
    private String id;//

    @ApiModelProperty(value = "对应学生")
    private StudentApiVo student;

    @ApiModelProperty(value = "学生ID")
    private String studentid;//

    @ApiModelProperty(value = "签到日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date signdate;//

    @ApiModelProperty(value = "签到地址")
    private String address;//

    private String status;//签到状态：0：正常 1异常

    private Integer isvalidate;//

    @ApiModelProperty(value = "签到照片")
    private String photos;//

    private String creator;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createdate;//

    private String classid;
    private String userid;

    private String gdLat;
    private String gdLon;
    private String remarks;

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

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Integer isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getGdLat() {
        return gdLat;
    }

    public void setGdLat(String gdLat) {
        this.gdLat = gdLat;
    }

    public String getGdLon() {
        return gdLon;
    }

    public void setGdLon(String gdLon) {
        this.gdLon = gdLon;
    }
}
