package com.company.project.adminweb.web.support.action;

import com.company.project.adminweb.web.support.context.RequestContext;
import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 基本Action
 *
 * @author wangzhj
 */
public abstract class BaseAction implements Action {

    @Override
    public final Map<String, Object> doAction(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data;
        try {
            RequestContext cxt = new RequestContext(request, response);

            checkData(cxt);

            data = processBusiness(cxt);
            if (data == null) {
                data = Maps.newHashMap();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return data;
    }

    /**
     *
     *
     */
    public abstract void checkData(RequestContext cxt);

    /**
     *
     *
     */
    public abstract Map<String, Object> processBusiness(RequestContext cxt);
}
