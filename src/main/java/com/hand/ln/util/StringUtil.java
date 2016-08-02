package com.hand.ln.util;

public class StringUtil {
    public static String EMPTY_STRING = "";

    public static boolean isEmpty(String string) {
        return (string == null) || "".equals(string);
    }
}
