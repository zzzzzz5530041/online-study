package com.online.edu.web.service.impl.website;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.online.edu.common.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.common.constants.CacheConstans;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.website.WebsiteCourseDetailDao;
import com.online.edu.web.entity.website.WebsiteCourseDetail;
import com.online.edu.web.entity.website.WebsiteCourseDetailDTO;
import com.online.edu.web.service.website.WebsiteCourseDetailService;

/**
 * 推荐课程关联接口实现
 * @author
 */
@Service("websiteCourseDetailService")
public class WebsiteCourseDetailServiceImpl implements WebsiteCourseDetailService {
	@Autowired
	private WebsiteCourseDetailDao websiteCourseDetailDao;
	@Autowired
	private RedisUtils redisUtils;
	@Override
	public void createWebsiteCourseDetail(String detail) {
		websiteCourseDetailDao.createWebsiteCourseDetail(detail);
		redisUtils.remove(CacheConstans.RECOMMEND_COURSE);
	}

	@Override
	public List<WebsiteCourseDetailDTO> queryCourseDetailPage(WebsiteCourseDetailDTO dto, PageEntity page) {
		return websiteCourseDetailDao.queryCourseDetailPage(dto, page);
	}

	@Override
	public void deleteDetailById(int id) {
		websiteCourseDetailDao.deleteDetailById(id);
		redisUtils.remove(CacheConstans.RECOMMEND_COURSE);
	}

	@Override
	public void updateSort(int id, int sort) {
		Map<String,Integer> map =new HashMap<String, Integer>();
		map.put("id", id);
		map.put("sort", sort);
		websiteCourseDetailDao.updateSort(map);
		redisUtils.remove(CacheConstans.RECOMMEND_COURSE);
	}

	@Override
	public List<WebsiteCourseDetail> queryDetailListByrecommendId(int recommendId) {
		return websiteCourseDetailDao.queryDetailListByrecommendId(recommendId);
	}
}