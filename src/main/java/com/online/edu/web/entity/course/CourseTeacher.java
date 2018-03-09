package com.online.edu.web.entity.course;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

/**
 * @author
 *
 */
@EqualsAndHashCode(callSuper = false)
public class CourseTeacher implements Serializable{
    private static final long serialVersionUID = -434641700702120795L;
    private int id;
    private Integer courseId;
    private Integer teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
