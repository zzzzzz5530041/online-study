package com.online.edu.web.service.impl.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.web.dao.website.WebsiteCourseDao;
import com.online.edu.web.entity.website.WebsiteCourse;
import com.online.edu.web.service.website.WebsiteCourseService;

/**
 * 推荐课程分类管理接口
 * @author
 */
@Service("websiteCourseService")
public class WebsiteCourseServiceImpl implements WebsiteCourseService {
	@Autowired
	private WebsiteCourseDao websiteCourseDao;
	 /**
     * 推荐课程分类列表
     */
     @Override
    public List<WebsiteCourse> queryWebsiteCourseList(){
    	return websiteCourseDao.queryWebsiteCourseList();
    }
    /**
     * 查询推荐课程分类
     */
    @Override
    public WebsiteCourse queryWebsiteCourseById(int id){
    	return websiteCourseDao.queryWebsiteCourseById(id);
    }
    /**
     * 修改推荐课程分类
     */
    @Override
    public void updateWebsiteCourseById(WebsiteCourse websiteCourse){
    	websiteCourseDao.updateWebsiteCourseById(websiteCourse);
    }
    /**
     * 添加推荐课程分类
     */
    @Override
    public void addWebsiteCourse(WebsiteCourse websiteCourse){
    	websiteCourseDao.addWebsiteCourse(websiteCourse);
    }
    /**
     * 删除推荐课程分类及分类下推荐课程
     */
    @Override
    public void deleteWebsiteCourseDetailById(int id){
    	websiteCourseDao.deleteWebsiteCourseDetailById(id);
    }
}