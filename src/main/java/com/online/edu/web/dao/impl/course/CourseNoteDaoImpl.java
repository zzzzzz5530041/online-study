package com.online.edu.web.dao.impl.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.common.util.ObjectUtils;
import com.online.edu.web.dao.course.CourseNoteDao;
import com.online.edu.web.entity.course.CourseNote;
import com.online.edu.web.entity.course.QueryCourseNote;

/**
 * 
 * CourseNoteDao接口实现类
 * @author www.inxedu.com
 */
@Repository("courseNoteDao")
public class CourseNoteDaoImpl extends GenericDaoImpl implements CourseNoteDao {
	/**
	 * 添加CourseNote
	 * 
	 * @param courseNote
	 *            要添加的CourseNote
	 * @return id
	 */
	@Override
	public Long addCourseNote(CourseNote courseNote) {
		return this.insert("CourseNoteMapper.createCourseNote", courseNote);
	}

	/**
	 * 根据id删除一个CourseNote
	 * 
	 * @param id
	 *            要删除的id
	 */
	@Override
	public void deleteCourseNoteById(Long id) {
		this.delete("CourseNoteMapper.deleteCourseNoteById", id);
	}

	/**
	 * 修改CourseNote
	 * 
	 * @param courseNote
	 *            要修改的CourseNote
	 */
	@Override
	public void updateCourseNote(CourseNote courseNote) {
		this.update("CourseNoteMapper.updateCourseNote", courseNote);
	}

	/**
	 * 根据id获取单个CourseNote对象
	 * 
	 * @param id
	 *            要查询的id
	 * @return CourseNote
	 */
	@Override
	public CourseNote getCourseNoteById(Long id) {
		return this.selectOne("CourseNoteMapper.getCourseNoteById", id);
	}

	/**
	 * 根据用户id和节点id查询笔记
	 * 
	 * @return CourseNote
	 */
	@Override
	public CourseNote getCourseNoteByKpointIdAndUserId(Long kpointId, Long userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kpointId", kpointId);
		map.put("userId", userId);
		List<CourseNote> courseNoteList = this.selectList("CourseNoteMapper.getCourseNoteByKpointIdAndUserId", map);
		// 如果返回为多个只取第一个
		if (ObjectUtils.isNotNull(courseNoteList) && courseNoteList.size() > 0) {
			return courseNoteList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 根据条件获取CourseNote列表
	 * 
	 * @param courseNote
	 *            查询条件
	 * @return List<CourseNote>
	 */
	@Override
	public List<CourseNote> getCourseNoteList(CourseNote courseNote) {
		return this.selectList("CourseNoteMapper.getCourseNoteList", courseNote);
	}

	/**
	 * 查询笔记 分页
	 * 
	 * @param queryCourseNote
	 * @param page
	 * @return
	 */
	@Override
	public List<QueryCourseNote> getCourseNoteListPage(QueryCourseNote queryCourseNote, PageEntity page) {
		return this.queryForListPage("CourseNoteMapper.getCourseNoteListPage", queryCourseNote, page);
	}
	/**
	 * 更新显示隐藏
	 * 
	 * @param courseNote
	 */
	@Override
	public void updateCourseNoteListStatus(CourseNote courseNote) {
		this.update("CourseNoteMapper.updateCourseNoteListStatus", courseNote);
	}
	/**
	 * 查询 QueryCourseNote
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public QueryCourseNote getQueryCourseNoteById(Long id) {
		return this.selectOne("CourseNoteMapper.getQueryCourseNoteById", id);
	}
	/**
	 * 查询用户笔记
	 * 
	 * @param userId
	 * @param page
	 * @return
	 */
	@Override
	public List<QueryCourseNote> getUserCourseNoteByUserId(Long userId, PageEntity page) {
		return this.queryForListPage("CourseNoteMapper.getUserCourseNoteByUserId", userId, page);
	}
}
