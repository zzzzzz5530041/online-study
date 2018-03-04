package com.online.edu.web.entity.course;

import java.io.Serializable;
import java.util.Date;

import com.online.edu.common.util.StringUtils;
import com.online.edu.common.util.WebUtils;

import lombok.EqualsAndHashCode;

/**
 * 
 * @ClassName com.online.edu.edu.entity.course.QueryCourseNote
 * @description
 * @author www.inxedu.com
 */
@EqualsAndHashCode(callSuper = false)
public class QueryCourseNote implements Serializable {
	private static final long serialVersionUID = 2999601459555052895L;
	private Long id;// id
	private Long kpointId;// 节点id
	private Long userId;// 用户id
	private String content;// 笔记内容
	private java.util.Date updateTime;// 修改时间
	private int status;//状态 0显示 1隐藏
	private String nickname;//用戶名
	private String email;//邮箱
	private String keyword;//关键字
	private String pointName;//节点名
	private String startDate;//开始时间
	private String endDate;//结束时间
	private String shortContent;
	private Long courseId;//课程id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKpointId() {
		return kpointId;
	}

	public void setKpointId(Long kpointId) {
		this.kpointId = kpointId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	private String courseName;//课程名字
	
	public String getShortContent(){
		//去除html
		shortContent=WebUtils.replaceTagHTML(content);
		//截取50个字
		shortContent = StringUtils.getLength(shortContent, 50);
		return shortContent;
	}
}
