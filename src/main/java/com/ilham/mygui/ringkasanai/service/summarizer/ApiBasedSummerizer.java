package com.ilham.mygui.ringkasanai.service.summarizer;

import com.ilham.mygui.ringkasanai.model.OllamaResponse;
import com.ilham.mygui.ringkasanai.service.summarizer.llm.HuggingFaceClient;
import com.ilham.mygui.ringkasanai.service.summarizer.llm.LLMClient;
import com.ilham.mygui.ringkasanai.service.summarizer.llm.OllamaClient;

public class ApiBasedSummerizer implements Summarizer{


    @Override
    public String summarize(String text) {
        LLMClient client = new OllamaClient();
        return client.generateText(text).getGeneratedText();
    }
}
