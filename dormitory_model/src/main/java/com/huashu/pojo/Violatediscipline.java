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
@Table(name="tb_violatediscipline")
public class Violatediscipline implements Serializable{

	@Id
	private String id;//
	private String studentid;//学生ID
	private String roomid;//宿舍ID
	private String validatetype;//违纪类型
	private String userid;//通报人
	private java.util.Date noticedate;//通报时间
	private Integer status;//通报状态
	private Integer isvalidate;//
	private String validatedetail;//通报详情
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

	public String getRoomid() {		
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getValidatetype() {		
		return validatetype;
	}
	public void setValidatetype(String validatetype) {
		this.validatetype = validatetype;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public java.util.Date getNoticedate() {		
		return noticedate;
	}
	public void setNoticedate(java.util.Date noticedate) {
		this.noticedate = noticedate;
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

	public String getValidatedetail() {		
		return validatedetail;
	}
	public void setValidatedetail(String validatedetail) {
		this.validatedetail = validatedetail;
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
