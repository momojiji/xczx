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
@Table(name="tb_allocation_student")
public class AllocationStudent implements Serializable{

	@Id
	private String id;//
	private String studentid;//
	private String allocation_id;//
	private java.util.Date dormdate;//
	private java.util.Date retiredate;//
	private String bednum;//
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

	public String getStudentid() {		
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getAllocation_id() {		
		return allocation_id;
	}
	public void setAllocation_id(String allocation_id) {
		this.allocation_id = allocation_id;
	}

	public java.util.Date getDormdate() {		
		return dormdate;
	}
	public void setDormdate(java.util.Date dormdate) {
		this.dormdate = dormdate;
	}

	public java.util.Date getRetiredate() {		
		return retiredate;
	}
	public void setRetiredate(java.util.Date retiredate) {
		this.retiredate = retiredate;
	}

	public String getBednum() {		
		return bednum;
	}
	public void setBednum(String bednum) {
		this.bednum = bednum;
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
