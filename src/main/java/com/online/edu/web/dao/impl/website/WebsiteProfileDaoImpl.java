package com.online.edu.web.dao.impl.website;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.website.WebsiteProfileDao;
import com.online.edu.web.entity.website.WebsiteProfile;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 网站配置 
 * @author
 * */
 @Repository("websiteProfileDao")
public class WebsiteProfileDaoImpl extends GenericDaoImpl implements WebsiteProfileDao {

	@Override
	public WebsiteProfile getWebsiteProfileByType(String type) {
		return this.selectOne("WebsiteProfileMapper.getWebsiteProfileByType", type);
	}

	/**
	 * 添加查询网站配置
	 */
	@Override
	public void addWebsiteProfileByType(WebsiteProfile websiteProfile){
		this.insert("WebsiteProfileMapper.addWebsiteProfileByType",websiteProfile);
	}

	@Override
	public void updateWebsiteProfile(WebsiteProfile websiteProfile) {
		this.update("WebsiteProfileMapper.updateWebsiteProfile", websiteProfile);
	}

	@Override
	public List<WebsiteProfile> getWebsiteProfileList() {
		return this.selectList("WebsiteProfileMapper.getWebsiteProfileList", null);
	}

}
