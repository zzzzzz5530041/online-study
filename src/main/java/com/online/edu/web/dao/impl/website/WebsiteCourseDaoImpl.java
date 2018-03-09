package com.online.edu.web.dao.impl.website;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.website.WebsiteCourseDao;
import com.online.edu.web.entity.website.WebsiteCourse;

/**
 * 推荐课程分类
 * @author
 */
 @Repository("websiteCourseDao")
public class WebsiteCourseDaoImpl extends GenericDaoImpl implements WebsiteCourseDao {
    /**
     * 推荐课程分类列表
     */
    @Override
    public List<WebsiteCourse> queryWebsiteCourseList(){
    	return this.selectList("WebsiteCourseMapper.queryWebsiteCourseList",0);
    }
    /**
     * 查询推荐课程分类
     */
    @Override
    public WebsiteCourse queryWebsiteCourseById(int id){
    	return this.selectOne("WebsiteCourseMapper.getWebsiteCourseById", id);
    }
    /**
     * 修改推荐课程分类
     */
    @Override
    public void updateWebsiteCourseById(WebsiteCourse websiteCourse){
    	this.update("WebsiteCourseMapper.updateWebsiteCourse", websiteCourse);
    }
    /**
     * 添加推荐课程分类
     */
    @Override
    public void addWebsiteCourse(WebsiteCourse websiteCourse){
    	this.insert("WebsiteCourseMapper.createWebsiteCourse", websiteCourse);
    }
    /**
     * 删除推荐课程分类及分类下推荐课程
     */
    @Override
    public void deleteWebsiteCourseDetailById(int id){
    	this.delete("WebsiteCourseMapper.deleteWebsiteCourseById", id);
    	this.delete("WebsiteCourseDetailMapper.delWebsiteCourseDetails", id);
    }
}
