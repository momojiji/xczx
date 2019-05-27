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
@Table(name="tb_major")
public class Major implements Serializable{

	@Id
	private String id;//
	private String majorname;//
	private String majornum;//
	private String majorcode;//
	private String collegeid;//
	private String direction;//
	private String disciplines;//
	private String subject;//
	private String internationalcode;//
	private String professionallevel;//
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

	public String getMajorname() {		
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public String getMajornum() {		
		return majornum;
	}
	public void setMajornum(String majornum) {
		this.majornum = majornum;
	}

	public String getMajorcode() {		
		return majorcode;
	}
	public void setMajorcode(String majorcode) {
		this.majorcode = majorcode;
	}

	public String getCollegeid() {		
		return collegeid;
	}
	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getDirection() {		
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDisciplines() {		
		return disciplines;
	}
	public void setDisciplines(String disciplines) {
		this.disciplines = disciplines;
	}

	public String getSubject() {		
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getInternationalcode() {
		return internationalcode;
	}

	public void setInternationalcode(String internationalcode) {
		this.internationalcode = internationalcode;
	}

	public String getProfessionallevel() {
		return professionallevel;
	}
	public void setProfessionallevel(String professionallevel) {
		this.professionallevel = professionallevel;
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
