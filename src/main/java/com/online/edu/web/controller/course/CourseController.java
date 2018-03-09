package com.online.edu.web.controller.course;

import com.online.edu.common.constants.CommonConstants;
import com.online.edu.common.controller.BaseController;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.common.util.ObjectUtils;
import com.online.edu.common.util.SingletonLoginUtils;
import com.online.edu.web.entity.course.Course;
import com.online.edu.web.entity.course.CourseDto;
import com.online.edu.web.entity.course.CourseFavorites;
import com.online.edu.web.entity.course.QueryCourse;
import com.online.edu.web.entity.kpoint.CourseKpoint;
import com.online.edu.web.entity.subject.QuerySubject;
import com.online.edu.web.entity.subject.Subject;
import com.online.edu.web.entity.teacher.QueryTeacher;
import com.online.edu.web.entity.teacher.Teacher;
import com.online.edu.web.service.course.CourseFavoritesService;
import com.online.edu.web.service.course.CourseKpointService;
import com.online.edu.web.service.course.CourseService;
import com.online.edu.web.service.subject.SubjectService;
import com.online.edu.web.service.teacher.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
/**
 * 前台 Course管理接口
 * @author
 */
@Controller
public class CourseController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    // 课程列表
    private static final String showCourseList = "/web/course/courses-list";
    // 课程详情
    private static final String courseDetail = "/web/course/course-detail";
@Autowired
private SingletonLoginUtils singletonLoginUtils;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;
	@Autowired
	private CourseFavoritesService courseFavoritesService;
	@Autowired
	private CourseKpointService courseKpointService;

    // 绑定变量名字和属性，参数封装进类
    @InitBinder("queryCourse")
    public void initBinderQueryCourse(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("queryCourse.");
    }
    @InitBinder("courseFavorites")
    public void initBinderCourseFavorites(WebDataBinder binder) {
    	binder.setFieldDefaultPrefix("courseFavorites.");
    }

    /**
     * 课程列表展示,搜索课程
     */
    @RequestMapping("/web/course/showcoulist")
    public ModelAndView showCourseList(HttpServletRequest request, @ModelAttribute("page") PageEntity page, @ModelAttribute("queryCourse") QueryCourse queryCourse) {
        ModelAndView model = new ModelAndView();
        try {
        	model.setViewName(showCourseList);
            // 页面传来的数据放到page中
        	page.setPageSize(12);
            //只查询上架的
            queryCourse.setIsavaliable(1);
            // 搜索课程列表
            List<CourseDto> courseList = courseService.queryWebCourseListPage(queryCourse, page);
            model.addObject("courseList", courseList);
            
            // 查询所有1级专业
            QuerySubject querySubject = new QuerySubject();
            querySubject.setParentId(0);
            List<Subject> subjectList = subjectService.getSubjectList(querySubject);
            
            
            //根据条件专业查询 所有的子专业
            if (ObjectUtils.isNotNull(queryCourse.getSubjectId())) {
                Subject subject = new Subject();
                subject.setSubjectId(queryCourse.getSubjectId());
                subject = subjectService.getSubjectBySubject(subject);
                //查询子专业
                List<Subject> sonSubjectList = null;
                if (subject.getParentId() != 0) {//如果条件为二级专业（根据父级id，查询所有的子级）
                    sonSubjectList = subjectService.getSubjectListByOne(Long.valueOf(subject.getParentId()));
                    model.addObject("subjectParentId", subject.getParentId());//父级id
                } else {//如果条件为一级专业（根据id，查询所有的子级）
                    sonSubjectList = subjectService.getSubjectListByOne(Long.valueOf(subject.getSubjectId()));
                }
                model.addObject("sonSubjectList", sonSubjectList);
            }
            
            // 全部教师
            QueryTeacher query = new QueryTeacher();
            List<Teacher> teacherList =teacherService.queryTeacherList(query);
            
            model.addObject("page",page);
            model.addObject("queryCourse", queryCourse);
            model.addObject("teacherList", teacherList);
            model.addObject("subjectList", subjectList);
        } catch (Exception e) {
        	model.setViewName(this.setExceptionRequest(request, e));
            logger.error("showCourseList()--error", e);
        }
        return model;
    }

    /**
     * 课程详情
     * 不管是课程套餐还是课程目录时都放到list(coursePackageList)中
     */
    @RequestMapping("/web/course/detail/{id}")
    public ModelAndView courseDetail(HttpServletRequest request, @PathVariable("id") int courseId) {
        ModelAndView model = new ModelAndView();
        model.addObject("contextPath", CommonConstants.contextPath);
    	try {
    		model.setViewName(courseDetail);
            // 查询课程详情
            Course course = courseService.queryCourseById(courseId);
            if(course!=null){
            	model.addObject("course", course);
                //更新课程的浏览量
                courseService.updateCourseCount("pageViewcount",courseId);

            	//查询课程老师
            	List<Map<String,Object>> teacherList = teacherService.queryCourseTeacerList(courseId);
            	model.addObject("teacherList", teacherList);
            	//相关课程
            	List<CourseDto> courseList = courseService.queryInterfixCourseLis(course.getSubjectId(), 5,course.getCourseId());
            	for(CourseDto tempCoursedto : courseList){
            		teacherList=teacherService.queryCourseTeacerList(tempCoursedto.getCourseId());
            		tempCoursedto.setTeacherList(teacherList);
            	}
            	model.addObject("courseList", courseList);
            	int userId = singletonLoginUtils.getLoginUserId(request);
            	if(userId>0){
            		//查询登用户是否已经收藏
        			boolean isFavorites = courseFavoritesService.checkFavorites(userId, courseId);
        			model.addObject("isFavorites", isFavorites);
            	}
            	//查询课程章节目录
            	List<CourseKpoint> parentKpointList = new ArrayList<CourseKpoint>();//一级 课程章节
            	List<CourseKpoint> kpointList = courseKpointService.queryCourseKpointByCourseId(courseId);
            	if(kpointList!=null && kpointList.size()>0){
            		for(CourseKpoint temp:kpointList){
                		if (temp.getParentId()==0) {
                			parentKpointList.add(temp);
    					}
                	}
            		int freeVideoId=0;
            		for(CourseKpoint tempParent:parentKpointList){
                		for(CourseKpoint temp:kpointList){
                    		if (temp.getParentId()==tempParent.getKpointId()) {
                    			tempParent.getKpointList().add(temp);
        					}
                    		//获取一个可以试听的视频id
                    		if (freeVideoId==0&&temp.getFree()==1&&temp.getKpointType()==1) {
                    			freeVideoId=temp.getKpointId();
                    			model.addObject("freeVideoId",freeVideoId);
							}
                    	}
                	}
                	model.addObject("parentKpointList", parentKpointList);
            	}
            }
            model.addObject("isok", true);
        } catch (Exception e) {
        	model.setViewName(this.setExceptionRequest(request, e));
            logger.error("courseDetail()----error", e);
        }
        return model;
    }
    
    /**
     * 添加课程收藏
     */
    @RequestMapping("/front/createfavorites/{courseId}")
    @ResponseBody
    public Map<String,Object> createFavorites(HttpServletRequest request,@ModelAttribute("courseFavorites") CourseFavorites courseFavorites,@PathVariable("courseId") int courseId){
    	Map<String,Object> json = new HashMap<String,Object>();
    	try{
    		int userId = singletonLoginUtils.getLoginUserId(request);
    		if(userId<=0){
    			json = this.setJson(false, "请登录！", null);
    			return json;
    		}
    		if(courseId<=0){
    			json = this.setJson(false, "请选择要收藏的课程！", null);
    			return json;
    		}
    		boolean is = courseFavoritesService.checkFavorites(userId, courseId);
    		if(is){
    			json = this.setJson(false, "该课程你已经收藏过了！", null);
    			return json;
    		}
    		courseFavorites.setUserId(userId);
    		courseFavorites.setAddTime(new Date());
    		courseFavoritesService.createCourseFavorites(courseFavorites);
    		json = this.setJson(true, "收藏成功", null);
    	}catch (Exception e) {
    		this.setAjaxException(json);
			logger.error("createFavorites()--error",e);
		}
    	return json;
    }

    /**
     * 查询课程目录
     */
    @RequestMapping("/front/ajax/courseKpointList/{courseId}/{type}")
    public ModelAndView courseKpointList(HttpServletRequest request,@ModelAttribute("courseFavorites") CourseFavorites courseFavorites,@PathVariable("courseId") int courseId,@PathVariable("type") int type){
        ModelAndView model = new ModelAndView();
        try {
            model.setViewName(getViewPath("/web/course/course-kpoint-list"));
            // 查询课程详情
            Course course = courseService.queryCourseById(courseId);
            if(course!=null){
                int userId = singletonLoginUtils.getLoginUserId(request);
                //查询目录
                List<CourseKpoint> parentKpointList = new ArrayList<CourseKpoint>();
                List<CourseKpoint> kpointList = courseKpointService.queryCourseKpointByCourseId(courseId);
                if(kpointList!=null && kpointList.size()>0){
                    for(CourseKpoint temp:kpointList){
                        if (temp.getParentId()==0) {
                            parentKpointList.add(temp);
                        }
                    }
                    int freeVideoId=0;
                    for(CourseKpoint tempParent:parentKpointList){
                        for(CourseKpoint temp:kpointList){
                            if (temp.getParentId()==tempParent.getKpointId()) {
                                tempParent.getKpointList().add(temp);
                            }
                            //获取一个可以试听的视频id
                            if (freeVideoId==0&&temp.getFree()==1&&temp.getKpointType()==1) {
                                freeVideoId=temp.getKpointId();
                                model.addObject("freeVideoId",freeVideoId);
                            }
                        }
                    }
                    model.addObject("parentKpointList", parentKpointList);
                }
            }
            model.addObject("playFromType", type);
        } catch (Exception e) {
            model.setViewName(this.setExceptionRequest(request, e));
            logger.error("courseKpointList()----error", e);
        }
        return model;
    }
}