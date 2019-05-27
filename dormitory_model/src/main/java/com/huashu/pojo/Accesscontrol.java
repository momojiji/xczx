package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="tb_accesscontrol")
public class Accesscontrol implements Serializable{

	@Id
	private String id;//
	private String studentid;//学生信息
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date leavedate;//离校时间
	private String outdoorid;//出校门口ID
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date rebackdate;//返校时间
	private String incomeid;//如校门口ID
	private Integer status;//状态
	private Integer isvalidate;//
	private String visitorreason;//离开原因
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

	public java.util.Date getLeavedate() {		
		return leavedate;
	}
	public void setLeavedate(java.util.Date leavedate) {
		this.leavedate = leavedate;
	}

	public String getOutdoorid() {
		return outdoorid;
	}

	public void setOutdoorid(String outdoorid) {
		this.outdoorid = outdoorid;
	}

	public String getIncomeid() {
		return incomeid;
	}

	public void setIncomeid(String incomeid) {
		this.incomeid = incomeid;
	}

	public java.util.Date getRebackdate() {
		return rebackdate;
	}
	public void setRebackdate(java.util.Date rebackdate) {
		this.rebackdate = rebackdate;
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
