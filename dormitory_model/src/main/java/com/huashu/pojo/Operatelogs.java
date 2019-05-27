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
@Table(name="tb_operatelogs")
public class Operatelogs implements Serializable{

	@Id
	private String id;//
	private String userid;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date operatedate;//
	private String operatetable;//
	private Integer operatetableid;//
	private String operbefore;//
	private String operafter;//
	private String remarks;//
	private Integer creator;//
	private java.util.Date createdate;//

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public java.util.Date getOperatedate() {		
		return operatedate;
	}
	public void setOperatedate(java.util.Date operatedate) {
		this.operatedate = operatedate;
	}

	public String getOperatetable() {		
		return operatetable;
	}
	public void setOperatetable(String operatetable) {
		this.operatetable = operatetable;
	}

	public Integer getOperatetableid() {		
		return operatetableid;
	}
	public void setOperatetableid(Integer operatetableid) {
		this.operatetableid = operatetableid;
	}

	public String getOperbefore() {		
		return operbefore;
	}
	public void setOperbefore(String operbefore) {
		this.operbefore = operbefore;
	}

	public String getOperafter() {		
		return operafter;
	}
	public void setOperafter(String operafter) {
		this.operafter = operafter;
	}

	public String getRemarks() {		
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getCreator() {		
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public java.util.Date getCreatedate() {		
		return createdate;
	}
	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}


	
}
