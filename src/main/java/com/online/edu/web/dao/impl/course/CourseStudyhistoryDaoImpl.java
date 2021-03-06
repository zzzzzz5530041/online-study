package com.online.edu.web.dao.impl.course;


import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.course.CourseStudyhistoryDao;
import com.online.edu.web.entity.course.CourseStudyhistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * CourseStudyhistory 管理接口实现
 * @author
 */
 @Repository("courseStudyhistoryDao")
public class CourseStudyhistoryDaoImpl extends GenericDaoImpl implements CourseStudyhistoryDao{

    @Override
    public Long addCourseStudyhistory(CourseStudyhistory courseStudyhistory) {
        return this.insert("CourseStudyhistoryMapper.createCourseStudyhistory",courseStudyhistory);
    }

    @Override
    public void deleteCourseStudyhistoryById(Long id){
        this.delete("CourseStudyhistoryMapper.deleteCourseStudyhistoryById",id);
    }

    @Override
    public void updateCourseStudyhistory(CourseStudyhistory courseStudyhistory) {
        this.update("CourseStudyhistoryMapper.updateCourseStudyhistory",courseStudyhistory);
    }

    @Override
    public List<CourseStudyhistory> getCourseStudyhistoryList(CourseStudyhistory courseStudyhistory) {
        return this.selectList("CourseStudyhistoryMapper.getCourseStudyhistoryList",courseStudyhistory);
    }

    @Override
	public List<CourseStudyhistory> getCourseStudyhistoryListByCouId(Long courseId) {
		return this.selectList("CourseStudyhistoryMapper.getCourseStudyhistoryListByCouId", courseId);
	}

    @Override
	public int getCourseStudyhistoryCountByCouId(Long courseId) {
		return (Integer)this.selectOne("CourseStudyhistoryMapper.getCourseStudyhistoryCountByCouId", courseId);
	}
    
}
