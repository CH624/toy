package com.insutil.ch.common.util;

public class LogUtil {

    public static String getThrowableMessage(Throwable e) {
        e.printStackTrace();
        StackTraceElement[] elements = e.getStackTrace();
        StringBuilder builder = new StringBuilder();
        builder.append("Caused by: " + e.getMessage() + " at \n");
        for (int i = 0; i < elements.length - 1; i++) {
            builder.append(elements[i] + "\n");
        }
        builder.append(elements[elements.length - 1] + "");
        return builder.toString();
    }
}
