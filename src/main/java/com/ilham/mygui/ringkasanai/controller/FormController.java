package com.ilham.mygui.ringkasanai.controller;

import com.ilham.mygui.ringkasanai.service.formatter.Formatter;
import com.ilham.mygui.ringkasanai.service.input.TextInputHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FormController {

    @FXML
    private TextArea sourceTextArea;

    @FXML
    private void handleSelectFileAction() {
        TextInputHandler fileHandler = new TextInputHandler();
        String text = fileHandler.readTextFile(sourceTextArea.getScene().getWindow());

        Formatter formatter = new Formatter();
        text = formatter.format(text);

        if (text != null) {
            sourceTextArea.setText(text);
        }
    }

    @FXML
    private void handleSummaryAction() {
        // kode
    }

    @FXML
    private void handleSaveAction() {
        // kode
    }
}
