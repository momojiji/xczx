package com.huashu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_dormitory")
public class Dormitory implements Serializable{

	@Id
	private String id;//
	private String dormitoryname;//
	private String dormitorynum;//
	private String parentcode;//
	private String dormitorycode;
	private String deepth;//
	private String collegeid;//
	private Integer status;//
	private Integer ordernum;//
	private String remarks;//
	private Integer isvalidate;//
	private String creator;//
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//
	//宿舍的上级
	private String parentid;
	//当前宿舍的负责人id
	private String userid;
	//宿舍楼微信人员id
	private String repairuserid;

	public String getRepairuserid() {
		return repairuserid;
	}

	public void setRepairuserid(String repairuserid) {
		this.repairuserid = repairuserid;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getDormitoryname() {		
		return dormitoryname;
	}
	public void setDormitoryname(String dormitoryname) {
		this.dormitoryname = dormitoryname;
	}

	public String getDormitorynum() {		
		return dormitorynum;
	}
	public void setDormitorynum(String dormitorynum) {
		this.dormitorynum = dormitorynum;
	}


	public String getParentcode() {
		return parentcode;
	}
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public String getDeepth() {		
		return deepth;
	}
	public void setDeepth(String deepth) {
		this.deepth = deepth;
	}

	public String getCollegeid() {		
		return collegeid;
	}
	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}


	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrdernum() {		
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getRemarks() {		
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIsvalidate() {		
		return isvalidate;
	}
	public void setIsvalidate(Integer isvalidate) {
		this.isvalidate = isvalidate;
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

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDormitorycode() {
		return dormitorycode;
	}

	public void setDormitorycode(String dormitorycode) {
		this.dormitorycode = dormitorycode;
	}
}
