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
@Table(name="tb_classinfo")
public class Classinfo implements Serializable{

	@Id
	private String id;//
	private String classinfoname;//
	private String classinfonum;//
	private String classinfocode;//
	private String majorid;//
	private Integer stucount;//
	private String userid;//
	private String address;//
	private Integer status;//
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

	public String getClassinfoname() {
		return classinfoname;
	}

	public void setClassinfoname(String classinfoname) {
		this.classinfoname = classinfoname;
	}

	public String getClassinfonum() {
		return classinfonum;
	}

	public void setClassinfonum(String classinfonum) {
		this.classinfonum = classinfonum;
	}

	public String getClassinfocode() {
		return classinfocode;
	}

	public void setClassinfocode(String classinfocode) {
		this.classinfocode = classinfocode;
	}

	public String getMajorid() {
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public Integer getStucount() {		
		return stucount;
	}
	public void setStucount(Integer stucount) {
		this.stucount = stucount;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
