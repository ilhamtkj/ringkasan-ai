package com.ilham.mygui.ringkasanai.controller;

import com.ilham.mygui.ringkasanai.service.ExportHandler;
import com.ilham.mygui.ringkasanai.service.SummaryService;
import com.ilham.mygui.ringkasanai.service.TextInputHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FormController {

    // metode ringkasan combobox
    @FXML
    private ComboBox<String> summaryMethodComboBox;
    ObservableList<String> summaryMethodList = FXCollections.observableArrayList(
            "Rule-based", "API-based"
    );

    // opsi tambahan text area
    @FXML
    private TextArea additionalOptionsTextArea;

    // teks original text area
    @FXML
    private TextArea sourceTextArea;

    // teks yang telah diringkas/hasil
    @FXML
    private TextArea resultTextArea;

    @FXML
    protected void initialize() {
        // combo box metode ringkasan (kanan atas)
        summaryMethodComboBox.setItems(summaryMethodList);
        summaryMethodComboBox.setPromptText("Pilih metode ringkasan");
    }

    @FXML
    private void handleSelectFileAction() {
        TextInputHandler fileHandler = new TextInputHandler();
        String text = fileHandler.readTextFile(sourceTextArea.getScene().getWindow());

        // text = ResultFormatter.format(text);

        if (!text.isBlank()) {
            sourceTextArea.setText(text);
        }
    }

    @FXML
    private void handleSummaryAction() {
        resultTextArea.clear();
        SummaryService service = new SummaryService();

        // ambil value dari form
        String text = sourceTextArea.getText();
        String method = summaryMethodComboBox.getValue();
        String additionalOptions = additionalOptionsTextArea.getText();

        // jika metode ringkasan kosong
        if (method == null || method.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Metode ringkasan tidak boleh kosong");
            alert.showAndWait();
            return;
        }

        String summarizedText = service.generateSummary(text, method, additionalOptions);
        resultTextArea.setText(summarizedText);
        service.saveSummary(text, summarizedText, method);
    }

    @FXML
    private void handleSaveAction() {
        ExportHandler save = new ExportHandler();
        Stage stage = (Stage) resultTextArea.getScene().getWindow();
        save.exportTxt(stage, resultTextArea.getText());
    }
}
