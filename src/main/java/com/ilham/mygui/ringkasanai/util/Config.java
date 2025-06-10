package com.ilham.mygui.ringkasanai.util;

public class Config {
    public static String getEnv(String key) {
        String value = System.getenv(key);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("ENV var " + key + " tidak ditemukan");
        }
        return value;
    }
}
