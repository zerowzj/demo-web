package com.company.project.adminweb.support.context;

import com.google.common.reflect.TypeToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;

/**
 * 请求上下文
 *
 * @author wangzhj
 */
public class RequestContext {

    private HttpServletRequest request;

    private HttpServletResponse response;

    public RequestContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * 获取参数
     *
     * @param name
     * @return
     */
    public <T> T getParam(String name) {
        Type type;
        TypeToken<T> typeToken = new TypeToken<T>() {
        };
        Class clazz = typeToken.getRawType();
        System.out.println(clazz.getName());
        return (T) request.getParameter(name);
    }
}
