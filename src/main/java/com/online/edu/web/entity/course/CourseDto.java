package com.online.edu.web.entity.course;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 课程综合信息
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseDto extends Course implements Serializable {

	private static final long serialVersionUID = -2135258381426901010L;
	private String subjectName;
	private int recommendId;//推荐类型ID
	private List<Map<String,Object>> teacherList;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(int recommendId) {
		this.recommendId = recommendId;
	}

	public List<Map<String, Object>> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Map<String, Object>> teacherList) {
		this.teacherList = teacherList;
	}
}
