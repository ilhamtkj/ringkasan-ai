package com.ilham.mygui.ringkasanai.controller;

import com.ilham.mygui.ringkasanai.model.SummaryModel;
import com.ilham.mygui.ringkasanai.service.ExportHandler;
import com.ilham.mygui.ringkasanai.service.SummaryService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.List;

public class HistoryController {

    @FXML
    private TableView<SummaryModel> historyTableView;
    @FXML
    private TableColumn<SummaryModel, Integer> idTableColumn;
    @FXML
    private TableColumn<SummaryModel, String> titleTableColumn;
    @FXML
    private TableColumn<SummaryModel, String> methodTableColumn;
    @FXML
    private TableColumn<SummaryModel, LocalDateTime> createdAtTableColumn;

    @FXML
    private TextArea originalTextTextArea;
    @FXML
    private TextArea summaryTextTextArea;

    // list observable untuk model


    @FXML
    protected void initialize() {
        tableSetup();

    }

    // untuk mengisi nilai pada table
    private void tableSetup() {
        SummaryService service = new SummaryService();
        List<SummaryModel> tableData = service.getTableData();

        ObservableList<SummaryModel> historyData = FXCollections.observableArrayList(tableData);
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        titleTableColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        methodTableColumn.setCellValueFactory(cellData -> cellData.getValue().methodProperty());
        createdAtTableColumn.setCellValueFactory(cellData -> cellData.getValue().createdAtProperty());
        historyTableView.setItems(historyData);

        historyTableView.setRowFactory(tv -> {
            TableRow<SummaryModel> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    SummaryModel data = row.getItem();

                    // masukan ke text area
                    originalTextTextArea.setText(data.getOriginalText());
                    summaryTextTextArea.setText(data.getSummaryText());
                }
            });

            return row;
        });
    }

    @FXML
    private void handleSaveAction() {
        ExportHandler save = new ExportHandler();
        Stage stage = (Stage) summaryTextTextArea.getScene().getWindow();
        save.exportTxt(stage, summaryTextTextArea.getText());
    }
}
