package com.online.edu.web.service.impl.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.web.dao.course.CourseTeacherDao;
import com.online.edu.web.service.course.CourseTeacherService;

/**
 * CourseTeacher管理接口
 * @author www.inxedu.com
 */
@Service("courseTeacherService")
public class CourseTeacherServiceImpl implements CourseTeacherService {

 	@Autowired
    private CourseTeacherDao courseTeacherDao;

	@Override
	public void addCourseTeacher(String value) {
		courseTeacherDao.addCourseTeacher(value);
	}

	@Override
	public void deleteCourseTeacher(int courseId) {
		courseTeacherDao.deleteCourseTeacher(courseId);
	}
}