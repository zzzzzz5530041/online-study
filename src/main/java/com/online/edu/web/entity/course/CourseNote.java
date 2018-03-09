package com.online.edu.web.entity.course;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;

/**
 * @author
 *
 */
@EqualsAndHashCode(callSuper = false)
public class CourseNote implements Serializable{
    private static final long serialVersionUID = -3049530255253238206L;
    private Long id;//主键
    private Long kpointId;//节点ID
    private Long courseId;//课程id
    private Long userId;//用户ID
    private String content;//笔记内容
    private java.util.Date updateTime;//添加修改时间

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    private int status;//0公开1隐藏
}
