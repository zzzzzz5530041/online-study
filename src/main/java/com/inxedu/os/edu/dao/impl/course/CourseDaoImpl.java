package com.inxedu.os.edu.dao.impl.course;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.edu.dao.course.CourseDao;
import com.inxedu.os.edu.entity.course.Course;
import com.inxedu.os.edu.entity.course.CourseDto;
import com.inxedu.os.edu.entity.course.QueryCourse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author www.inxedu.com
 *
 */
@Repository("courseDao")
public class CourseDaoImpl extends GenericDaoImpl implements CourseDao {

	@Override
	public int addCourse(Course course) {
		this.insert("CourseMapper.createCourse", course);
		return course.getCourseId();
	}

	@Override
	public List<CourseDto> queryCourseListPage(QueryCourse query, PageEntity page) {
		return this.queryForListPage("CourseMapper.queryCourseListPage", query, page);
	}

	@Override
	public Course queryCourseById(int courseId) {
		return this.selectOne("CourseMapper.queryCourseById", courseId);
	}

	@Override
	public void updateCourse(Course course) {
		this.update("CourseMapper.updateCourse", course);
	}

	@Override
	public void updateAvaliableCourse(Map<String, Object> map) {
		this.update("CourseMapper.updateAvaliableCourse", map);
	}

	@Override
	public List<CourseDto> queryRecommenCourseList() {
		return this.selectList("CourseMapper.queryRecommenCourseList", null);
	}

	@Override
	public List<CourseDto> queryCourseList(QueryCourse query) {
		return this.selectList("CourseMapper.queryCourseList", query);
	}

	@Override
	public List<CourseDto> queryWebCourseListPage(QueryCourse queryCourse,PageEntity page) {
		return this.queryForListPage("CourseMapper.queryWebCourseListPage", queryCourse, page);
	}

	@Override
	public List<CourseDto> queryInterfixCourseList(Map<String, Object> map) {
		return this.selectList("CourseMapper.queryInterfixCourseList", map);
	}

	@Override
	public List<CourseDto> queryMyCourseList(int userId, PageEntity page) {
		return this.queryForListPage("CourseMapper.queryMyCourseList", userId, page);
	}

	@Override
	public int queryAllCourseCount() {
		return this.selectOne("CourseMapper.queryAllCourseCount", null);
	}

	@Override
	public List<Map<String, Object>> queryMyCourseListByMap(Map<String, Object> map) {
		return this.selectList("CourseMapper.queryMyCourseListByMap", map);
	}

	@Override
	public List<CourseDto> queryRecommenCourseListByRecommendId(Long recommendId, Long count) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("recommendId", recommendId);
		map.put("count", count);
		return selectList("CourseMapper.queryRecommenCourseListByRecommendId", map);
	}

	@Override
	public List<CourseDto> queryCourse(QueryCourse queryCourse) {
		return selectList("CourseMapper.queryCourse", queryCourse);
	}

	/**
	 * 更新课程数据（浏览数，购买数）
	 * @param type pageViewcount浏览数 pageBuycount购买数
	 * @param courseId 课程id
	 */
	@Override
	public void updateCourseCount(String type,int courseId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);// 类型
		map.put("courseId", courseId);// 课程id
		this.update("CourseMapper.updateCourseCount", map);
	}
	

}
