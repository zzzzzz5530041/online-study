package com.online.edu.web.dao.impl.system;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.system.SysRoleDao;
import com.online.edu.web.entity.system.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户角色
 * @author
 */
@Repository("sysRoleDao")
public class SysRoleDaoImpl extends GenericDaoImpl implements SysRoleDao{

	@Override
	public int createRoel(SysRole sysRole) {
		this.insert("SysRoleMapper.createRoel", sysRole);
		return sysRole.getRoleId();
	}

	@Override
	public void updateRole(SysRole sysRole) {
		this.update("SysRoleMapper.updateRole", sysRole);
	}

	@Override
	public List<SysRole> queryAllRoleList() {
		return this.selectList("SysRoleMapper.queryAllRoleList", null);
	}

	@Override
	public void deleteRoleByIds(String ids) {
		this.delete("SysRoleMapper.deleteRoleByIds", ids);
		
	}

	@Override
	public void deleteRoleFunctionByRoleId(int roleId) {
		this.delete("SysRoleMapper.deleteRoleFunctionByRoleId", roleId);
		
	}

	@Override
	public void createRoleFunction(String value) {
		this.insert("SysRoleMapper.createRoleFunction", value);
		
	}

	@Override
	public List<Integer> queryRoleFunctionIdByRoleId(int roleId) {
		return this.selectList("SysRoleMapper.queryRoleFunctionIdByRoleId", roleId);
	}

}
