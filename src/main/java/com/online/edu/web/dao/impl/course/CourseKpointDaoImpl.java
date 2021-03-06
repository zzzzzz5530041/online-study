package com.online.edu.web.dao.impl.course;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.course.CourseKpointDao;
import com.online.edu.web.entity.kpoint.CourseKpoint;
import com.online.edu.web.entity.kpoint.CourseKpointDto;

import lombok.ToString;

/**
 *
 * CourseKpoint
 * @author
 */
 @ToString
 @Repository("courseKpointDao")
public class CourseKpointDaoImpl extends GenericDaoImpl implements CourseKpointDao {

	@Override
    public int addCourseKpoint(CourseKpoint courseKpoint) {
    	this.insert("CourseKpointMapper.createCourseKpoint",courseKpoint);
        return courseKpoint.getKpointId();
    }

	@Override
	public List<CourseKpoint> queryCourseKpointByCourseId(int courseId) {
		return this.selectList("CourseKpointMapper.queryCourseKpointByCourseId", courseId);
	}

	@Override
	public CourseKpointDto queryCourseKpointById(int kpointId) {
		return this.selectOne("CourseKpointMapper.queryCourseKpointById", kpointId);
	}

	@Override
	public void updateKpoint(CourseKpoint kpoint) {
		this.update("CourseKpointMapper.updateKpoint", kpoint);
		
	}

	@Override
	public void deleteKpointByIds(String ids) {
		this.delete("CourseKpointMapper.deleteKpointByIds", ids);
		
	}

	@Override
	public void updateKpointParentId(Map<String, Integer> map) {
		this.update("CourseKpointMapper.updateKpointParentId", map);
	}


	@Override
	public int getSecondLevelKpointCount(Long courseId) {
		return this.selectOne("CourseKpointMapper.getSecondLevelKpointCount", courseId);
	}

}
