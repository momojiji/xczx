package entity.student;

import com.huashu.pojo.Allocation;
import com.huashu.pojo.Classinfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Room;
import entity.classinfo.ClassinfoApiVo;
import entity.room.RoomApiVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @Auther: wyan
 * @Date: 2019/1/17 11:29
 * @Description:
 */
@ApiModel("学生信息的返回值对照表")
public class StudentApiVo {

    @ApiModelProperty("主键ID")
    private String id;//

    @ApiModelProperty("学生名称")
    private String studentname;//学生名称

    @ApiModelProperty("学生学号")
    private String studentnum;//学生学号

    @ApiModelProperty("入学年份")
    private String collegecode;//入学年份

    @ApiModelProperty("户籍地址")
    private String idaddress;//户籍地址

    @ApiModelProperty("身份证号")
    private String idcard;//身份证号

    @ApiModelProperty("出生日期")
    private Date birthday;//出生日期

    @ApiModelProperty("身份证正")
    private String idcardfront;//身份证正

    @ApiModelProperty("身份证反")
    private String idcardback;//身份证反

    @ApiModelProperty("政治面貌")
    private String politicaloutlook;//政治面貌

    @ApiModelProperty("家庭地址")
    private String homeaddress;//家庭地址

    @ApiModelProperty("家庭电话")
    private String hometel;//家庭电话

    @ApiModelProperty("人像识别")
    private String personphone;// 	人像识别

    @ApiModelProperty("学生手机号")
    private String studenttel;//学生手机号

    @ApiModelProperty("密码")
    private String password;//密码

    @ApiModelProperty("classid")
    private String classid;//classid

    @ApiModelProperty("classinfo") //班级信息
    private ClassinfoApiVo classinfo;

    @ApiModelProperty("builddormitory") //班级信息
    private Dormitory builddormitory;//宿舍楼信息

    @ApiModelProperty("floorDormitory") //层信息
    private Dormitory floorDormitory;//层信息

    @ApiModelProperty("room") //宿舍信息
    private RoomApiVo room;//宿舍信息

    @ApiModelProperty("性别")
    private Integer sex;//性别

    private String photo;

    @ApiModelProperty("曾用名")
    private String namedbefore;//曾用名

    @ApiModelProperty("姓名拼音")
    private String namecode;//姓名拼音

    @ApiModelProperty("考生号")
    private String examnum;//考生号

    @ApiModelProperty("院系/部")
    private String collegeid;//院系/部

    @ApiModelProperty("专业代码")
    private String majornum;//专业代码

    @ApiModelProperty("专业ID")
    private String majorid;//专业ID

    @ApiModelProperty("专业方向")
    private String direction;//专业方向
    @ApiModelProperty("学科大类")
    private String disciplines;//学科大类
    @ApiModelProperty("学科")
    private String subject;//学科
    @ApiModelProperty("国际专业代码")
    private String internationalcode;//国际专业代码
    @ApiModelProperty("专业培养层次")
    private String professionallevel;//专业培养层次
    @ApiModelProperty("现在年纪")
    private Integer presentage;//现在年纪
    @ApiModelProperty("学生状态")
    private Integer status;//学生状态
    private Integer logincount=0;
    private String appdeviceid;//推送的设备ID
    private Integer isvalidate;//是否有效
    private String remarks;//
    private String creator;//
    private java.util.Date createdate;//
    private String modifitor;//
    private java.util.Date modifiedate;//

    public String getAppdeviceid() {
        return appdeviceid;
    }

    public void setAppdeviceid(String appdeviceid) {
        this.appdeviceid = appdeviceid;
    }

    public ClassinfoApiVo getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(ClassinfoApiVo classinfo) {
        this.classinfo = classinfo;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
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

    public String getCollegecode() {
        return collegecode;
    }

    public void setCollegecode(String collegecode) {
        this.collegecode = collegecode;
    }

    public String getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(String idaddress) {
        this.idaddress = idaddress;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcardfront() {
        return idcardfront;
    }

    public void setIdcardfront(String idcardfront) {
        this.idcardfront = idcardfront;
    }

    public String getIdcardback() {
        return idcardback;
    }

    public void setIdcardback(String idcardback) {
        this.idcardback = idcardback;
    }

    public String getPoliticaloutlook() {
        return politicaloutlook;
    }

    public void setPoliticaloutlook(String politicaloutlook) {
        this.politicaloutlook = politicaloutlook;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getHometel() {
        return hometel;
    }

    public void setHometel(String hometel) {
        this.hometel = hometel;
    }

    public String getPersonphone() {
        return personphone;
    }

    public void setPersonphone(String personphone) {
        this.personphone = personphone;
    }

    public String getStudenttel() {
        return studenttel;
    }

    public void setStudenttel(String studenttel) {
        this.studenttel = studenttel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNamedbefore() {
        return namedbefore;
    }

    public void setNamedbefore(String namedbefore) {
        this.namedbefore = namedbefore;
    }

    public String getNamecode() {
        return namecode;
    }

    public void setNamecode(String namecode) {
        this.namecode = namecode;
    }

    public String getExamnum() {
        return examnum;
    }

    public void setExamnum(String examnum) {
        this.examnum = examnum;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }

    public String getMajornum() {
        return majornum;
    }

    public void setMajornum(String majornum) {
        this.majornum = majornum;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInternationalcode() {
        return internationalcode;
    }

    public void setInternationalcode(String internationalcode) {
        this.internationalcode = internationalcode;
    }

    public String getProfessionallevel() {
        return professionallevel;
    }

    public void setProfessionallevel(String professionallevel) {
        this.professionallevel = professionallevel;
    }

    public Integer getPresentage() {
        return presentage;
    }

    public void setPresentage(Integer presentage) {
        this.presentage = presentage;
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

    public Dormitory getBuilddormitory() {
        return builddormitory;
    }

    public void setBuilddormitory(Dormitory builddormitory) {
        this.builddormitory = builddormitory;
    }

    public Dormitory getFloorDormitory() {
        return floorDormitory;
    }

    public void setFloorDormitory(Dormitory floorDormitory) {
        this.floorDormitory = floorDormitory;
    }

    public RoomApiVo getRoom() {
        return room;
    }

    public void setRoom(RoomApiVo room) {
        this.room = room;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
