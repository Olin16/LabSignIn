package com.example.labsignin;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class HelloControllerTorianTab {
    public TextField email;
    public PasswordField password;
    public TableView infoList;
    public ComboBox cteList;
    public ComboBox gradeList;
    public ComboBox studentList;
    public ComboBox imageList;
    public void initialize() throws FileNotFoundException {


    }

    public PasswordField getPassword() {
        System.out.println(password.getAccessibleText());
        return password;

    }
}