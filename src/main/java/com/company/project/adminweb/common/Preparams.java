package com.company.project.adminweb.common;

import com.company.exception.entity.param.EmptyValueException;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * 参数验证及获取
 *
 * @author wangzhj
 */
public final class Preparams {

    private Preparams() {
    }

    /**
     * String
     *
     * @param paramName
     * @return String
     */
    public static String check(String paramName) {
        String paramValue = get(paramName);
        if (Strings.isNullOrEmpty(paramValue)) {
            paramValue = Strings.emptyToNull(paramValue);
        }
        return paramValue;
    }

    public static String checkNotNullOrEmpty(String paramName) {
        String paramValue = get(paramName);
        if (Strings.isNullOrEmpty(paramValue)) {
            throw new EmptyValueException(paramName);
        }
        return paramValue;
    }

    /**
     * Integer
     */
    public static Integer checkNotNullToInt(String paramName) {
        String paramValue = get(paramName);
        if (!Strings.isNullOrEmpty(paramValue)) {
            throw new EmptyValueException(paramName);
        }
        return Ints.tryParse(paramValue);
    }

    public static Integer checkToInt(String paramName) {
        String paramValue = get(paramName);
        Integer value = null;
        if (!Strings.isNullOrEmpty(paramValue)) {
            value = Ints.tryParse(paramValue);
        }
        return value;
    }

    public static Integer checkToInt(String paramName, Integer defValue) {
        String paramValue = get(paramName);
        Integer value = defValue;
        if (!Strings.isNullOrEmpty(paramValue)) {
            value = Ints.tryParse(paramValue);
        }
        return value;
    }

    /**
     * Long
     */
    public static Long checkNotNullToLong(String paramName) {
        String paramValue = get(paramName);
        if (!Strings.isNullOrEmpty(paramValue)) {
            throw new EmptyValueException(paramName);
        }
        return Longs.tryParse(paramValue);
    }

    public static Long checkToLong(String paramName) {
        String paramValue = get(paramName);
        Long value = null;
        if (!Strings.isNullOrEmpty(paramValue)) {
            value = Longs.tryParse(paramValue);
        }
        return value;
    }

    public static Long checkToLong(String paramName, Long defValue) {
        String paramValue = get(paramName);
        Long value = defValue;
        if (!Strings.isNullOrEmpty(paramValue)) {
            value = Longs.tryParse(paramValue);
        }
        return value;
    }

    /**
     * Date
     */
    public static Date checkNotNullToDate(String paramName) {
        String paramValue = get(paramName);
        Long value = null;
        if (!Strings.isNullOrEmpty(paramValue)) {
            value = Longs.tryParse(paramValue);
        }
        //
        return null;
    }

    public static Date checkToDate(String paramName) {
        String paramValue = get(paramName);
        Long value = null;
        if (!Strings.isNullOrEmpty(paramValue)) {
            value = Longs.tryParse(paramValue);
        }
        //
        return null;
    }

    private static String get(String paramName) {
        HttpServletRequest request = RequestHolder.get();
        String paramValue = request.getParameter(paramName);
        request.setAttribute(paramName, paramValue);
        return paramValue;
    }
}
