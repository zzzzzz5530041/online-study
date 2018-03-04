package com.online.edu.web.entity.help;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;



/**
 * 帮助菜单
 * @author http://www.inxedu.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HelpMenu implements Serializable{


	private static final long serialVersionUID = 8155213718558768429L;
	private Long id;
	/**
	 * 默认0一级菜单，非0二级菜单
	 */
	private Long parentId;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 菜单内容
	 */
	private String content;
	/**
	 * 排序
	 */
	private String sort;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getLinkBuilding() {
		return linkBuilding;
	}

	public void setLinkBuilding(String linkBuilding) {
		this.linkBuilding = linkBuilding;
	}

	private String linkBuilding; // 外链
}

