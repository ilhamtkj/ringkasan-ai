package com.ilham.mygui.ringkasanai.service.summarizer.llm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ilham.mygui.ringkasanai.model.OllamaResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaClient implements LLMClient {
    private static final String AI_MODEL = "mistral:7b";

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public LLMResult generateText(String prompt) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode json = mapper.createObjectNode();
            json.put("model", AI_MODEL);
            json.put("prompt", prompt);
            json.put("stream", false);

            String requestBody = mapper.writeValueAsString(json);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:11434/api/generate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            System.out.println("sending request to Ollama");

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            OllamaResponse parsed = objectMapper.readValue(response.body(), OllamaResponse.class);
            return new LLMResult(parsed.getResponse());

        } catch (Exception e) {
            return new LLMResult("Gagal (Ollama): " + e.getMessage());
        }
    }
}
