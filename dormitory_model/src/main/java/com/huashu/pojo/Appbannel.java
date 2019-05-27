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
@Table(name="tb_appbannel")
public class Appbannel implements Serializable{

	@Id
	private String id;//
	private String modelname;//
	private String imgname;//
	private String imgsuffix;//
	private String imgurl;//
	private Integer status;//

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date releasedate;//

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date effectivetime;//

	private String imgsize;//
	private String imgtype;//
	private Integer ordernum;//
	private String apptype;
	private String url;
	private Integer isvalidate;//
	private String remarks;//
	private String creator;//
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getImgname() {		
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getImgsuffix() {		
		return imgsuffix;
	}
	public void setImgsuffix(String imgsuffix) {
		this.imgsuffix = imgsuffix;
	}

	public String getImgurl() {		
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getReleasedate() {		
		return releasedate;
	}
	public void setReleasedate(java.util.Date releasedate) {
		this.releasedate = releasedate;
	}

	public java.util.Date getEffectivetime() {		
		return effectivetime;
	}
	public void setEffectivetime(java.util.Date effectivetime) {
		this.effectivetime = effectivetime;
	}

	public String getImgsize() {		
		return imgsize;
	}
	public void setImgsize(String imgsize) {
		this.imgsize = imgsize;
	}

	public String getImgtype() {		
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}

	public Integer getOrdernum() {		
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
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
