package com.company.project.demoweb.support.web.action;

import com.company.project.demoweb.support.context.RequestContext;
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
            RequestContext ctx = new RequestContext(request, response);
            checkData(ctx);
            data = processBusiness(ctx);
            if (data == null) {
                data = Maps.newHashMap();
            }
            Map<String, Object> result  = Maps.newHashMap();
            result.put("", "");
            result.put("", "");
            result.put("", data);
        } catch (Exception ex) {
            throw ex;
        }
        return data;
    }

    /**
     * 验证数据
     */
    public abstract void checkData(RequestContext cxt);

    /**
     * 处理业务
     */
    public abstract Map<String, Object> processBusiness(RequestContext cxt);
}
