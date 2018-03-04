package com.online.edu.web.entity.praise;

import java.io.Serializable;
import java.util.Date;

/**
 * 点赞表
 *@author www.inxedu.com
 */
public class Praise  implements Serializable{
	private static final long serialVersionUID = -6193393378585119763L;
	private Long id;//id
	private Long userId;//用户id
	private Long targetId;//点赞的目标id
	private int type;//点赞类型 1问答点赞 2问答评论点赞

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	private Date addTime;//点赞和点踩的时间

}
