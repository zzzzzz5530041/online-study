package com.online.edu.web.service.impl.course;

import com.online.edu.common.constants.CacheConstans;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.common.util.RedisUtils;
import com.online.edu.web.dao.course.CourseDao;
import com.online.edu.web.entity.course.Course;
import com.online.edu.web.entity.course.CourseDto;
import com.online.edu.web.entity.course.QueryCourse;
import com.online.edu.web.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Course 课程service接口实现
 * @author www.inxedu.com
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	@Autowired
	private RedisUtils redisUtils;
	@Override
	public int addCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@Override
	public List<CourseDto> queryCourseListPage(QueryCourse query, PageEntity page) {
		return courseDao.queryCourseListPage(query, page);
	}

	@Override
	public Course queryCourseById(int courseId) {
		return courseDao.queryCourseById(courseId);
	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

	@Override
	public void updateAvaliableCourse(int courseId, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseId", courseId);
		map.put("type", type);
		courseDao.updateAvaliableCourse(map);

	}

	@Override
	public Map<String, List<CourseDto>> queryRecommenCourseList() {
		@SuppressWarnings("unchecked")
		Map<String, List<CourseDto>> recMap = (Map<String, List<CourseDto>>) redisUtils.getByKey(CacheConstans.RECOMMEND_COURSE,Map.class);
		if (recMap == null) {
			List<CourseDto> courseList = courseDao.queryRecommenCourseList();
			if (courseList != null && courseList.size() > 0) {
				recMap = new HashMap<String, List<CourseDto>>();
				List<CourseDto> _list = new ArrayList<CourseDto>();
				int recommendId = courseList.get(0).getRecommendId();
				for (CourseDto _cd : courseList) {
					if (recommendId == _cd.getRecommendId()) {
						_list.add(_cd);
					} else {
						recMap.put("recommen_" + recommendId, _list);
						_list = new ArrayList<CourseDto>();
						_list.add(_cd);
					}
					recommendId = _cd.getRecommendId();
				}
				recMap.put("recommen_" + recommendId, _list);
				redisUtils.saveWithExpireTime(CacheConstans.RECOMMEND_COURSE, recMap, Long.valueOf(CacheConstans.RECOMMEND_COURSE_TIME));
			}
		}
		return recMap;
	}

	@Override
	public List<CourseDto> queryCourseList(QueryCourse query) {
		return courseDao.queryCourseList(query);
	}

	@Override
	public List<CourseDto> queryWebCourseListPage(QueryCourse queryCourse, PageEntity page) {
		return courseDao.queryWebCourseListPage(queryCourse, page);
	}

	@Override
	public List<CourseDto> queryInterfixCourseLis(int subjectId, int count, int courseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("subjectId", subjectId);
		map.put("courseId", courseId);
		return courseDao.queryInterfixCourseList(map);
	}

	@Override
	public List<CourseDto> queryMyCourseList(int userId, PageEntity page) {
		return courseDao.queryMyCourseList(userId, page);
	}

	@Override
	public int queryAllCourseCount() {
		return courseDao.queryAllCourseCount();
	}

	@Override
	public List<Map<String, Object>> queryMyCourseListByMap(int userId, int count) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("count", count);
		return courseDao.queryMyCourseListByMap(map);
	}

	@Override
	public List<CourseDto> queryRecommenCourseListByRecommendId(Long recommendId, Long count) {
		return courseDao.queryRecommenCourseListByRecommendId(recommendId, count);
	}

	@Override
	public List<CourseDto> queryCourse(QueryCourse queryCourse) {
		return courseDao.queryCourse(queryCourse);
	}

	/**
	 * 更新课程数据（浏览数，购买数）
	 * @param type pageViewcount浏览数 pageBuycount购买数
	 * @param courseId 课程id
	 */
	@Override
	public void updateCourseCount(String type,int courseId){
		this.courseDao.updateCourseCount(type,courseId);
	}
}