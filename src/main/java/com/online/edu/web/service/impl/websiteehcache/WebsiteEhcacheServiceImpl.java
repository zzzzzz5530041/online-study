package com.online.edu.web.service.impl.websiteehcache;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.websiteehcache.WebsiteEhcacheDao;
import com.online.edu.web.entity.websiteehcache.WebsiteEhcache;
import com.online.edu.web.service.websiteehcache.WebsiteEhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 缓存管理
 * @author
 *
 */
@Service("websiteEhcacheService")
public class WebsiteEhcacheServiceImpl implements WebsiteEhcacheService {
	
	@Autowired
	private WebsiteEhcacheDao websiteEhcacheDao;

	@Override
	public void addWebsiteEhcache(WebsiteEhcache websiteEhcache) {
		websiteEhcacheDao.addWebsiteEhcache(websiteEhcache);
	}
	
	@Override
	public List<WebsiteEhcache> queryWebsiteEhcacheList(WebsiteEhcache websiteEhcache, PageEntity page) {
		return websiteEhcacheDao.queryWebsiteEhcacheList(websiteEhcache, page);
	}

	@Override
	public Long delWebsiteEhcache(Long id) {
		return websiteEhcacheDao.delWebsiteEhcache(id);
	}

	@Override
	public WebsiteEhcache getWebsiteEhcacheById(Long id) {
		return websiteEhcacheDao.getWebsiteEhcacheById(id);
	}

	@Override
	public boolean queryWebsiteEhcacheIsExsit(String key) {
		if(websiteEhcacheDao.queryWebsiteEhcacheIsExsit(key)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Long updateWebsiteEhcache(WebsiteEhcache websiteEhcache) {
		return websiteEhcacheDao.updateWebsiteEhcache(websiteEhcache);
	}

}
