package com.lingDream.celerityIT.util;

public class StringUtils {
    public static boolean isEmptyByTrim(String str) {
        if (str != null) {
            return str.trim().isEmpty();
        }
        return false;
    }
}
