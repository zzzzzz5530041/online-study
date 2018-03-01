package com.inxedu.os.common.util;

import com.inxedu.os.common.constants.CacheConstans;
import com.inxedu.os.edu.entity.system.SysUser;
import com.inxedu.os.edu.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author www.inxedu.com
 *
 */
@Component
public class SingletonLoginUtils {
    @Autowired
    private RedisUtils redisUtils;
	/**
	 * 
	 * 获取后台登录用户ID
	 * @param request
	 * @return 返因用户ID
	 */
	public  int getLoginSysUserId(HttpServletRequest request) {
		SysUser useObject = getLoginSysUser(request);
		if (ObjectUtils.isNotNull(useObject)) {
			return useObject.getUserId();
		} else {
			return 0;
		}
	}

	/**
	 * 获取后台登录用户
	 * @return SysUser
	 * @throws Exception
	 */
	public  SysUser getLoginSysUser(HttpServletRequest request) {
		String userKey = WebUtils.getCookie(request, CacheConstans.LOGIN_MEMCACHE_PREFIX);
		if (StringUtils.isNotEmpty(userKey)) {
			SysUser sysUser = (SysUser) redisUtils.getByKey(userKey,SysUser.class);
			if (ObjectUtils.isNotNull(sysUser)) {
				return sysUser;
			}
		}
		return null;
	}
	
	/**
	 * 获取前台登录用户ID
	 * @param request
	 * @return 返回用户ID
	 */
	public  int getLoginUserId(HttpServletRequest request){
		User user = getLoginUser(request);
		if(user!=null){
			return user.getUserId();
		}
		return 0;
	}
	
	/**
	 * 获取前台登录用户
	 * @param request
	 * @return User
	 */
	public  User getLoginUser(HttpServletRequest request){
		String userKey = WebUtils.getCookie(request, CacheConstans.WEB_USER_LOGIN_PREFIX);
		if(StringUtils.isNotEmpty(userKey)){
			User user = (User) redisUtils.getByKey(userKey,User.class);
			//User user = (User) request.getSession().getAttribute(userKey);
			if(ObjectUtils.isNotNull(user)){
				return user;
			}
		}
		return null;
	}

	//判断是否为手机浏览器
	public  boolean JudgeIsMoblie(HttpServletRequest request) {
		boolean isMoblie = false;
		String[] mobileAgents = { "iphone", "android","ipad", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
				"opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
				"nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
				"docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
				"techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
				"wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
				"pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
				"240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
				"blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
				"kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
				"mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
				"prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
				"smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
				"voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
				"Googlebot-Mobile" };
		if (request.getHeader("User-Agent") != null) {
			String agent=request.getHeader("User-Agent");
			for (String mobileAgent : mobileAgents) {
				if (agent.toLowerCase().indexOf(mobileAgent) >= 0&&agent.toLowerCase().indexOf("windows nt")<=0 &&agent.toLowerCase().indexOf("macintosh")<=0) {
					isMoblie = true;
					break;
				}
			}
		}
		return isMoblie;
	}
}
