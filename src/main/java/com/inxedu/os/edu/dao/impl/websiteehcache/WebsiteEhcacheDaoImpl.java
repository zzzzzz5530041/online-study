package com.inxedu.os.edu.dao.impl.websiteehcache;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.edu.dao.websiteehcache.WebsiteEhcacheDao;
import com.inxedu.os.edu.entity.websiteehcache.WebsiteEhcache;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 缓存管理
 * @author www.inxedu.com
 *
 */
@Repository("websiteEhcacheDao")
public class WebsiteEhcacheDaoImpl extends GenericDaoImpl implements WebsiteEhcacheDao {

	@Override
	public void addWebsiteEhcache(WebsiteEhcache websiteEhcache) {
		this.insert("WebsiteEhcacheMapper.addWebsiteEhcache", websiteEhcache);
	}

	@Override
	public List<WebsiteEhcache> queryWebsiteEhcacheList(WebsiteEhcache websiteEhcache, PageEntity page) {
		return this.queryForListPage("WebsiteEhcacheMapper.queryWebsiteEhcacheList", websiteEhcache, page);
	}

	@Override
	public Long delWebsiteEhcache(Long id) {
		return this.delete("WebsiteEhcacheMapper.delWebsiteEhcache", id);
	}

	@Override
	public WebsiteEhcache getWebsiteEhcacheById(Long id) {
		return this.selectOne("WebsiteEhcacheMapper.getWebsiteEhcacheById", id);
	}

	@Override
	public int queryWebsiteEhcacheIsExsit(String key) {
		return this.selectOne("WebsiteEhcacheMapper.queryWebsiteEhcacheIsExsit", key);
	}

	@Override
	public Long updateWebsiteEhcache(WebsiteEhcache websiteEhcache) {
		return this.update("WebsiteEhcacheMapper.updateWebsiteEhcache", websiteEhcache);
	}

}
