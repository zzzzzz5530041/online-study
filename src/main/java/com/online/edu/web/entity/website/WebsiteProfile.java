package com.online.edu.web.entity.website;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 网站配置实体
 * @author
 */
@EqualsAndHashCode(callSuper = false)
public class WebsiteProfile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6689726203603217717L;
	private int id;
	private String type;//类型
	private String desciption;//描述内容JSON格式

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	private String explain;//说明
}
