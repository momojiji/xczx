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
@Table(name="tb_allocation")
public class Allocation implements Serializable{

	@Id
	private String id;//
	private String roomid;//
	private String roomnum;//
	private String bednum;
	private String bedtype;
	private String allocationdate;//
	private String buildid;//
	private String dormitoryid;//
	private String status;//入住状态: 0:未入住 ,1已注入
	private Integer isvalid;//
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

	public String getRoomid() {		
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getRoomnum() {		
		return roomnum;
	}
	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getAllocationdate() {		
		return allocationdate;
	}
	public void setAllocationdate(String allocationdate) {
		this.allocationdate = allocationdate;
	}

	public String getBuildid() {
		return buildid;
	}

	public void setBuildid(String buildid) {
		this.buildid = buildid;
	}

	public String getDormitoryid() {
		return dormitoryid;
	}
	public void setDormitoryid(String dormitoryid) {
		this.dormitoryid = dormitoryid;
	}

	public String getStatus() {
		return this.status;

	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
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

	public String getBednum() {
		return bednum;
	}

	public void setBednum(String bednum) {
		this.bednum = bednum;
	}

	public String getBedtype() {

		return this.bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}
}
