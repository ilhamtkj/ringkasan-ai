package com.ilham.mygui.ringkasanai.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class MainController {

    // fx:id
    // menu item
    @FXML
    private MenuItem summerizerMenuItem;
    @FXML
    private MenuItem historyMenuItem;
    @FXML
    private MenuItem helpMenuItem;

    // fx:id konten untuk merubah halaman
    @FXML
    private AnchorPane contentArea;

    /**
     * untuk inisialisasi awal komponen setelah file FXML dimuat.
     *
     * @throws Exception error ketika file fxml tidak ditemukan
     */
    @FXML
    protected void initialize() throws Exception {
        AnchorPane page = FXMLLoader.load(getClass().getResource("/com/ilham/mygui/ringkasanai/app/view/form.fxml"));
        contentArea.getChildren().setAll(page);
    }

    /**
     * keluar aplikasi/exit/close
     */
    @FXML
    private void handleCloseAction() {
        System.exit(0);
    }

    /**
     * akan menampilkan halaman form ketika menu item ini ditekan
     *
     * @throws Exception error ketika file fxml tidak ditemukan
     */
    @FXML
    private void handleSummarizerAction() throws Exception {
        AnchorPane page = FXMLLoader.load(getClass().getResource("/com/ilham/mygui/ringkasanai/app/view/form.fxml"));
        contentArea.getChildren().setAll(page);
    }

    /**
     * akan menampilkan halaman histori/riwayat ketika menu item ini ditekan
     *
     * @throws Exception error ketika file fxml tidak ditemukan
     */
    @FXML
    private void handleHistoryAction() throws Exception {
        // testing
        AnchorPane page = FXMLLoader.load(getClass().getResource("/com/ilham/mygui/ringkasanai/app/view/history.fxml"));
        contentArea.getChildren().setAll(page);
    }

    /**
     * akan menampilkan halaman help/bantuan ketika menu item ini ditekan
     *
     * @throws Exception error ketika file fxml tidak ditemukan
     */
    @FXML
    private void handleHelpAction() throws Exception {
        AnchorPane page = FXMLLoader.load(getClass().getResource("/com/ilham/mygui/ringkasanai/app/view/help.fxml"));
        contentArea.getChildren().setAll(page);
    }
}
