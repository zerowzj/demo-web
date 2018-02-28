package com.company.project.adminweb.auth;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 功能映射
 *
 * @author wangzhj
 */
public class FunctionMapFactoryBean implements FactoryBean<LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionMapFactoryBean.class);

    @Override
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getObject() throws Exception {
        //生成映射
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> funMap = Maps.newLinkedHashMap();

        String path = "/**";
        //匹配器
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(path + "*");
        //配置属性
        List<ConfigAttribute> configAttrLt = Lists.newArrayList();
        configAttrLt.add(new SecurityConfig(path));

        funMap.put(matcher, configAttrLt);

        return funMap;
    }

    @Override
    public Class<?> getObjectType() {
        return LinkedHashMap.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
