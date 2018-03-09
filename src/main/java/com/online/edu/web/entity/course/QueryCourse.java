package com.online.edu.web.entity.course;

import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * 课程查询条件
 */
@EqualsAndHashCode(callSuper = false)
public class QueryCourse implements Serializable {

    private static final long serialVersionUID = 845460823521077682L;
    private int subjectId;
    private String courseName;
    private int isavaliable;
    private int teacherId;
    private int count;
    private String order;
    private String isFree;//查询免费课程
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date beginCreateTime;//查询 开始添加时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endCreateTime;//查询 结束添加时间

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getIsavaliable() {
        return isavaliable;
    }

    public void setIsavaliable(int isavaliable) {
        this.isavaliable = isavaliable;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public int getQueryLimit() {
        return queryLimit;
    }

    public void setQueryLimit(int queryLimit) {
        this.queryLimit = queryLimit;
    }

    private int queryLimit;//查询条数
}
