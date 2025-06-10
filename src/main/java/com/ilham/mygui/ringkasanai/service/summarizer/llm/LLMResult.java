package com.ilham.mygui.ringkasanai.service.summarizer.llm;

public class LLMResult {
    private final String generatedText;

    public LLMResult(String generatedText) {
        this.generatedText = generatedText;
    }

    public String getGeneratedText() {
        return generatedText;
    }
}
