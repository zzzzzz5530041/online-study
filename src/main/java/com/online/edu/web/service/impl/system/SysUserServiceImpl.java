package com.online.edu.web.service.impl.system;

import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.system.SysUserDao;
import com.online.edu.web.entity.system.QuerySysUser;
import com.online.edu.web.entity.system.SysUser;
import com.online.edu.web.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户
 * @author
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public int createSysUser(SysUser sysuser) {
		return sysUserDao.createSysUser(sysuser);
	}

	@Override
	public void updateSysUser(SysUser sysuser) {
		sysUserDao.updateSysUser(sysuser);
	}

	@Override
	public SysUser querySysUserByUserId(int userId) {
		return sysUserDao.querySysUserByUserId(userId);
	}

	@Override
	public List<SysUser> querySysUserPage(QuerySysUser querySysUser,
			PageEntity page) {
		return sysUserDao.querySysUserPage(querySysUser, page);
	}

	@Override
	public boolean validateLoginName(String userLoginName) {
		int count = sysUserDao.validateLoginName(userLoginName);
		if(count<=0){
			return true;
		}
		return false;
	}

	@Override
	public SysUser queryLoginUser(SysUser sysUser) {
		return sysUserDao.queryLoginUser(sysUser);
	}

	@Override
	public void updateUserPwd(SysUser sysUser) {
		sysUserDao.updateUserPwd(sysUser);
	}

	@Override
	public void updateDisableOrstartUser(int userId, int type) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("type", type);
		sysUserDao.updateDisableOrstartUser(map);
	}

	@Override
	public void updateUserLoginLog(int userId, Date time, String ip) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("time", time);
		map.put("ip", ip);
		sysUserDao.updateUserLoginLog(map);
	}
	
}
