package com.company.project.demoweb.support;

/**
 * Track Key Holder
 *
 * @author wangzhj
 */
public abstract class TraceKey {

    private static ThreadLocal<String> LOCAL = new ThreadLocal();

    private TraceKey() {
    }

    public static String get() {
        return (String) LOCAL.get();
    }

    public static void set(String traceKey) {
        LOCAL.set(traceKey);
    }

    public static void remove() {
        LOCAL.remove();
    }
}
