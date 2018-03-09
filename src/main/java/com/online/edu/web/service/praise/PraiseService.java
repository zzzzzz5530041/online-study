package com.online.edu.web.service.praise;

import com.online.edu.web.entity.praise.Praise;

/**
 * 点赞服务接口
 *@author
 */
public interface PraiseService {
	/**
	 * 添加点赞记录
	 */
	public Long addPraise(Praise praise);
	
	/**
	 * 根据条件查询点赞数
	 */
	public int queryPraiseCount(Praise praise);
}
