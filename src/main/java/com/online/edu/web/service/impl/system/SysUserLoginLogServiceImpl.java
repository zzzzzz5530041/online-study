package com.online.edu.web.service.impl.system;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.system.SysUserLoginLogDao;
import com.online.edu.web.entity.system.SysUserLoginLog;
import com.online.edu.web.service.system.SysUserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户登录日志
 * @author www.inxedu.com
 */
@Service("sysUserLoginLogService")
public class SysUserLoginLogServiceImpl implements SysUserLoginLogService{

	@Autowired
	private SysUserLoginLogDao sysUserLoginLogDao;

	@Override
	public int createLoginLog(SysUserLoginLog loginLog) {
		return sysUserLoginLogDao.createLoginLog(loginLog);
	}

	@Override
	public List<SysUserLoginLog> queryUserLogPage(int userId, PageEntity page) {
		return sysUserLoginLogDao.queryUserLogPage(userId, page);
	}

}
