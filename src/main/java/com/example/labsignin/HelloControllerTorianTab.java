package com.example.labsignin;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class HelloControllerTorianTab {
    //ok
}
    public TextField email;
    public TableView infoList;
    public ComboBox cteList;
    public ComboBox gradeList;
    public ComboBox studentList;
    public ComboBox imageList;
    public Label signInConfirm;
    public PasswordField password;


    public void initialize() throws FileNotFoundException {
        signIn.setOnAction(actionEvent -> {
            signInConfirm.setText("You've signed in");

        });

        bandList.getItems().add("X Band");
        bandList.getItems().add("Y Band");
    }

    public PasswordField getPassword() {
        System.out.println(password.getAccessibleText());
        return password;

    }