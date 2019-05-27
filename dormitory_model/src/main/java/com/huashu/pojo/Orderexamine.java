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
@Table(name="tb_orderexamine")
public class Orderexamine implements Serializable{

	@Id
	private String id;//


	
	private String workorder;//
	private String userid;//
	private java.util.Date examinedate;//
	private Integer statusbefore;//
	private Integer statusafter;//
	private Integer isvalid;//
	private String desp;//
	private String remarks;//
	private String creator;//
	private java.util.Date createdate;//

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getWorkorder() {		
		return workorder;
	}
	public void setWorkorder(String workorder) {
		this.workorder = workorder;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public java.util.Date getExaminedate() {		
		return examinedate;
	}
	public void setExaminedate(java.util.Date examinedate) {
		this.examinedate = examinedate;
	}

	public Integer getStatusbefore() {		
		return statusbefore;
	}
	public void setStatusbefore(Integer statusbefore) {
		this.statusbefore = statusbefore;
	}

	public Integer getStatusafter() {		
		return statusafter;
	}
	public void setStatusafter(Integer statusafter) {
		this.statusafter = statusafter;
	}

	public Integer getIsvalid() {		
		return isvalid;
	}
	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public String getDesp() {		
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
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


	
}
