package com.online.edu.web.dao.impl.website;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.website.WebsiteNavigateDao;
import com.online.edu.web.entity.website.WebsiteNavigate;

/**
 * 网站导航dao
 * @author
 */
@Repository("websiteNavigateDao")
public class WebsiteNavigateDaoImpl extends GenericDaoImpl implements WebsiteNavigateDao {

	@Override
	public List<WebsiteNavigate> getWebsiteNavigate(WebsiteNavigate websiteNavigate){
		return this.selectList("WebsiteNavigateMapper.getWebsiteNavigate", websiteNavigate);
	}

	@Override
	public void addWebsiteNavigate(WebsiteNavigate websiteNavigate){
		this.insert("WebsiteNavigateMapper.createWebsiteNavigate", websiteNavigate);
	}

	@Override
	public void freezeWebsiteNavigate(WebsiteNavigate websiteNavigate){
		this.update("WebsiteNavigateMapper.freezeWebsiteNavigate", websiteNavigate);
	}

	@Override
	public void delWebsiteNavigate(int id){
		this.delete("WebsiteNavigateMapper.delWebsiteNavigate",id);
	}

	@Override
	public void updateWebsiteNavigate(WebsiteNavigate websiteNavigate){
		this.update("WebsiteNavigateMapper.updateWebsiteNavigate", websiteNavigate);
	}

	@Override
	public WebsiteNavigate getWebsiteNavigateById(int id){
		return this.selectOne("WebsiteNavigateMapper.getWebsiteNavigateById", id);
	}

	@Override
	public List<WebsiteNavigate> getWebNavigate(){
		return this.selectList("WebsiteNavigateMapper.getWebNavigate",0);
	}

}
