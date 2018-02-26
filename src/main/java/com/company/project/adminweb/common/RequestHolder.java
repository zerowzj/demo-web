package com.company.project.adminweb.common;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest
 *
 * @author wangzhj
 */
public class RequestHolder {

    private static ThreadLocal<HttpServletRequest> LOCAL = new ThreadLocal();

    public RequestHolder() {
    }

    public static HttpServletRequest get() {
        return LOCAL.get();
    }

    public static void set(HttpServletRequest request) {
        LOCAL.set(request);
    }

    public static void clear() {
        LOCAL.remove();
    }
}
