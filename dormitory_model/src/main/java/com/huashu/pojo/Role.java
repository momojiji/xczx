package com.huashu.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_role")
public class Role implements Serializable{

	@Id
	private String id;//
	private String rolename;//
	private String rolenum;//
	private String roleduty;//
	private String rolenature;//
	private Integer status;//
	private Integer isvalid;//
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

	public String getRolename() {		
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolenum() {		
		return rolenum;
	}
	public void setRolenum(String rolenum) {
		this.rolenum = rolenum;
	}

	public String getRoleduty() {		
		return roleduty;
	}
	public void setRoleduty(String roleduty) {
		this.roleduty = roleduty;
	}

	public String getRolenature() {		
		return rolenature;
	}
	public void setRolenature(String rolenature) {
		this.rolenature = rolenature;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

	public String getCreator() {		
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public java.util.Date getCreatedate() {		
		return createdate;
	}
	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public String getModifitor() {		
		return modifitor;
	}
	public void setModifitor(String modifitor) {
		this.modifitor = modifitor;
	}

	public java.util.Date getModifiedate() {		
		return modifiedate;
	}
	public void setModifiedate(java.util.Date modifiedate) {
		this.modifiedate = modifiedate;
	}


	
}
