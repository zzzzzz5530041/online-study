package com.online.edu.web.service.impl.course;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.course.CourseFavoritesDao;
import com.online.edu.web.entity.course.CourseFavorites;
import com.online.edu.web.entity.course.FavouriteCourseDTO;
import com.online.edu.web.service.course.CourseFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CourseFavorites 课程收藏 管理接口
 * @author www.inxedu.com
 */
@Service("courseFavoritesService")
public class CourseFavoritesServiceImpl implements CourseFavoritesService {

	@Autowired
	private CourseFavoritesDao courseFavoritesDao;

	@Override
	public void createCourseFavorites(CourseFavorites cf) {
		courseFavoritesDao.createCourseFavorites(cf);
	}

	@Override
	public void deleteCourseFavoritesById(String ids) {
		courseFavoritesDao.deleteCourseFavoritesById(ids);
	}

	@Override
	public boolean checkFavorites(int userId, int courseId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("courseId", courseId);
		int count = courseFavoritesDao.checkFavorites(map);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<FavouriteCourseDTO> queryFavoritesPage(int userId,PageEntity page) {
		return courseFavoritesDao.queryFavoritesPage(userId, page);
	}
    

}