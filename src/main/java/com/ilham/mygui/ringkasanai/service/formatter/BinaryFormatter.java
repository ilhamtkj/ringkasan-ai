package com.ilham.mygui.ringkasanai.service.formatter;

public class BinaryFormatter implements PreFormatter {
    @Override
    public String format(String text, String options) {
        options = options.trim().toLowerCase();
        return String.format("(%s) %s", options, text);
    }
}
