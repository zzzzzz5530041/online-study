package com.online.edu.web.dao.impl.system;

import com.online.edu.common.dao.GenericDaoImpl;
import com.online.edu.web.dao.system.SysFunctionDao;
import com.online.edu.web.entity.system.SysFunction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 后台系统权限
 * @author www.inxedu.com
 *
 */
@Repository("sysFunctionDao")
public class SysFunctionDaoImpl extends GenericDaoImpl implements SysFunctionDao{

	@Override
	public List<SysFunction> queryAllSysFunction() {
		return this.selectList("SysFunctionMapper.queryAllSysFunction", null);
	}

	@Override
	public int cresateSysFunction(SysFunction sysFunction) {
		this.insert("SysFunctionMapper.cresateSysFunction", sysFunction);
		return sysFunction.getFunctionId();
	}

	@Override
	public void updateFunction(SysFunction sysFunction) {
		this.update("SysFunctionMapper.updateFunction", sysFunction);
	}

	@Override
	public void updateFunctionParentId(Map<String, Object> paramrs) {
		this.update("SysFunctionMapper.updateFunctionParentId", paramrs);
	}

	@Override
	public void deleteFunctionByIds(String ids) {
		this.delete("SysFunctionMapper.deleteFunctionByIds", ids);
	}

	@Override
	public List<SysFunction> querySysUserFunction(int userId) {
		return this.selectList("SysFunctionMapper.querySysUserFunction", userId);
	}

}
