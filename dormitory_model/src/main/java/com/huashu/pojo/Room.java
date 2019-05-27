package com.huashu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_room")
public class Room implements Serializable{

	@Id
	private String id;//
	private String roomname;//
	private String roomnum;//
	private String roomcode;//
	private Integer sextype;//
	private Integer status;//
	private Integer isvalidate;//
	private String remarks;//
	private String creator;//
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//
	private String dormitoryid;
	private String buildid;
	private String roomtypeid;
	private Integer maxstudent;
	private Integer currentstudent;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getRoomname() {		
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomnum() {		
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomcode() {		
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public Integer getSextype() {
		return sextype;
	}
	public void setSextype(Integer sextype) {
		this.sextype = sextype;
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

	public String getDormitoryid() {
		return dormitoryid;
	}

	public void setDormitoryid(String dormitoryid) {
		this.dormitoryid = dormitoryid;
	}

	public String getRoomtypeid() {
		return roomtypeid;
	}

	public void setRoomtypeid(String roomtypeid) {
		this.roomtypeid = roomtypeid;
	}

	public String getBuildid() {
		return buildid;
	}

	public void setBuildid(String buildid) {
		this.buildid = buildid;
	}

	public Integer getMaxstudent() {
		return maxstudent;
	}

	public void setMaxstudent(Integer maxstudent) {
		this.maxstudent = maxstudent;
	}

	public Integer getCurrentstudent() {
		return currentstudent;
	}

	public void setCurrentstudent(Integer currentstudent) {
		this.currentstudent = currentstudent;
	}
}
