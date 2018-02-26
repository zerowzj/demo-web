package com.company.project.adminweb.web.support.action;

import com.company.project.adminweb.web.support.extend.SpringContext;
import com.google.common.collect.Maps;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public class ActionExecutor {

    private Map<String, Object> data;

    private ActionExecutor(HttpServletRequest request, HttpServletResponse response,
                           Class<? extends Action> clazz) {
        boolean isExist = SpringContext.containsBean(clazz);
        if (!isExist) {
            throw new IllegalStateException("未包含[" + clazz.getName() + "]类型Bean");
        }
        Action action = SpringContext.getBean(clazz);
        data = action.doAction(request, response);
        if(data == null){
            data = Maps.newHashMap();
        }
    }

    /**
     * 执行Action
     *
     * @return Map<String, Object>
     */
    public static ActionExecutor exe(HttpServletRequest request, HttpServletResponse response,
                                     Class<? extends Action> clazz) {
        return new ActionExecutor(request, response, clazz);
    }

    /**
     * 获取执行数据
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> data() {
        return data;
    }

    /**
     * 跳转指定视图
     *
     * @param viewName
     * @return ModelAndView
     */
    public ModelAndView foward(String viewName) {
        return new ModelAndView(viewName, data);
    }
}
