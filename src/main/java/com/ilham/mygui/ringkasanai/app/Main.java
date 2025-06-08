package com.ilham.mygui.ringkasanai.app;

import com.ilham.mygui.ringkasanai.util.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Summerizer!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Database.getConnection();
        launch();
    }
}