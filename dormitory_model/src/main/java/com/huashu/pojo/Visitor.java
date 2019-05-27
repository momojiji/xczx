package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_visitor")
public class Visitor implements Serializable{

	@Id
	private String id;//

	private String visitorname;//拜访人姓名
	private int sex;//姓名
	private String visitortel;//拜访人电话

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date visitordate;//拜访时间

	private String visitoruser;
	private String visitorusername;

	private String relation;//拜访人关系
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date leavetime;//离开时间

	private Integer status;//状态
	private Integer isvalidate;//是否有效
	private String visitorreason;//拜访原因
	private String remarks;//备注
	private String creator;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdate;//
	private String modifitor;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date modifiedate;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date applydate;//申请时间
	private Integer  havecar;//是由有车
	private String   photeimg;//照片
	private String   carnumber;//车牌号码

	private String visitordir;//拜访学生S   拜访老师T

	public String getVisitorusername() {
		return visitorusername;
	}

	public void setVisitorusername(String visitorusername) {
		this.visitorusername = visitorusername;
	}

	public String getVisitordir() {
		return visitordir;
	}

	public void setVisitordir(String visitordir) {
		this.visitordir = visitordir;
	}

	public String getVisitoruser() {
		return visitoruser;
	}

	public void setVisitoruser(String visitoruser) {
		this.visitoruser = visitoruser;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public Integer getHavecar() {
		return havecar;
	}

	public void setHavecar(Integer havecar) {
		this.havecar = havecar;
	}

	public String getPhoteimg() {
		return photeimg;
	}

	public void setPhoteimg(String photeimg) {
		this.photeimg = photeimg;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getVisitorname() {		
		return visitorname;
	}
	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}

	public String getVisitortel() {		
		return visitortel;
	}
	public void setVisitortel(String visitortel) {
		this.visitortel = visitortel;
	}

	public java.util.Date getVisitordate() {		
		return visitordate;
	}
	public void setVisitordate(java.util.Date visitordate) {
		this.visitordate = visitordate;
	}


	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}

	public java.util.Date getLeavetime() {		
		return leavetime;
	}
	public void setLeavetime(java.util.Date leavetime) {
		this.leavetime = leavetime;
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
