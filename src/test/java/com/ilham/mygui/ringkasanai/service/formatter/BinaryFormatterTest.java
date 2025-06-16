package com.ilham.mygui.ringkasanai.service.formatter;

import org.junit.jupiter.api.Test;

public class BinaryFormatterTest {

    @Test
    public void testFormat() {
        PreFormatter formatter = new BinaryFormatter();

        System.out.println(formatter.format("lorem ipsum", "panjang"));
        System.out.println(formatter.format("lorem ipsum", "PenDeK"));
    }
}
