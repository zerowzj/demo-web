package com.company.project.demoweb.support.web.result;

import com.company.project.demoweb.support.TraceKey;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 结果
 *
 * @author wangzhj
 */
public class Results {

    public static final String CODE_KEY = "code";

    public static final String DESC_KEY = "desc";

    public static final String DATA_KEY = "data";

    private static final String REQUEST_ID_KEY = "request_id";

    private static final String OK = "0000";

    private static final String ERROR = "9999";

    /**
     * 成功（0000）
     *
     * @param data
     * @return Map
     */
    public static Map<String, Object> ok(Map<String, Object> data) {
        return build(OK, "成功", data);
    }

    /**
     * 失败（9999）
     *
     * @return Map
     */
    public static Map<String, Object> fail() {
        return fail(ERROR, "系统异常");
    }

    /**
     * 失败
     *
     * @param code
     * @param desc
     * @return Map<String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Object>
     */
    public static Map<String, Object> fail(String code, String desc) {
        return build(code, desc, null);
    }

    private static Map<String, Object> build(String code, String desc, Map<String, Object> data) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(CODE_KEY, code);
        result.put(DESC_KEY, desc);
        if (data == null) {
            data = Maps.newHashMap();
        }
        result.put(DATA_KEY, data);
        result.put(REQUEST_ID_KEY, TraceKey.get());
        return result;
    }
}
