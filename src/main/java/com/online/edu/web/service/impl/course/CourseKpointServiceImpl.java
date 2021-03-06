package com.online.edu.web.service.impl.course;

import com.online.edu.web.dao.course.CourseKpointDao;
import com.online.edu.web.entity.kpoint.CourseKpoint;
import com.online.edu.web.entity.kpoint.CourseKpointDto;
import com.online.edu.web.service.course.CourseKpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CourseKpoint 课程章节 管理接口
 * @author
 */
@Service("courseKpointService")
public class CourseKpointServiceImpl implements CourseKpointService {

 	@Autowired
    private CourseKpointDao courseKpointDao;

	@Override
    public int addCourseKpoint(CourseKpoint courseKpoint){
    	return courseKpointDao.addCourseKpoint(courseKpoint);
    }

	@Override
	public List<CourseKpoint> queryCourseKpointByCourseId(int courseId) {
		return courseKpointDao.queryCourseKpointByCourseId(courseId);
	}

	@Override
	public CourseKpointDto queryCourseKpointById(int kpointId) {
		return courseKpointDao.queryCourseKpointById(kpointId);
	}

	@Override
	public void updateKpoint(CourseKpoint kpoint) {
		courseKpointDao.updateKpoint(kpoint);
	}

	@Override
	public void deleteKpointByIds(String ids) {
		if(ids!=null && ids.trim().length()>0){
			if(ids.trim().endsWith(",")){
				ids = ids.trim().substring(0,ids.trim().length()-1);
			}
			courseKpointDao.deleteKpointByIds(ids);
		}
	}

	@Override
	public void updateKpointParentId(int kpointId, int parentId) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("kpointId", kpointId);
		map.put("parentId", parentId);
		courseKpointDao.updateKpointParentId(map);
		
	}


	@Override
	public int getSecondLevelKpointCount(Long courseId) {
		return courseKpointDao.getSecondLevelKpointCount(courseId);
	}
    
}