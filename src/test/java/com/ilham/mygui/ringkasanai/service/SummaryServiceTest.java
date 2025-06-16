package com.ilham.mygui.ringkasanai.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SummaryServiceTest {
    @Test
    public void testIsOptionsValid() {
        SummaryService service = new SummaryService();

        Assertions.assertTrue(service.isMethodValid("Rule-Based"));
        Assertions.assertTrue(service.isMethodValid("abcd"));

        Assertions.assertTrue(service.isOptionsValid("Rule-Based", "PanJang"));
        Assertions.assertTrue(service.isOptionsValid("rule-based", "penDEk"));

        Assertions.assertFalse(service.isOptionsValid("Rule-Based", "abcd"));
        Assertions.assertTrue(service.isOptionsValid("api-based", "terjemahkan"));
        Assertions.assertTrue(service.isOptionsValid("api-based", ""));
        Assertions.assertTrue(service.isOptionsValid("api-based", null));
    }
}
