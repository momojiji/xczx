package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private String id;//
	private String username;//用户姓名
	private String loginname;//登录名称
	private String password;//密码
	private String usernum;//编号
	private String usertype;//用户类型
	private Integer status;//状态
	private String deptid;//部门
	private String remarks4;//
	private Integer position;//职务
	private Integer sex;//性别
	private String telphone;//电话
	private String address;//地址
	private Integer dormitory;//
	private Integer isvalid;//是否有效
	private String remarks;//
	private String creator;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//
	private String photos;
	private String appdeviceid;//推送的设备ID
	//用户的角色id一个用户一个角色
	private String roleid;
	private String politicastatus;

	public String getPoliticastatus() {
		return politicastatus;
	}

	public void setPoliticastatus(String politicastatus) {
		this.politicastatus = politicastatus;
	}

	public String getAppdeviceid() {
		return appdeviceid;
	}

	public void setAppdeviceid(String appdeviceid) {
		this.appdeviceid = appdeviceid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {		
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginname() {		
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsernum() {		
		return usernum;
	}
	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeptid() {		
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getRemarks4() {		
		return remarks4;
	}
	public void setRemarks4(String remarks4) {
		this.remarks4 = remarks4;
	}

	public Integer getPosition() {		
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getSex() {		
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTelphone() {		
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getAddress() {		
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDormitory() {		
		return dormitory;
	}
	public void setDormitory(Integer dormitory) {
		this.dormitory = dormitory;
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

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
}
