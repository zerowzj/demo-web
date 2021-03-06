package com.company.project.demoweb.support.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring上下文
 *
 * @author wangzhj
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext CTX;

    /**
     * 获取Bean
     *
     * @param name
     * @return T
     */
    public static <T> T getBean(String name) {
        T obj = (T) CTX.getBean(name);
        return obj;
    }

    /**
     * 获取Bean
     *
     * @param clazz
     * @return T
     */
    public static <T> T getBean(Class<T> clazz) {
        T obj = (T) CTX.getBean(clazz);
        return obj;
    }

    /**
     * 是否存在Bean
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return CTX.containsBean(name);
    }

    /**
     * 是否存在Bean
     *
     * @param clazz
     * @return boolean
     */
    public static boolean containsBean(Class<?> clazz) {
        boolean isExist = false;
        if (CTX.getBean(clazz) != null) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CTX = applicationContext;
    }
}
