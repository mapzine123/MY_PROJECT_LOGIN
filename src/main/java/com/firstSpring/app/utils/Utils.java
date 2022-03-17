package com.firstSpring.app.utils;

public class Utils {
    public static void close(AutoCloseable... ac) {
        for (AutoCloseable temp : ac) {
            try {
                temp.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
