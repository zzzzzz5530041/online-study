package com.online.edu.web.dao.impl.praise;

import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.praise.PraiseDao;
import com.online.edu.web.entity.praise.Praise;

/**
 * @author
 *
 */
@Repository("praiseDao")
public class PraiseDaoImpl extends GenericDaoImpl implements PraiseDao {

	@Override
	public Long addPraise(Praise praise) {
		return this.insert("PraiseMapper.addPraise", praise);
	}

	@Override
	public int queryPraiseCount(Praise praise) {
		return this.selectOne("PraiseMapper.queryPraiseCount", praise);
	}

}
