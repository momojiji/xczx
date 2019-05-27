package com.huashu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_resource")
public class Resource implements Serializable{

	@Id
	private String id;//
	private String resourcename;//
	private String resourcenum;//

	//当前菜单的父菜单
	@JsonIgnoreProperties("resourceList")
	@ManyToOne(targetEntity =Resource.class,
			cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
	@JoinColumn(name = "parentid",referencedColumnName ="id" )
	private Resource parentResource;


	private Integer resourceinfo;//
	private String resourcevalue;//
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

	public String getResourcename() {		
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getResourcenum() {		
		return resourcenum;
	}
	public void setResourcenum(String resourcenum) {
		this.resourcenum = resourcenum;
	}

	public Resource getParentResource() {
		return parentResource;
	}

	public void setParentResource(Resource parentResource) {
		this.parentResource = parentResource;
	}

	public Integer getResourceinfo() {
		return resourceinfo;
	}
	public void setResourceinfo(Integer resourceinfo) {
		this.resourceinfo = resourceinfo;
	}

	public String getResourcevalue() {		
		return resourcevalue;
	}
	public void setResourcevalue(String resourcevalue) {
		this.resourcevalue = resourcevalue;
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
