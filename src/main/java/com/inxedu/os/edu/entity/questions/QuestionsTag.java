package com.inxedu.os.edu.entity.questions;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 问答标签
 *@author www.inxedu.com
 */
@EqualsAndHashCode(callSuper = false)
public class QuestionsTag implements Serializable {
    private static final long serialVersionUID = 2570227194388944051L;
    private int questionsTagId; // 专业id
    private String questionsTagName;// 专业名称
    private int status;// 状态
    private Date createTime;// 创建时间

    public int getQuestionsTagId() {
        return questionsTagId;
    }

    public void setQuestionsTagId(int questionsTagId) {
        this.questionsTagId = questionsTagId;
    }

    public String getQuestionsTagName() {
        return questionsTagName;
    }

    public void setQuestionsTagName(String questionsTagName) {
        this.questionsTagName = questionsTagName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    private int parentId;// 父节点
}
