package com.online.edu.web.controller.webfront;

import com.asual.lesscss.LessEngine;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.online.edu.common.constants.CacheConstans;
import com.online.edu.common.constants.CommonConstants;
import com.online.edu.common.controller.BaseController;
import com.online.edu.common.util.ObjectUtils;
import com.online.edu.common.util.RedisUtils;
import com.online.edu.common.util.StringUtils;
import com.online.edu.web.entity.common.Comment;
import com.online.edu.web.entity.course.CourseDto;
import com.online.edu.web.entity.course.CourseStudyhistory;
import com.online.edu.web.entity.course.QueryCourse;
import com.online.edu.web.entity.help.HelpMenu;
import com.online.edu.web.entity.teacher.QueryTeacher;
import com.online.edu.web.entity.teacher.Teacher;
import com.online.edu.web.entity.user.User;
import com.online.edu.web.entity.user.WebLoginUser;
import com.online.edu.web.entity.website.WebsiteImages;
import com.online.edu.web.service.comment.CommentService;
import com.online.edu.web.service.course.CourseService;
import com.online.edu.web.service.course.CourseStudyhistoryService;
import com.online.edu.web.service.help.HelpMenuService;
import com.online.edu.web.service.teacher.TeacherService;
import com.online.edu.web.service.website.WebsiteImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台 controller
 * @author
 */
@Controller
public class WebFrontController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(WebFrontController.class);

	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private WebsiteImagesService websiteImagesService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CourseStudyhistoryService courseStudyhistoryService;
	@Autowired
	private HelpMenuService helpMenuService;
	@Autowired
	private RedisUtils redisUtils;
	/**
	 * 首页获取网站首页数据
	 */
	@RequestMapping("/index")
	public String getIndexpage(HttpServletRequest request, Model model) {
		try {
			model.addAttribute("num", System.currentTimeMillis());

			// 获得banner图
			Map<String, List<WebsiteImages>> websiteImages = websiteImagesService.queryImagesByType();
			model.addAttribute("websiteImages", websiteImages);
			//不同的主题显示不同的颜色
//			String cacheColor=(String)EHCacheUtil.get("index_theme_color");
			String cacheColor=redisUtils.getByKey("index_theme_color",String.class);
			if(StringUtils.isNotEmpty(cacheColor)){
				if("blue".equals(cacheColor)){
					List<WebsiteImages> websiteImagesList = websiteImages.get("type_16");
					model.addAttribute("websiteImagesList", websiteImagesList);
				}
				if("green".equals(cacheColor)){
					List<WebsiteImages> websiteImagesList = websiteImages.get("type_17");
					model.addAttribute("websiteImagesList", websiteImagesList);
				}
				if("orange".equals(cacheColor)){
					List<WebsiteImages> websiteImagesList = websiteImages.get("type_1");
					model.addAttribute("websiteImagesList", websiteImagesList);
				}
			}else{
				changeColor(request,"orange");
				List<WebsiteImages> websiteImagesList = websiteImages.get("type_1");
				model.addAttribute("websiteImagesList", websiteImagesList);
			}
			model.addAttribute("theme_color", cacheColor);
			
			// 查询排序最高的4位老师
			List<Teacher> teacherList=(List<Teacher>)redisUtils.getByKey(CacheConstans.INDEX_TEACHER_RECOMMEND,List.class);
			if(teacherList==null||teacherList.size()==0){
				QueryTeacher queryTeacher = new QueryTeacher();
				queryTeacher.setCount(4);
				teacherList = teacherService.queryTeacherList(queryTeacher);
				redisUtils.save(CacheConstans.INDEX_TEACHER_RECOMMEND,teacherList);
			}
			model.addAttribute("teacherList", teacherList);
			
			//课程互动
			Comment comment = new Comment();
			comment.setLimitNumber(10);
			List<Comment> commentList = commentService.queryCommentInteraction(comment);
			model.addAttribute("commentList", commentList);
		} catch (Exception e) {
			logger.error("WebFrontController.getIndexpage", e);
			return setExceptionRequest(request, e);
		}
		model.addAttribute("staticImage", CommonConstants.staticImage);
		model.addAttribute("contextPath", CommonConstants.contextPath);

		return "/web/index/index";//首页页面
	}

	// 首页为你推荐换一换功能(随机获取)
	@RequestMapping("/index/ajax/huanyihuan")
	public String queryRecommenCourseListByRecommendId(HttpServletRequest request) {
		try {
			// RecommendId是分类Id
			// 获得为你推荐的课程
			List<CourseDto> courseDtoList = courseService.queryRecommenCourseListByRecommendId(2l, 4l);
			request.setAttribute("courseDtoList", courseDtoList);
		} catch (Exception e) {
			logger.error("WebFrontController.queryRecommenCourseListByRecommendId", e);
			return setExceptionRequest(request, e);
		}
		return "/web/index/ajax-course-recommend";
	}

	// 首页学生动态
	@RequestMapping("/index/ajax/studentDynamic")
	public String studentDynamic(HttpServletRequest request) {
		try {
			//课程学习记录
			List<CourseStudyhistory> courseStudyhistoryList = (List<CourseStudyhistory>)redisUtils.getByKey(CacheConstans.INDEX_STUDENT_DYNAMIC,List.class);

				if(ObjectUtils.isNull(courseStudyhistoryList)){
					CourseStudyhistory courseStudyhistory=new CourseStudyhistory();
					courseStudyhistory.setQueryLimit(4);//限制4条
					courseStudyhistoryList=courseStudyhistoryService.getCourseStudyhistoryList(courseStudyhistory);
					redisUtils.save(CacheConstans.INDEX_STUDENT_DYNAMIC,courseStudyhistoryList);
				}
			request.setAttribute("courseStudyhistoryList", courseStudyhistoryList);
		} catch (Exception e) {
			logger.error("studentDynamic", e);
			return setExceptionRequest(request, e);
		}
		return "/web/index/ajax-student-dynamic";//页面
	}
		
	// 首页精品课程、最新课程、全部课程
	@RequestMapping("/index/ajax/bna")
	public String queryCourse(HttpServletRequest request) {
		try {
			String order = request.getParameter("order");
			if (order != null && !order.equals("")) {
				QueryCourse queryCourse = new QueryCourse();
				queryCourse.setOrder(order);
				//只查询上架的
	            queryCourse.setIsavaliable(1);
				// 获得精品课程、最新课程、全部课程
				List<CourseDto> courseDtoBNAList = courseService.queryCourse(queryCourse);
				request.setAttribute("queryCourse", queryCourse);
				request.setAttribute("courseDtoBNAList", courseDtoBNAList);
			}
		} catch (Exception e) {
			logger.error("WebFrontController.queryCourse", e);
			return setExceptionRequest(request, e);
		}
		return "/web/index/ajax-course-bna";
	}
	/**
	 * 跳转找回密码页面
	 */
	@RequestMapping("/front/passwordRecovery")
	public ModelAndView passWordRecovery(){
		return new ModelAndView(getViewPath("/web/user/password-recovery"));
	}
	
	/** 
	 * 修改主题色
	 * 
	 */
    @RequestMapping("/theme/ajax/update")
    @ResponseBody
    public Object updateTheme(HttpServletRequest request,@RequestParam String color) {
    	Map<String,Object> json = new HashMap<String,Object>();
		changeColor(request,color);
		json = this.setJson(true, color, "");
		return json;
    }
    
    public void changeColor(HttpServletRequest request,String colorfalg){
    	String color="#ea562e";
    	if (colorfalg.equals("blue")) {
    		color="#009ed9";
		}else if (colorfalg.equals("green")) {
    		color="#68cb9b";
		}
    	
    	//放入缓存
		redisUtils.saveWithExpireTime("index_theme_color",colorfalg,21600L);//缓存六小时
    	//获得项目根目录
//    	String strDirPath = request.getSession().getServletContext().getRealPath("/");
    	//读取字符串
    	StringBuffer sb = new StringBuffer();
    	//当前读取行数
    	int rowcount = 1 ;
    	//要修改的行数
    	int updaterowcount = 2 ;
    	FileReader fr;
    	try {
			String path = "classpath:static/inxweb/css/less/theme.less";
			File file = ResourceUtils.getFile("classpath:static/inxweb/css/less/theme.less");
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				if(rowcount==updaterowcount&&StringUtils.isNotEmpty(color)){
					sb.append("@mColor:"+color+";");
				}else{
					sb.append(line);
				}
				line = br.readLine();
				rowcount++;
			}
			br.close();
			fr.close();
			LessEngine engine = new LessEngine();
			FileWriter fw = new FileWriter(file);
		    fw.write(engine.compile(sb.toString()));
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    }
    
    /** 
	 * 根据用户key 获得登录用户（用于小组登录）
	 * 
	 */
    @RequestMapping("/user/ajax/logined")
    @ResponseBody
    public Object getLoginUserByKey(HttpServletRequest request,@RequestParam String userKey) {
    	Map<String,Object> json = new HashMap<String,Object>();
		User user = (User) redisUtils.getByKey(userKey,User.class);
		//User user = (User) request.getSession().getAttribute(userKey);
		if(ObjectUtils.isNotNull(user)){
			//添加需要的属性
			WebLoginUser webLoginUser=new WebLoginUser();
			webLoginUser.setId(Long.valueOf(user.getUserId()));
			webLoginUser.setCusId(Long.valueOf(user.getUserId()));
			webLoginUser.setEmail(user.getEmail());
			webLoginUser.setGender(user.getSex());
			webLoginUser.setId(Long.valueOf(user.getUserId()));
			webLoginUser.setMobile(user.getMobile());
			webLoginUser.setNickname(user.getShowName());
			webLoginUser.setRealname(user.getUserName());
			webLoginUser.setAvatar(user.getPicImg());
			webLoginUser.setUserInfo("这个人很懒，他还没有签名");
			
			JsonParser jsonParser = new JsonParser();
	        JsonObject jsonObject  = jsonParser.parse(new Gson().toJson(webLoginUser)).getAsJsonObject();
			json = this.setJson(true, "", jsonObject.toString());
		}else{
			json = this.setJson(false, "", "");
		}
		
		return json;
    }

	/**
	 * 帮助中心
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/front/helpCenter")
	public String getHelpCenter(HttpServletRequest request, Model model) {
		try {
			// 右侧显示内容的二级菜单id
			String id = request.getParameter("id");
			// 帮助中心菜单集合，不含内容
			List<List<HelpMenu>> helpMenus = helpMenuService.getHelpMenuAll();
			model.addAttribute("helpMenus", helpMenus);

			// 右侧显示内容
			HelpMenu helpMenuContent = null;
			if (id != null && !id.equals("")) {
				helpMenuContent = helpMenuService.getHelpMenuById(Long.parseLong(id));
			} else if (helpMenus.size() > 0 && helpMenus.get(0).get(1) != null) {
				helpMenuContent = helpMenuService.getHelpMenuById(helpMenus.get(0).get(1).getId());
			}
			model.addAttribute("helpMenuContent", helpMenuContent);//显示的

		} catch (Exception e) {
			logger.error("WebFrontController.getHelpCenter", e);
			return setExceptionRequest(request, e);
		}
		return getViewPath("/web/front/helpCenter");
	}
}
