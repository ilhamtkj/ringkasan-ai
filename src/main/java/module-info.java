module com.ilham.mygui.ringkasanai {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ilham.mygui.ringkasanai to javafx.fxml;
    exports com.ilham.mygui.ringkasanai;
    exports com.ilham.mygui.ringkasanai.app;
    opens com.ilham.mygui.ringkasanai.app to javafx.fxml;

    opens com.ilham.mygui.ringkasanai.controller to javafx.fxml;
    exports com.ilham.mygui.ringkasanai.controller;
}