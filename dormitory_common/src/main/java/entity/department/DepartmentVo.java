package entity.department;

import com.huashu.pojo.Department;
import entity.StatusCode;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @ClassName Department
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/5 16:10
 * @Version 1.0
 */
public class DepartmentVo{

    private String id;//
    private String deptname;//
    private String deptnum;//
    private String depttype;//
    private String deptduty;//
    private String parentid;//
    private String status;//
    private String isvalidate;//
    private String remarks;//
    private String creator;//
    private java.util.Date createdate;//
    private String modifitor;//
    private java.util.Date modifiedate;//

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public String getDeptduty() {
        return deptduty;
    }

    public void setDeptduty(String deptduty) {
        this.deptduty = deptduty;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getStatus() {
        if(!StringUtils.isEmpty(status)&&status.equals(StatusCode.USER_ENABLE+"")){
            return "正常";
        }else{
            return "禁用";
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsvalidate() {
        if(status.equals(StatusCode.USER_ENABLE+"")){
            return "有效";
        }else{
            return "无效";
        }
    }

    public void setIsvalidate(String isvalidate) {
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
}
