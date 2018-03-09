package com.online.edu.web.dao.impl.website;


import java.util.List;
import java.util.Map;

import com.online.edu.common.entity.PageEntity;
import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.website.WebsiteImagesDao;
import com.online.edu.web.entity.website.WebsiteImages;

/**
 *广告图Dao层实现
 *@author
 */
@Repository("websiteImagesDao")
public class WebsiteImagesDaoImpl extends GenericDaoImpl implements WebsiteImagesDao {

	@Override
	public int creasteImage(WebsiteImages image) {
		this.insert("WebsiteImagesMapper.creasteImage", image);
		return image.getImageId();
	}

	@Override
	public List<Map<String,Object>> queryImagePage(WebsiteImages image, PageEntity page) {
		return this.queryForListPage("WebsiteImagesMapper.queryImagePage", image, page);
	}

	@Override
	public WebsiteImages queryImageById(int imageId) {
		return this.selectOne("WebsiteImagesMapper.queryImageById", imageId);
	}

	@Override
	public void deleteImages(String imageIds) {
		this.delete("WebsiteImagesMapper.deleteImages", imageIds);
	}

	@Override
	public void updateImage(WebsiteImages image) {
		this.update("WebsiteImagesMapper.updateImage", image);
		
	}

	@Override
	public List<WebsiteImages> queryImagesByType() {
		return this.selectList("WebsiteImagesMapper.queryImagesByType", null);
	}
}
