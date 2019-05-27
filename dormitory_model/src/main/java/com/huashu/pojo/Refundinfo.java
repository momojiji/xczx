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
@Table(name="tb_refundinfo")
public class Refundinfo implements Serializable{

	@Id
	private String id;//


	
	private String studentname;//
	private String studentnum;//
	private String collegecode;//
	private Integer status;//
	private String collegeid;//
	private String majorid;//
	private String classid;//
	private String tuition;//
	private String hotelexpense;//
	private String ticketnum;//
	private String dormitorypid;//
	private String dormitoryid;//
	private String roomid;//
	private String bednumber;//

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date refunddate;//
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

	public String getCollegecode() {		
		return collegecode;
	}
	public void setCollegecode(String collegecode) {
		this.collegecode = collegecode;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCollegeid() {		
		return collegeid;
	}
	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getMajorid() {		
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public String getClassid() {		
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getTuition() {		
		return tuition;
	}
	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getHotelexpense() {		
		return hotelexpense;
	}
	public void setHotelexpense(String hotelexpense) {
		this.hotelexpense = hotelexpense;
	}

	public String getTicketnum() {		
		return ticketnum;
	}
	public void setTicketnum(String ticketnum) {
		this.ticketnum = ticketnum;
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

	public String getBednumber() {		
		return bednumber;
	}
	public void setBednumber(String bednumber) {
		this.bednumber = bednumber;
	}

	public java.util.Date getRefunddate() {		
		return refunddate;
	}
	public void setRefunddate(java.util.Date refunddate) {
		this.refunddate = refunddate;
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
