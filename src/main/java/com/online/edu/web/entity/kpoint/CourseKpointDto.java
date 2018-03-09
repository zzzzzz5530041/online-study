package com.online.edu.web.entity.kpoint;

import lombok.EqualsAndHashCode;

/**
 * @author
 *
 */
@EqualsAndHashCode(callSuper = false)
public class CourseKpointDto extends CourseKpoint{
	private static final long serialVersionUID = -7431126492727700788L;
	private String teacherName;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
