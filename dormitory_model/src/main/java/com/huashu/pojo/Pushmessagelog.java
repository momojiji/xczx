package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_pushmessagelog")
public class Pushmessagelog implements Serializable{

	@Id
	private String id;//
	private String pushuserid;//
	private String reviewuserid;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date pushdate;//
	private String pushtype;//
	private String title;//
	private String context;//
	/**
	 * 表示用户是否已经查看当前消息 0表示未查看、 1表示已查看
	 */
	private String isopen;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date opendate;//
	/**
	 * 表示当前数据为有效的0:为有效.1 为无效
	 */
	private Integer status;//
	/**
	 * 表示为成功，  当推送返回成功消息是更新消息为1 ：为成功
	 */
	private Integer issuccess;//
	private String visitorreason;//
	private String remarks;//
	/**
	 * 消息的来源： student  表示学生 ， teacher 表示老师
	 */
	private String source;//
	/**
	 * 来源的ID
	 */
	private String sourcemodelid;//

	private String classinfoid;

	public String getClassinfoid() {
		return classinfoid;
	}

	public void setClassinfoid(String classinfoid) {
		this.classinfoid = classinfoid;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourcemodelid() {
		return sourcemodelid;
	}

	public void setSourcemodelid(String sourcemodelid) {
		this.sourcemodelid = sourcemodelid;
	}

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPushuserid() {		
		return pushuserid;
	}
	public void setPushuserid(String pushuserid) {
		this.pushuserid = pushuserid;
	}

	public String getReviewuserid() {		
		return reviewuserid;
	}
	public void setReviewuserid(String reviewuserid) {
		this.reviewuserid = reviewuserid;
	}

	public Date getPushdate() {
		return pushdate;
	}

	public void setPushdate(Date pushdate) {
		this.pushdate = pushdate;
	}

	public String getPushtype() {
		return pushtype;
	}

	public void setPushtype(String pushtype) {
		this.pushtype = pushtype;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {		
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}

	public java.util.Date getOpendate() {		
		return opendate;
	}
	public void setOpendate(java.util.Date opendate) {
		this.opendate = opendate;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIssuccess() {		
		return issuccess;
	}
	public void setIssuccess(Integer issuccess) {
		this.issuccess = issuccess;
	}

	public String getVisitorreason() {		
		return visitorreason;
	}
	public void setVisitorreason(String visitorreason) {
		this.visitorreason = visitorreason;
	}

	public String getRemarks() {		
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	
}
