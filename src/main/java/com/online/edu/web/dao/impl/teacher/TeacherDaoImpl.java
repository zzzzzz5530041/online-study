package com.online.edu.web.dao.impl.teacher;


import java.util.List;
import java.util.Map;

import com.online.edu.common.entity.PageEntity;
import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.teacher.TeacherDao;
import com.online.edu.web.entity.teacher.QueryTeacher;
import com.online.edu.web.entity.teacher.Teacher;

/**
 * 教师dao层
 * @author www.inxedu.com
 */
@Repository("teacherDao")
public class TeacherDaoImpl extends GenericDaoImpl implements TeacherDao {

	@Override
	public int addTeacher(Teacher teacher) {
		this.insert("TeacherMapper.createTeacher", teacher);
		return teacher.getId();
	}

	@Override
	public void deleteTeacherById(int tcId) {
		this.update("TeacherMapper.deleteTeacherById", tcId);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		this.update("TeacherMapper.updateTeacher", teacher);
		
	}

	@Override
	public Teacher getTeacherById(int tcId) {
		return this.selectOne("TeacherMapper.getTeacherById", tcId);
	}

	@Override
	public List<Teacher> queryTeacherListPage(QueryTeacher query, PageEntity page) {
		return this.queryForListPageCount("TeacherMapper.queryTeacherListPage", query, page);
	}

	@Override
	public List<Map<String, Object>> queryCourseTeacerList(int courseId) {
		return this.selectList("TeacherMapper.queryCourseTeacerList", courseId);
	}

	@Override
	public List<Teacher> queryTeacherList(QueryTeacher queryTeacher) {
		return this.selectList("TeacherMapper.queryTeacherList", queryTeacher);
	}
}
