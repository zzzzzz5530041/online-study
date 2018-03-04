package com.online.edu.web.dao.impl.system;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.dao.system.SysUserDao;
import com.online.edu.web.entity.system.QuerySysUser;
import com.online.edu.web.entity.system.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 后台用户
 * @author www.inxedu.com
 */
@Repository("sysUserDao")
public class SysUserDaoImpl extends GenericDaoImpl implements SysUserDao{

	@Override
	public int createSysUser(SysUser sysuser) {
		this.insert("SysUserMapper.createSysUser", sysuser);
		return sysuser.getUserId();
	}

	@Override
	public void updateSysUser(SysUser sysuser) {
		this.update("SysUserMapper.updateSysUser", sysuser);
	}

	@Override
	public SysUser querySysUserByUserId(int userId) {
		return this.selectOne("SysUserMapper.querySysUserByUserId", userId);
	}

	@Override
	public List<SysUser> querySysUserPage(QuerySysUser querySysUser,
			PageEntity page) {
		return this.queryForListPage("SysUserMapper.querySysUserPage", querySysUser, page);
	}

	@Override
	public int validateLoginName(String userLoginName) {
		return this.selectOne("SysUserMapper.validateLoginName", userLoginName);
	}

	@Override
	public SysUser queryLoginUser(SysUser sysUser) {
		return this.selectOne("SysUserMapper.queryLoginUser", sysUser);
	}

	@Override
	public void updateUserPwd(SysUser sysUser) {
		this.update("SysUserMapper.updateUserPwd", sysUser);
	}

	@Override
	public void updateDisableOrstartUser(Map<String, Object> map) {
		this.update("SysUserMapper.updateDisableOrstartUser", map);
	}

	@Override
	public void updateUserLoginLog(Map<String, Object> map) {
		this.update("SysUserMapper.updateUserLoginLog", map);
	}

}
