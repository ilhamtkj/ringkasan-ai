package com.ilham.mygui.ringkasanai.model;

import javafx.beans.property.*;

import java.time.LocalDateTime;

public class SummaryModel {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty originalText = new SimpleStringProperty();
    private final StringProperty summaryText = new SimpleStringProperty();
    private final StringProperty method = new SimpleStringProperty();
    private final ObjectProperty<LocalDateTime> createdAt = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getOriginalText() {
        return originalText.get();
    }

    public void setOriginalText(String originalText) {
        this.originalText.set(originalText);
    }

    public StringProperty originalTextProperty() {
        return originalText;
    }

    public String getSummaryText() {
        return summaryText.get();
    }

    public void setSummaryText(String summaryText) {
        this.summaryText.set(summaryText);
    }

    public StringProperty summaryTextProperty() {
        return summaryText;
    }

    public String getMethod() {
        return method.get();
    }

    public void setMethod(String method) {
        this.method.set(method);
    }

    public StringProperty methodProperty() {
        return method;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt.get();
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt.set(createdAt);
    }

    public ObjectProperty<LocalDateTime> createdAtProperty() {
        return createdAt;
    }
}
