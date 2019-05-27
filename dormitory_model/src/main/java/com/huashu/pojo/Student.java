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
@Table(name="tb_student")
public class Student implements Serializable{

	@Id
	private String id;//
	private String studentname;//学生名称
	private String studentnum;//学生学号
	private String collegecode;//入学年份
	private String idaddress;//户籍地址
	private String idcard;//身份证号
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;//出生日期
	private String idcardfront;//身份证正
	private String idcardback;//身份证反
	private String politicaloutlook;//政治面貌
	private String homeaddress;//家庭地址
	private String hometel;//家庭电话
	private String personphone;// 	人像识别
	private String studenttel;//学生手机号
	private String password;//密码
	private String classid;//classid
	private Integer sex;//性别
	private String namedbefore;//曾用名
	private String namecode;//姓名拼音
	private String examnum;//考生号
	private String collegeid;//院系/部
	private String majornum;//专业代码
	private String majorid;//专业ID
	private String direction;//专业方向
	private String disciplines;//学科大类
	private String subject;//学科
	private String internationalcode;//国际专业代码
	private String professionallevel;//专业培养层次
	private Integer presentage;//现在年纪
	private Integer status;//学生状态  0:正常上课 ，1： 请假 ，2 ：旷课
	private Integer isvalidate;//是否有效
	private Integer logincount;
	private String appdeviceid;//推送的设备ID
	private String remarks;//
	private String creator;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createdate;//
	private String modifitor;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date modifiedate;//
	private String booklogo;//通讯录默认图片
	private String photo;

	public String getBooklogo() {
		return booklogo;
	}

	public void setBooklogo(String booklogo) {
		this.booklogo = booklogo;
	}

	public String getAppdeviceid() {
		return appdeviceid;
	}

	public void setAppdeviceid(String appdeviceid) {
		this.appdeviceid = appdeviceid;
	}

	public Integer getLogincount() {
		return logincount;
	}

	public void setLogincount(Integer logincount) {
		this.logincount = logincount;
	}

	public String getStudenttel() {
		return studenttel;
	}

	public void setStudenttel(String studenttel) {
		this.studenttel = studenttel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getStudentname() {		
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentnum() {		
		return studentnum;
	}
	public void setStudentnum(String studentnum) {
		this.studentnum = studentnum;
	}

	public String getCollegecode() {		
		return collegecode;
	}
	public void setCollegecode(String collegecode) {
		this.collegecode = collegecode;
	}

	public String getClassid() {		
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}

	public Integer getSex() {		
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getNamedbefore() {		
		return namedbefore;
	}
	public void setNamedbefore(String namedbefore) {
		this.namedbefore = namedbefore;
	}

	public String getNamecode() {
		return namecode;
	}

	public void setNamecode(String namecode) {
		this.namecode = namecode;
	}

	public String getExamnum() {
		return examnum;
	}
	public void setExamnum(String examnum) {
		this.examnum = examnum;
	}

	public String getCollegeid() {		
		return collegeid;
	}
	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getMajornum() {		
		return majornum;
	}
	public void setMajornum(String majornum) {
		this.majornum = majornum;
	}

	public String getMajorid() {		
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
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

	public Integer getPresentage() {		
		return presentage;
	}
	public void setPresentage(Integer presentage) {
		this.presentage = presentage;
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

	public String getIdaddress() {
		return idaddress;
	}

	public void setIdaddress(String idaddress) {
		this.idaddress = idaddress;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdcardfront() {
		return idcardfront;
	}

	public void setIdcardfront(String idcardfront) {
		this.idcardfront = idcardfront;
	}

	public String getIdcardback() {
		return idcardback;
	}

	public void setIdcardback(String idcardback) {
		this.idcardback = idcardback;
	}

	public String getPoliticaloutlook() {
		return politicaloutlook;
	}

	public void setPoliticaloutlook(String politicaloutlook) {
		this.politicaloutlook = politicaloutlook;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getHometel() {
		return hometel;
	}

	public void setHometel(String hometel) {
		this.hometel = hometel;
	}

	public String getPersonphone() {
		return personphone;
	}

	public void setPersonphone(String personphone) {
		this.personphone = personphone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
