module com.ilham.mygui.ringkasanai {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.ilham.mygui.ringkasanai to javafx.fxml;
    exports com.ilham.mygui.ringkasanai;
    exports com.ilham.mygui.ringkasanai.app;
    opens com.ilham.mygui.ringkasanai.app to javafx.fxml;

    opens com.ilham.mygui.ringkasanai.controller to javafx.fxml;
    exports com.ilham.mygui.ringkasanai.controller;
    opens com.ilham.mygui.ringkasanai.model to com.fasterxml.jackson.annotation;
    exports com.ilham.mygui.ringkasanai.model;
}