package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_checksleep")
public class Checksleep implements Serializable{

	@Id
	private String id;//
	private String studentname;//
	private String studentnum;//
	private String classinfoid;//
	private String dormitorypid;// ;//
	private String dormitoryid;//
	private String roomid;//
	private String bennumber;//
	private Integer status;//
	private java.util.Date beddate;//
	private Integer isvalidate;//
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

	public String getClassinfoid() {
		return classinfoid;
	}

	public void setClassinfoid(String classinfoid) {
		this.classinfoid = classinfoid;
	}

	public String getDormitorypid() {
		return dormitorypid;
	}

	public void setDormitorypid(String dormitorypid) {
		this.dormitorypid = dormitorypid;
	}

	public String getDormitoryid() {
		return dormitoryid;
	}

	public void setDormitoryid(String dormitoryid) {
		this.dormitoryid = dormitoryid;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getBennumber() {
		return bennumber;
	}
	public void setBennumber(String bennumber) {
		this.bennumber = bennumber;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getBeddate() {		
		return beddate;
	}
	public void setBeddate(java.util.Date beddate) {
		this.beddate = beddate;
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
