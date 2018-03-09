package com.online.edu.web.dao.system;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.entity.system.SysUserLoginLog;

import java.util.List;

/**
 * 后台用户登录日志
 * @author
 */
public interface SysUserLoginLogDao {
	/**
	 * 添加登录日志
	 * @param loginLog
	 * @return 日志ID
	 */
	public int createLoginLog(SysUserLoginLog loginLog);
	
	/**
	 * 查询用户登录日志
	 * @param userId 用户ID
	 * @param page 分页条件
	 * @return List<SysUserLoginLog>
	 */
	public List<SysUserLoginLog> queryUserLogPage(int userId, PageEntity page);

}
