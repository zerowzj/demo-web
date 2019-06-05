package com.company.project.demoweb.web;


import com.company.project.demoweb.support.web.action.Action;
import com.company.project.demoweb.support.context.SpringContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
//@RequestMapping(value = "/api")
//@ResponseBody
//@Controller
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
