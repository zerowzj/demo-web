package com.company.project.adminweb.auth.filter;

import com.company.project.adminweb.common.RequestHolder;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 看门狗过滤器
 *
 * @author wangzhj
 */
public class WatchDogFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchDogFilter.class);

    private static final String REQUEST_ID = "Request-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            RequestHolder.set(request);
            //
            response.setHeader("X-Frame-Options", "SAMEORIGIN");
            //
            String requestId = request.getHeader(REQUEST_ID);
            if (Strings.isNullOrEmpty(requestId)) {
                requestId = String.valueOf(UUID.randomUUID().hashCode() & 0x7fffffff);
            }
            //
            MDC.put("request_id", requestId);
            //
            filterChain.doFilter(request, response);
        } finally {
            RequestHolder.clear();
            MDC.clear();
        }
    }
}
