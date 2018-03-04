package com.online.edu.common.intercepter;

import com.google.gson.Gson;
import com.online.edu.common.constants.CacheConstans;
import com.inxedu.os.common.util.ObjectUtils;
import com.online.edu.common.util.RedisUtils;
import com.online.edu.common.util.SingletonLoginUtils;
import com.inxedu.os.common.util.WebUtils;
import com.online.edu.web.entity.system.SysFunction;
import com.online.edu.web.entity.system.SysUser;
import com.online.edu.web.service.system.SysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户登录与权限拦截器
 *@author www.inxedu.com
 */
public class IntercepterAdmin extends HandlerInterceptorAdapter{
	@Autowired
	private SysFunctionService sysFunctionService;
	@Autowired
	private SingletonLoginUtils singletonLoginUtils;
    @Autowired
    private RedisUtils redisUtils;
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取登录的用户
		SysUser sysUser = singletonLoginUtils.getLoginSysUser(request);
		if(sysUser==null){
			response.sendRedirect("/admin");//跳转登录页面
			return false;
		}
		//访问的路径
        String invokeUrl = request.getContextPath() + request.getServletPath();
        //获取所有的权限
        List<SysFunction> allFunctionList = (List<SysFunction>) redisUtils.getByKey(CacheConstans.SYS_ALL_USER_FUNCTION_PREFIX+sysUser.getUserId(),List.class);
        if(ObjectUtils.isNull(allFunctionList)){
        	allFunctionList = sysFunctionService.queryAllSysFunction();
            redisUtils.save(CacheConstans.SYS_ALL_USER_FUNCTION_PREFIX+sysUser.getUserId(),allFunctionList);
        }
        //判断当前访问的权限，是否在限制中
        boolean hasFunction = false;
        for(SysFunction sf : allFunctionList){
        	if(sf.getFunctionUrl()!=null && sf.getFunctionUrl().trim().length()>0 && invokeUrl.indexOf(sf.getFunctionUrl())!=-1){
        		hasFunction = true;
        	}
        }
        //如果当前访问的权限不在限制中,直接允许通过
        if(!hasFunction){
        	return true;
        }
        //如果当前访问的权限在限制中则判断是否有访问权限
        List<SysFunction> userFunctionList = (List<SysFunction>) redisUtils.getByKey(CacheConstans.USER_FUNCTION_PREFIX+sysUser.getUserId(),List.class);
        if(userFunctionList==null || userFunctionList.size()==0){
        	userFunctionList = sysFunctionService.querySysUserFunction(sysUser.getUserId());
            redisUtils.save(CacheConstans.USER_FUNCTION_PREFIX+sysUser.getUserId(), userFunctionList);
        }
        boolean flag = false;
        if(ObjectUtils.isNotNull(userFunctionList)){
        	for(SysFunction usf : userFunctionList){
        		//如果用户有访问权限
        		if(invokeUrl.indexOf(usf.getFunctionUrl())!=-1 && usf.getFunctionUrl()!=null && usf.getFunctionUrl().trim().length()>0){
        			flag=true;
        			break;
        		}
        	}
        }
        //转向限制提示页面
        if(!flag){
        	if(WebUtils.isAjaxRequest(request)){
        		Map<String,Object> json = new HashMap<String, Object>();
        		json.put("success", false);
        		json.put("message", "对不起，您没有操作权限！");
        		json.put("entity", null);
        		response.getWriter().print(new Gson().toJson(json));
        	}else{
        		response.sendRedirect("/admin/main/notfunction");
        	}
        }
        request.setAttribute("sysuser", sysUser);
		return flag;
	}

}
