package com.online.edu.web.dao.impl.website;


import java.util.List;
import java.util.Map;

import com.online.edu.common.entity.PageEntity;
import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.website.WebsiteCourseDetailDao;
import com.online.edu.web.entity.website.WebsiteCourseDetail;
import com.online.edu.web.entity.website.WebsiteCourseDetailDTO;

/**
 *
 * 推荐课程关联Dao层
 * @author
 */
 @Repository("websiteCourseDetailDao")
public class WebsiteCourseDetailDaoImpl extends GenericDaoImpl implements WebsiteCourseDetailDao {

	@Override
	public void createWebsiteCourseDetail(String detail) {
		this.insert("WebsiteCourseDetailMapper.createWebsiteCourseDetail", detail);
	}

	@Override
	public List<WebsiteCourseDetailDTO> queryCourseDetailPage(WebsiteCourseDetailDTO dto, PageEntity page) {
		return this.queryForListPage("WebsiteCourseDetailMapper.queryCourseDetailPage", dto, page);
	}

	@Override
	public void deleteDetailById(int id) {
		this.delete("WebsiteCourseDetailMapper.deleteDetailById", id);
	}

	@Override
	public void updateSort(Map<String, Integer> map) {
		this.update("WebsiteCourseDetailMapper.updateSort", map);
	}

	@Override
	public List<WebsiteCourseDetail> queryDetailListByrecommendId(int recommendId) {
		return this.selectList("WebsiteCourseDetailMapper.queryDetailListByrecommendId", recommendId);
	}
}
