package entity.user;

import com.huashu.pojo.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserApiVo
 * @Description 教师信息表
 * @Author Administrator
 * @Date 2019/1/22 12:36
 * @Version 1.0
 */
@ApiModel("教师信息对照表")
public class UserApiVo {
    private String id;//

    @ApiModelProperty("用户名")
    private String username;//

    @ApiModelProperty("登录名")
    private String loginname;//

    @ApiModelProperty("密码")
    private String password;//
    @ApiModelProperty("用户编号")
    private String usernum;//用户编号

    @ApiModelProperty("用户类型")
    private String usertype;//默认0：教师(辅导员)  、1：宿管人员、2、维修人员  3、院领导

    @ApiModelProperty("状态")
    private Integer status;//状态

    @ApiModelProperty("部门")
    private String deptid;//
    @ApiModelProperty("备注")
    private String remarks4;//
    @ApiModelProperty("职位")
    private Integer position;//
    @ApiModelProperty("性别")
    private Integer sex;//
    @ApiModelProperty("电话")
    private String telphone;//
    @ApiModelProperty("地址")
    private String address;//
    @ApiModelProperty("宿舍楼")
    private Integer dormitory;//
    @ApiModelProperty("是否有效")
    private Integer isvalid;//
    private String politicastatus;

    private String remarks;//
    private Role role;
    private String  photos;
    private String appdeviceid;//推送的设备ID

    private String booklogo;

    public String getPoliticastatus() {
        return politicastatus;
    }

    public void setPoliticastatus(String politicastatus) {
        this.politicastatus = politicastatus;
    }

    public String getBooklogo() {
        return booklogo;
    }

    public void setBooklogo(String booklogo) {
        this.booklogo = booklogo;
    }

    public String getAppdeviceid() {
        return appdeviceid;
    }

    public void setAppdeviceid(String appdeviceid) {
        this.appdeviceid = appdeviceid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getRemarks4() {
        return remarks4;
    }

    public void setRemarks4(String remarks4) {
        this.remarks4 = remarks4;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDormitory() {
        return dormitory;
    }

    public void setDormitory(Integer dormitory) {
        this.dormitory = dormitory;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
        this.booklogo=photos;
    }
}
