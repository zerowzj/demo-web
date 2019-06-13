package com.company.project.demoweb.support.action;

import com.company.project.demoweb.support.context.RequestContext;
import com.company.project.demoweb.support.result.Results;
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
        Map<String, Object> result;
        try {
            RequestContext ctx = new RequestContext(request, response);
            //验证数据
            checkData(ctx);
            //处理业务
            Map<String, Object> data = processBusiness(ctx);
            if (data == null) {
                data = Maps.newHashMap();
            }
            result = Results.ok(data);
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * 验证数据
     */
    public abstract void checkData(RequestContext ctx);

    /**
     * 处理业务
     */
    public abstract Map<String, Object> processBusiness(RequestContext ctx);
}
