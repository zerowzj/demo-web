package com.company.project.adminweb.web;


import com.company.project.adminweb.support.action.Action;
import com.company.project.adminweb.support.action.ActionExecutor;
import com.company.project.adminweb.support.ext.SpringContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
@ResponseBody
public class ApiRouter {

    /**
     * 执行Action
     *
     * @param request  Http请求
     * @param response Http响应
     * @param name     执行类名称
     * @return Map
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              String name) {
        Action action = SpringContext.getBean(name);
        if (action == null) {
            throw new IllegalStateException(String.format("action bean[%s] not exist!", name));
        }
        return action.doAction(request, response);
    }
}
