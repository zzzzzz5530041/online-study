package com.online.edu.web.dao.impl.system;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.system.SysUserLoginLogDao;
import com.online.edu.web.entity.system.SysUserLoginLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户登录日志
 * @author
 *
 */
@Repository("sysUserLoginLogDao")
public class SysUserLoginLogDaoImpl extends GenericDaoImpl implements SysUserLoginLogDao {

	@Override
	public int createLoginLog(SysUserLoginLog loginLog) {
		this.insert("SysUserLoginLogMapper.createLoginLog", loginLog);
		return loginLog.getLogId();
	}

	@Override
	public List<SysUserLoginLog> queryUserLogPage(int userId, PageEntity page) {
		return this.queryForListPage("SysUserLoginLogMapper.queryUserLogPage", userId, page);
	}

}
