package com.ilham.mygui.ringkasanai.service.summarizer.llm;

public interface LLMClient {
    LLMResult generateText(String prompt);
}
