package com.online.edu.web.controller.letter;

import com.online.edu.common.controller.BaseController;
import com.online.edu.common.entity.PageEntity;
import com.online.edu.web.entity.letter.MsgSystem;
import com.online.edu.web.service.letter.MsgSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 系统消息
 * @author http://www.inxedu.com
 */
@Controller
@RequestMapping("/admin")
public class AdminMsgSystemController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AdminMsgSystemController.class);

    @Autowired
    private MsgSystemService msgSystemService;

    @InitBinder("msgSystem")
    public void initBinderMsgSystem(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("msgSystem.");
    }


    /**
     * 系统消息列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/letter/systemmsglist")
    public String systemMsgList(HttpServletRequest request, @ModelAttribute("msgSystem") MsgSystem msgSystem, @ModelAttribute("page") PageEntity page) {
        try {
            List<MsgSystem> nsgSystemList = msgSystemService.queryMsgSystemList(msgSystem, page);
            request.setAttribute("nsgSystemList", nsgSystemList);
        } catch (Exception e) {
            logger.error("AdminUserController.systemMsgList--error", e);
            return setExceptionRequest(request, e);
        }
        return getViewPath("/admin/letter/to_msg_system_list");
    }

    /**
     * 删除系统消息
     *
     * @param request
     * @param ids
     * @return
     */
    @RequestMapping("/letter/delsystem")
    @ResponseBody
    public Map<String, Object> delsystemmsg(HttpServletRequest request, @RequestParam("ids") String ids) {
        Map<String, Object> json = null;
        try {
            msgSystemService.delMsgSystemById(ids);
            json = this.setJson(true, "操作成功！", null);
        } catch (Exception e) {
            logger.error("AdminUserController.delsystemmsg--error", e);
            json = this.setJson(false, "系统繁忙,请稍后再试！", null);
        }
        return json;
    }
}
