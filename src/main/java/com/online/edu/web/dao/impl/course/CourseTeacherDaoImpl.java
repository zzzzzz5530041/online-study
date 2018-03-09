package com.online.edu.web.dao.impl.course;


import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.course.CourseTeacherDao;

/**
 * @author
 *
 */
@Repository("courseTeacherDao")
public class CourseTeacherDaoImpl extends GenericDaoImpl implements CourseTeacherDao {

	@Override
	public void addCourseTeacher(String value) {
		this.insert("CourseTeacherMapper.createCourseTeacher", value);
	}

	@Override
	public void deleteCourseTeacher(int courseId) {
		this.delete("CourseTeacherMapper.deleteCourseTeacher", courseId);
	}

}
