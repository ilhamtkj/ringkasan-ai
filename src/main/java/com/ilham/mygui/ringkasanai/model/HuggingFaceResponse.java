package com.ilham.mygui.ringkasanai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HuggingFaceResponse {

    @JsonProperty("summary_text")
    private String generated_text;

    public String getGenerated_text() {
        return generated_text;
    }

    public void setGenerated_text(String generated_text) {
        this.generated_text = generated_text;
    }
}
