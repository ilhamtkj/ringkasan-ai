package com.ilham.mygui.ringkasanai.service.summarizer.llm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilham.mygui.ringkasanai.model.HuggingFaceResponse;
import com.ilham.mygui.ringkasanai.util.Config;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HuggingFaceClient implements LLMClient {
    private static final String API_TOKEN = Config.getEnv("HUGGINGFACE_API_KEY");
    private static final String MODEL_NAME = "facebook/bart-large-cnn";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public LLMResult generateText(String prompt) {
        String requestBody = "{ \"inputs\": \"" + prompt + "\" }";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-inference.huggingface.co/models/" + MODEL_NAME))
                    .header("Authorization", "Bearer " + API_TOKEN)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            HuggingFaceResponse[] result = objectMapper.readValue(response.body(), HuggingFaceResponse[].class);

            if (result.length > 0) {
                System.out.println("Hugging Face: respons");
                return new LLMResult(result[0].getGenerated_text());
            } else {
                return new LLMResult("Hugging Face: respons kosong");
            }

        } catch (Exception e) {
            return new LLMResult("Gagal (HF): " + e.getMessage());
        }
    }
}
