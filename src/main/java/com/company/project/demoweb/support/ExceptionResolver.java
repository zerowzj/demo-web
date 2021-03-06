package com.company.project.demoweb.support;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 异常解析器
 *
 * @author wangzhj
 */
@ControllerAdvice
public class ExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);

    @ExceptionHandler(Throwable.class)
    public Object handle(HttpServletRequest request, HttpServletResponse response,
                         Exception ex) {
        ex.printStackTrace();
        if (isAjax(request)) {

            return null;
        } else {
            String hint = null;

            Map<String, Object> model = Maps.newHashMap();
            model.put("hint", hint);

            return new ModelAndView("common/hint", model);
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        String ajaxHeader = request.getHeader("X-Request-With");
        return Objects.equal("XMLHttpRequest", ajaxHeader);
    }
}
