package com.online.edu.web.entity.questions;

import java.io.Serializable;

/**
 * 问答和 问答标签的 关联表
 *@author www.inxedu.com
 */
public class QuestionsTagRelation implements Serializable{
	private static final long serialVersionUID = -4217124954438325439L;
	private Long id;//id
	private Long questionsId;//问答id
	private Long questionsTagId;//问答标签id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionsId() {
		return questionsId;
	}

	public void setQuestionsId(Long questionsId) {
		this.questionsId = questionsId;
	}

	public Long getQuestionsTagId() {
		return questionsTagId;
	}

	public void setQuestionsTagId(Long questionsTagId) {
		this.questionsTagId = questionsTagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	private String tagName;//问答标签名
}
