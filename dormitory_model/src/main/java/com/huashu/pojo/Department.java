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
@Table(name="tb_department")
public class Department implements Serializable{

	@Id
	private String id;//
	private String deptname;//
	private String deptnum;//
	private String depttype;//
	private String deptduty;//
	private String parentid;//
	private Integer status;//
	private Integer isvalidate;//
	private String remarks;//
	private String creator;//
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//

	public Integer getIsvalidate() {
		return isvalidate;
	}

	public void setIsvalidate(Integer isvalidate) {
		this.isvalidate = isvalidate;
	}

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

	public Integer getStatus() {


		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
}
