package com.huashu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_workorder")
public class Workorder implements Serializable{

	@Id
	private String id;//
	private String ordername;//
	private String ordernum;//
	private String ordertype;//
	private String position;//

	@ManyToOne(targetEntity = Student.class,optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "userid",referencedColumnName = "id")
	private Student student;//

	private String repairname;//
	private String usertel;//
	private String repairtel;//

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String checkindate;//
	private Integer status;//
	private String imgurl;//

	@ManyToOne(targetEntity = Room.class, optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "roomnum",referencedColumnName ="id" )
	private Room  room;//

	@ManyToOne(targetEntity = Dormitory.class,optional = false,fetch =FetchType.EAGER )
	@JoinColumn(name = "dormtioryid")
	private Dormitory dormitory;//

	private Integer isvalidate;//
	private String attention;//
	private String remarks;//
	private String creator;//
	private java.util.Date createdate;//
	private String modifitor;//
	private java.util.Date modifiedate;//
	private Integer isartificial;//

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@ManyToOne(targetEntity = Classinfo.class,optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "classinfoid",referencedColumnName = "id")
	private Classinfo classinfo;

	public Classinfo getClassinfo() {
		return classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public Integer getIsartificial() {
		return isartificial;
	}

	public void setIsartificial(Integer isartificial) {
		this.isartificial = isartificial;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getOrdername() {		
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getOrdernum() {		
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getOrdertype() {		
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getPosition() {		
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getRepairname() {
		return repairname;
	}
	public void setRepairname(String repairname) {
		this.repairname = repairname;
	}

	public String getUsertel() {		
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getRepairtel() {		
		return repairtel;
	}
	public void setRepairtel(String repairtel) {
		this.repairtel = repairtel;
	}

	public String getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImgurl() {		
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Dormitory getDormitory() {
		return dormitory;
	}

	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}


	public Integer getIsvalidate() {
		return isvalidate;
	}

	public void setIsvalidate(Integer isvalidate) {
		this.isvalidate = isvalidate;
	}

	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
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
