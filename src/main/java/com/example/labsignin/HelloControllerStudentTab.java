package com.example.labsignin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class HelloControllerStudentTab extends HelloControllerTorianTab{
//ok
    public TextField nameField;
    public ComboBox bandList;
    public Button signIn = new Button("Sign In");
    public ImageView studentPortrait;
    public Label signInConfirm;
    public Button switchView;



    public void keyEvent(KeyEvent ANY){

    }

    public void initialize() throws FileNotFoundException {
        signIn.setOnAction(actionEvent -> {
            signInConfirm.setText("You've signed in");

        });

        bandList.getItems().add("X Band");
        bandList.getItems().add("Y Band");


    }

    public void doTheSwitch() throws Exception {
        Stage stage = (Stage) nameField.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Torian-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    }

