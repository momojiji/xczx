package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类  宿舍调配申请
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_allocaterecord")
public class AllocationRecord implements Serializable{

	@Id
	private String id;//
	private String studentid;//
	private String classinfoid;//

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date applydate;//
	private String dormitoryid;//
	private String olddormitoryid;//
	private String targetdormitoryid;//
	private Integer status;//
	private Integer isvalidate;//
	private String reason;//
	private String remarks;//
	private String creator;//
	private String modifitor;//
	private java.util.Date modifiedate;//
	private String bednum;

	public String getBednum() {
		return bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum;
	}

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

	public String getClassinfoid() {
		return classinfoid;
	}

	public void setClassinfoid(String classinfoid) {
		this.classinfoid = classinfoid;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getDormitoryid() {
		return dormitoryid;
	}

	public void setDormitoryid(String dormitoryid) {
		this.dormitoryid = dormitoryid;
	}

	public String getOlddormitoryid() {
		return olddormitoryid;
	}

	public void setOlddormitoryid(String olddormitoryid) {
		this.olddormitoryid = olddormitoryid;
	}

	public String getTargetdormitoryid() {
		return targetdormitoryid;
	}

	public void setTargetdormitoryid(String targetdormitoryid) {
		this.targetdormitoryid = targetdormitoryid;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
