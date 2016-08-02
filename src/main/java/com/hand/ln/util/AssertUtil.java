package com.hand.ln.util;

public class AssertUtil {
    public static void isNotNull(Object obj) {
        isNotNull(obj, StringUtil.EMPTY_STRING);
    }

    public static void isNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(String string) {
        isNotNull(string, StringUtil.EMPTY_STRING);
    }

    public static void isNotEmpty(String string, String message) {
        if (StringUtil.isEmpty(string)) {
            throw new IllegalArgumentException(message);
        }
    }
}
