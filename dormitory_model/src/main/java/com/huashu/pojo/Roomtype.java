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
@Table(name="tb_roomtype")
public class Roomtype implements Serializable{

	@Id
	private String id;//
	private String typename;//
	private String typenum;//
	private Integer limitcount;//
	private Double money;//
	private String unit;//
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

	public String getTypename() {		
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypenum() {		
		return typenum;
	}
	public void setTypenum(String typenum) {
		this.typenum = typenum;
	}

	public Integer getLimitcount() {		
		return limitcount;
	}
	public void setLimitcount(Integer limitcount) {
		this.limitcount = limitcount;
	}

	public Double getMoney() {		
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}

	public String getUnit() {		
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
