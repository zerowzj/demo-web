package com.company.project.demoweb.support;

/**
 * Trace Key Holder
 *
 * @author wangzhj
 */
public abstract class TraceKeys {

    private static ThreadLocal<String> LOCAL = new ThreadLocal();

    private TraceKeys() {
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
