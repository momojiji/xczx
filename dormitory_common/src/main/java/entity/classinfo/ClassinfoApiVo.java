package entity.classinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "班级类的返回字段表")
public class ClassinfoApiVo {

    private String id;
    @ApiModelProperty("班级名称")
    private String classinfoname;//班级名称
    @ApiModelProperty("班级编号")
    private String classinfonum;//班级编号
    @ApiModelProperty("班级CODE")
    private String classinfocode;//班级CODE
    @ApiModelProperty("专业ID")
    private String majorid;//专业ID
    @ApiModelProperty("学生总数")
    private Integer stucount;//学生总数
    @ApiModelProperty("辅导员")
    private String userid;//辅导员
    @ApiModelProperty("地址")
    private String address;//地址
    @ApiModelProperty("状态")
    private Integer status;//状态
    @ApiModelProperty("专业名称")
    private String majorname;//专业名称
    @ApiModelProperty("学院名称")
    private String collegename; //学院名称


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassinfoname() {
        return classinfoname;
    }

    public void setClassinfoname(String classinfoname) {
        this.classinfoname = classinfoname;
    }

    public String getClassinfonum() {
        return classinfonum;
    }

    public void setClassinfonum(String classinfonum) {
        this.classinfonum = classinfonum;
    }

    public String getClassinfocode() {
        return classinfocode;
    }

    public void setClassinfocode(String classinfocode) {
        this.classinfocode = classinfocode;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public Integer getStucount() {
        return stucount;
    }

    public void setStucount(Integer stucount) {
        this.stucount = stucount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }
}
