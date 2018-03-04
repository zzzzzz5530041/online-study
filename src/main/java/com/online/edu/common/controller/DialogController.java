package com.online.edu.common.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DialogController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(DialogController.class);
    private static final String getDialogHtml = "/common/dialog";

    public DialogController() {
    }

    @RequestMapping({"/common/dialog"})
    public String getDialog(HttpServletRequest request, Model model) {
        try {
            Map<String, Object> mapDialog = new HashMap();
            mapDialog.put("title", request.getParameter("title"));
            mapDialog.put("context", request.getParameter("context"));
            mapDialog.put("height", request.getParameter("height") == null ? 157 : request.getParameter("height"));
            model.addAttribute("dialog", mapDialog);
            return "/common/dialog";
        } catch (Exception var4) {
            logger.error("getDialog", var4);
            return this.setExceptionRequest(request, var4);
        }
    }
}