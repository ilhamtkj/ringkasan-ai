package com.ilham.mygui.ringkasanai.model;

import java.time.LocalDateTime;

public class Summary {
    private Integer id;
    private String title;
    private String originalText;
    private String summaryText;
    private String method;
    private LocalDateTime createdAt;

    public Summary() {}

    public Summary(Integer id, String title, String originalText, String summaryText, String method, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.originalText = originalText;
        this.summaryText = summaryText;
        this.method = method;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
