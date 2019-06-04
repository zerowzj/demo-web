package com.company.project.demoweb.support.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action
 *
 * @author wangzhj
 */
public interface Action<T> {

    /**
     * 执行操作
     *
     * @param request
     * @param response
     * @return Map<String, Object>
     */
    Map<String, Object> doAction(HttpServletRequest request, HttpServletResponse response);
}
