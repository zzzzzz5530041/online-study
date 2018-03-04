package com.online.edu.web.service.impl.user;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.user.UserLoginLogDao;
import com.online.edu.web.entity.user.UserLoginLog;
import com.online.edu.web.service.user.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学员登录日志
 * @author www.inxedu.com
 *
 */
@Service("userLoginLogService")
public class UserLoginLogServiceImpl implements UserLoginLogService{

	@Autowired
	private UserLoginLogDao userLoginLogDao;

	@Override
	public int createLoginLog(UserLoginLog loginLog) {
		return userLoginLogDao.createLoginLog(loginLog);
	}

	@Override
	public List<UserLoginLog> queryUserLogPage(int userId, PageEntity page) {
		return userLoginLogDao.queryUserLogPage(userId, page);
	}

}
