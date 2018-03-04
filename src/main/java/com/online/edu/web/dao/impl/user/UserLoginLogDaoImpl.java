package com.online.edu.web.dao.impl.user;

import java.util.List;

import com.online.edu.common.entity.PageEntity;
import org.springframework.stereotype.Repository;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.user.UserLoginLogDao;
import com.online.edu.web.entity.user.UserLoginLog;

/**
 * @author www.inxedu.com
 *
 */
@Repository("userLoginLogDao")
public class UserLoginLogDaoImpl extends GenericDaoImpl implements UserLoginLogDao {

	@Override
	public int createLoginLog(UserLoginLog loginLog) {
		this.insert("UserLoginLogMapper.createLoginLog", loginLog);
		return loginLog.getLogId();
	}

	@Override
	public List<UserLoginLog> queryUserLogPage(int userId, PageEntity page) {
		return this.queryForListPage("UserLoginLogMapper.queryUserLogPage", userId, page);
	}

}
