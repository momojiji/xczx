package entity.visitor;

import entity.student.StudentApiVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName VisitorApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/20 21:33
 * @Version 1.0
 */
@ApiModel("访客信息展示类信息")
public class VisitorApiVo {
    private String id;//
    @ApiModelProperty("拜访人姓名")
    private String visitorname;//拜访人姓名
    @ApiModelProperty("姓名")
    private int sex;//姓名
    @ApiModelProperty("拜访人姓名")
    private String visitortel;//拜访人电话
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("拜访时间")
    private java.util.Date visitordate;//拜访时间
    @ApiModelProperty("被拜访人信息")
    private String visitoruser;//被拜访人信息

    @ApiModelProperty("被拜访人信息姓名")
    private String visitorusername;//被拜访人信息

    @ApiModelProperty("被拜访人想信息")
    private StudentApiVo student;
    @ApiModelProperty("拜访人关系")
    private String relation;//拜访人关系

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("离开时间")
    private java.util.Date leavetime;//离开时间
    @ApiModelProperty("状态")
    private Integer status;//状态
    @ApiModelProperty("是否有效")
    private Integer isvalidate;//是否有效
    @ApiModelProperty("拜访原因")
    private String visitorreason;//拜访原因
    @ApiModelProperty("备注")
    private String remarks;//备注
    @ApiModelProperty("申请时间")
    private String applydate;//申请时间
    @ApiModelProperty("是由有车")
    private Integer  havecar;//是由有车
    @ApiModelProperty("照片")
    private String   photeimg;//照片
    @ApiModelProperty("车牌号码")
    private String   carnumber;//车牌号码

    private String visitordir;//拜访学生S   拜访老师T

    private String creator;//

    public String getVisitorusername() {
        return visitorusername;
    }

    public void setVisitorusername(String visitorusername) {
        this.visitorusername = visitorusername;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createdate;//
    private String modifitor;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date modifiedate;//

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

    public String getVisitordir() {
        return visitordir;
    }

    public void setVisitordir(String visitordir) {
        this.visitordir = visitordir;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getVisitortel() {
        return visitortel;
    }

    public void setVisitortel(String visitortel) {
        this.visitortel = visitortel;
    }

    public Date getVisitordate() {
        return visitordate;
    }

    public void setVisitordate(Date visitordate) {
        this.visitordate = visitordate;
    }

    public String getVisitoruser() {
        return visitoruser;
    }

    public void setVisitoruser(String visitoruser) {
        this.visitoruser = visitoruser;
    }

    public StudentApiVo getStudent() {
        return student;
    }

    public void setStudent(StudentApiVo student) {
        this.student = student;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
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

    public String getVisitorreason() {
        return visitorreason;
    }

    public void setVisitorreason(String visitorreason) {
        this.visitorreason = visitorreason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public Integer getHavecar() {
        return havecar;
    }

    public void setHavecar(Integer havecar) {
        this.havecar = havecar;
    }

    public String getPhoteimg() {
        return photeimg;
    }

    public void setPhoteimg(String photeimg) {
        this.photeimg = photeimg;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }
}
