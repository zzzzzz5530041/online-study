package com.online.edu.web.dao.user;

import java.util.List;

import com.online.edu.common.entity.PageEntity;

import com.online.edu.web.entity.user.UserLoginLog;

/**
 * @author
 *
 */
public interface UserLoginLogDao {
	/**
	 * 添加登录日志
	 * @param loginLog
	 * @return 日志ID
	 */
	public int createLoginLog(UserLoginLog loginLog);
	
	/**
	 * 查询用户登录日志
	 * @param userId 用户ID
	 * @param page 分页条件
	 * @return List<SysUserLoginLog>
	 */
	public List<UserLoginLog> queryUserLogPage(int userId, PageEntity page);

}
