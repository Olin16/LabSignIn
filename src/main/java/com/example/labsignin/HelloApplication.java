package com.example.labsignin;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Student-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 900);
        stage.setTitle("Lab Sign-In");
        stage.setScene(scene);
        stage.show();

      //  scene.setOnKeyPressed(keyEvent -> System.out.println(keyEvent.getCode()));
    }

    public static void main(String[] args) {
        launch();
    }
    public void stop()  {
        StudentData.saveData();
    }
}