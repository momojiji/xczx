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
@Table(name="tb_college")
public class College implements Serializable{

	@Id
	private String id;//
	private String collegename;//
	private String collegenum;//
	private String collegecode;//
	private String parentid;//
	private String stucount;//
	private String userid;//
	private Integer status;//
	private Integer isvalidate;//
	private String remarks;//
	private String creator;//
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//
	private String deepth;

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCollegename() {		
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getCollegenum() {		
		return collegenum;
	}
	public void setCollegenum(String collegenum) {
		this.collegenum = collegenum;
	}

	public String getCollegecode() {		
		return collegecode;
	}
	public void setCollegecode(String collegecode) {
		this.collegecode = collegecode;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getStucount() {
		return stucount;
	}
	public void setStucount(String stucount) {
		this.stucount = stucount;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getDeepth() {
		return deepth;
	}

	public void setDeepth(String deepth) {
		this.deepth = deepth;
	}
}
