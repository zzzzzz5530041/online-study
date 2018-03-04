package com.online.edu.web.service.impl.system;

import com.online.edu.web.dao.system.SysRoleDao;
import com.online.edu.web.entity.system.SysRole;
import com.online.edu.web.service.system.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台角色权限
 * @author www.inxedu.com
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public int createRoel(SysRole sysRole) {
		return sysRoleDao.createRoel(sysRole);
	}

	@Override
	public void updateRole(SysRole sysRole) {
		sysRoleDao.updateRole(sysRole);
	}

	@Override
	public List<SysRole> queryAllRoleList() {
		return sysRoleDao.queryAllRoleList();
	}

	@Override
	public void deleteRoleByIds(String ids) {
		if(ids!=null && ids.trim().length()>0){
			if(ids.trim().endsWith(",")){
				ids = ids.trim().substring(0,ids.trim().length()-1);
			}
			sysRoleDao.deleteRoleByIds(ids);
		}
	}

	@Override
	public void deleteRoleFunctionByRoleId(int roleId) {
		sysRoleDao.deleteRoleFunctionByRoleId(roleId);
	}

	@Override
	public void createRoleFunction(String value) {
		if(value!=null && value.trim().length()>0){
			if(value.endsWith(",")){
				value = value.trim().substring(0,value.trim().length()-1);
			}
			sysRoleDao.createRoleFunction(value);
		}
	}

	@Override
	public List<Integer> queryRoleFunctionIdByRoleId(int roleId) {
		return sysRoleDao.queryRoleFunctionIdByRoleId(roleId);
	}

}
