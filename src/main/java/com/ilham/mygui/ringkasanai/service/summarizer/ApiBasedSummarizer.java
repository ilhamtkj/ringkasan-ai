package com.ilham.mygui.ringkasanai.service.summarizer;

import com.ilham.mygui.ringkasanai.service.summarizer.llm.LLMClient;
import com.ilham.mygui.ringkasanai.service.summarizer.llm.OllamaClient;

public class ApiBasedSummarizer implements Summarizer{

    /**
     * metode ini akan memanggil client yang akan mengirim
     * permintaan ke ai tujuan. misalkan ke mistral ai
     * lewat ollama maka gunakan OllamaClient.
     *
     * @param text String teks/prompt
     * @return String
     */
    @Override
    public String summarize(String text) {
        // OllamaClient diganti dengan HuggingFaceClient
        // untuk menggunakan api HuggingFace
        LLMClient client = new OllamaClient();
        return client.generateText(text).getGeneratedText();
    }
}
