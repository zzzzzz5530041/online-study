package com.online.edu.web.entity.websiteehcache;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 缓存管理
 * @author
 *
 */
@EqualsAndHashCode(callSuper=false)
public class WebsiteEhcache implements Serializable{
	private static final long serialVersionUID = -7005793276093236257L;
	/**
	 * 
	 */

	private Long id;//主键自增
	private String ehcacheKey;//ehcache key

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEhcacheKey() {
		return ehcacheKey;
	}

	public void setEhcacheKey(String ehcacheKey) {
		this.ehcacheKey = ehcacheKey;
	}

	public String getEhcacheDesc() {
		return ehcacheDesc;
	}

	public void setEhcacheDesc(String ehcacheDesc) {
		this.ehcacheDesc = ehcacheDesc;
	}

	private String ehcacheDesc;//ehcache 描述

}
