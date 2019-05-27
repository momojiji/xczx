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
@Table(name="tb_leaveinfo")
public class Leaveinfo implements Serializable{

	@Id
	private String id;//
	private String studentid;
	private String leavetype;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date applydate;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date begindate;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date rebackdate;//
	private String duration;//
	private Integer status;//
	private Integer isvalidate;//
	private String leavereason;//
	private String remarks;//
	private String creator;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdate;//
	private String modifitor;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date modifiedate;//

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getLeavetype() {		
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public java.util.Date getApplydate() {		
		return applydate;
	}
	public void setApplydate(java.util.Date applydate) {
		this.applydate = applydate;
	}

	public java.util.Date getBegindate() {		
		return begindate;
	}
	public void setBegindate(java.util.Date begindate) {
		this.begindate = begindate;
	}

	public java.util.Date getRebackdate() {		
		return rebackdate;
	}
	public void setRebackdate(java.util.Date rebackdate) {
		this.rebackdate = rebackdate;
	}

	public String getDuration() {		
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
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

	public String getLeavereason() {		
		return leavereason;
	}
	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
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
