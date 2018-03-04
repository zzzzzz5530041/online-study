package com.online.edu.web.service.impl.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.edu.web.dao.website.WebSiteImagesTypeDao;
import com.online.edu.web.entity.website.WebSiteImagesType;
import com.online.edu.web.service.website.WebSiteImagesTypeService;

/**
 * @author www.inxedu.com
 *
 */
@Service("webSiteImagesTypeService")
public class WebSiteImagesTypeServiceImpl implements WebSiteImagesTypeService{
	
	@Autowired
	private WebSiteImagesTypeDao webSiteImagesTypeDao;

	@Override
	public int createImageType(WebSiteImagesType type) {
		return webSiteImagesTypeDao.createImageType(type);
	}

	@Override
	public List<WebSiteImagesType> queryAllTypeList() {
		return webSiteImagesTypeDao.queryAllTypeList();
	}

	@Override
	public void deleteTypeById(int typeId) {
		webSiteImagesTypeDao.deleteTypeById(typeId);
	}

	@Override
	public void updateType(WebSiteImagesType type) {
		webSiteImagesTypeDao.updateType(type);
	}

}
