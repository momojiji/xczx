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
@Table(name="tb_signinfo")
public class Signinfo implements Serializable{

	@Id
	private String id;//

	private String studentid;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date sigindate;//
	private String address;//
	private Integer status;//
	private Integer isvalidate;//
	private String photos;//
	private String remarks;//
	private String creator;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdate;//
	private String modifitor;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date modifiedate;//
	private String classinfoid;
	private String userid;
	private String gdLat;
	private String gdLon;

	public String getGdLat() {
		return gdLat;
	}

	public void setGdLat(String gdLat) {
		this.gdLat = gdLat;
	}

	public String getGdLon() {
		return gdLon;
	}

	public void setGdLon(String gdLon) {
		this.gdLon = gdLon;
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

	public java.util.Date getSigindate() {		
		return sigindate;
	}
	public void setSigindate(java.util.Date sigindate) {
		this.sigindate = sigindate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhotos() {		
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
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


	public String getClassinfoid() {
		return classinfoid;
	}

	public void setClassinfoid(String classinfoid) {
		this.classinfoid = classinfoid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
