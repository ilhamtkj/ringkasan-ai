package com.ilham.mygui.ringkasanai.service.summarizer.llm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilham.mygui.ringkasanai.model.OllamaResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaClient implements LLMClient {
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public LLMResult generateText(String prompt) {
        String requestBody = """
            {
              "model": "mistral",
              "prompt": "%s",
              "stream": false
            }
        """.formatted(prompt);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:11434/api/generate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            OllamaResponse parsed = objectMapper.readValue(response.body(), OllamaResponse.class);
            return new LLMResult(parsed.getResponse());

        } catch (Exception e) {
            return new LLMResult("Gagal (Ollama): " + e.getMessage());
        }
    }
}
