package com.online.edu.web.dao.impl.website;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.website.WebSiteImagesTypeDao;
import com.online.edu.web.entity.website.WebSiteImagesType;

/**
 * @author
 *
 */
@Repository("webSiteImagesTypeDao")
public class WebSiteImagesTypeDaoImpl extends GenericDaoImpl implements WebSiteImagesTypeDao{

	@Override
	public int createImageType(WebSiteImagesType type) {
		this.insert("WebSiteImagesTypeMapper.createImageType", type);
		return type.getTypeId();
	}

	@Override
	public List<WebSiteImagesType> queryAllTypeList() {
		return this.selectList("WebSiteImagesTypeMapper.queryAllTypeList", null);
	}

	@Override
	public void deleteTypeById(int typeId) {
		this.delete("WebSiteImagesTypeMapper.deleteTypeById", typeId);
	}

	@Override
	public void updateType(WebSiteImagesType type) {
		this.update("WebSiteImagesTypeMapper.updateType", type);
	}

}
