package com.online.edu.web.dao.praise;

import com.online.edu.web.entity.praise.Praise;

/**
 * 点赞管理接口
 *@author
 */
public interface PraiseDao {
	/**
	 * 添加点赞记录
	 */
	public Long addPraise(Praise praise);
	
	/**
	 * 根据条件查询点赞数
	 */
	public int queryPraiseCount(Praise praise);
}
