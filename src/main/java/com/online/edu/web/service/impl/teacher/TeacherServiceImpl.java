package com.online.edu.web.service.impl.teacher;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.teacher.TeacherDao;
import com.online.edu.web.entity.teacher.QueryTeacher;
import com.online.edu.web.entity.teacher.Teacher;
import com.online.edu.web.service.teacher.TeacherService;

/**
 * Teacher管理接口
 * @author
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public int addTeacher(Teacher teacher) {
		return teacherDao.addTeacher(teacher);
	}

	@Override
	public void deleteTeacherById(int tcId) {
		teacherDao.deleteTeacherById(tcId);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

	@Override
	public Teacher getTeacherById(int tcId) {
		return teacherDao.getTeacherById(tcId);
	}

	@Override
	public List<Teacher> queryTeacherListPage(QueryTeacher query, PageEntity page) {
		return teacherDao.queryTeacherListPage(query, page);
	}

	@Override
	public List<Map<String, Object>> queryCourseTeacerList(int courseId) {
		return teacherDao.queryCourseTeacerList(courseId);
	}

	@Override
	public List<Teacher> queryTeacherList(QueryTeacher queryTeacher) {
		return teacherDao.queryTeacherList(queryTeacher);
	}
}