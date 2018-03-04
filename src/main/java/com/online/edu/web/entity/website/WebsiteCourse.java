package com.online.edu.web.entity.website;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 推荐分类
 * @author www.inxedu.com
 */
@EqualsAndHashCode(callSuper = false)
public class WebsiteCourse implements Serializable {

	private int id;// 分类id
	private String name;//分类名称
	private String link;//更多链接
	private String description;//详细描述

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	private int courseNum;//数量限制
}
