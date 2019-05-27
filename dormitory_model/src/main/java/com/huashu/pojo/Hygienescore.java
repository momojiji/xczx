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
@Table(name="tb_hygienescore")
public class Hygienescore implements Serializable{

	@Id
	private String id;//
	private String roomid;//宿舍房间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date scoredate;//评分日期
	private String score;//分数
	private String image;//图片
	private String scoredetail;//扣分详情
	private Integer status;//状态
	private String userid;//评分人
	private java.util.Date scoretime;//评分时间
	private Integer isvalidate;//
	private String remarks;//
	private String creator;//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public java.util.Date getScoredate() {		
		return scoredate;
	}
	public void setScoredate(java.util.Date scoredate) {
		this.scoredate = scoredate;
	}

	public String getScore() {		
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public String getImage() {		
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getScoredetail() {		
		return scoredetail;
	}
	public void setScoredetail(String scoredetail) {
		this.scoredetail = scoredetail;
	}

	public Integer getStatus() {		
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserid() {		
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public java.util.Date getScoretime() {		
		return scoretime;
	}
	public void setScoretime(java.util.Date scoretime) {
		this.scoretime = scoretime;
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
