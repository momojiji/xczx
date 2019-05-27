package entity.user;

import entity.StatusCode;
import org.springframework.util.StringUtils;

/**
 * @Auther: wyan
 * @Date: 2019/2/26 00:16
 * @Description:
 */
public class UserVo {

    private String id;
    private String username;
    private String loginname;
    private String usernum;
    private String status;
    private String sex;
    private String telphone;
    private String deptname;
    private String rolename;
    private String roleId;

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

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getStatus() {
        if(status.equals(StatusCode.USER_ENABLE+"")){
            return "正常";
        }else{
            return "禁用";
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {

        if(!StringUtils.isEmpty(sex)&&sex.equals(StatusCode.USER_MAN)){
            return "男";
        }else{
            return "女";
        }
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
