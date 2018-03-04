package com.online.edu.web.service.impl.system;

import com.online.edu.web.dao.system.SysFunctionDao;
import com.online.edu.web.entity.system.SysFunction;
import com.online.edu.web.service.system.SysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台系统权限
 * @author www.inxedu.com
 */
@Service("sysFunctionService")
public class SysFunctionServiceImpl implements SysFunctionService{

	@Autowired
	private SysFunctionDao sysFunctionDao;

	@Override
	public List<SysFunction> queryAllSysFunction() {
		return sysFunctionDao.queryAllSysFunction();
	}

	@Override
	public int cresateSysFunction(SysFunction sysFunction) {
		return sysFunctionDao.cresateSysFunction(sysFunction);
	}

	@Override
	public void updateFunction(SysFunction sysFunction) {
		sysFunctionDao.updateFunction(sysFunction);
		
	}
	@Override
	public void updateFunctionParentId(int parentId, int functionId) {
		Map<String,Object> paramrs=new HashMap<String, Object>();
		paramrs.put("parentId", parentId);
		paramrs.put("functionId", functionId);
		sysFunctionDao.updateFunctionParentId(paramrs);
		
	}

	@Override
	public void deleteFunctionByIds(String ids) {
		if(ids!=null && ids.trim().length()>0){
			if(ids.trim().endsWith(",")){
				ids = ids.trim().substring(0,ids.trim().length()-1);
			}
			sysFunctionDao.deleteFunctionByIds(ids);
		}
	}

	@Override
	public List<SysFunction> querySysUserFunction(int userId) {
		return sysFunctionDao.querySysUserFunction(userId);
	}

}
