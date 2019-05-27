package com.huashu.pojo;

import org.hibernate.sql.Insert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_menuinfo")
public class Menuinfo implements Serializable{

	@Id
	private String id;//
	private String text;//
	private String url;//
	private Integer targetType	;//
	private String icon;//
	private String deepth;

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getTargetType() {
		return targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDeepth() {
		return deepth;
	}

	public void setDeepth(String deepth) {
		this.deepth = deepth;
	}
}
