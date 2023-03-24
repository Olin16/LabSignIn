package com.example.labsignin;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloControllerTorianTab {
    //ok

    public TextField email;
    public TableView infoList;
    public ComboBox cteList;
    public ComboBox gradeList;
    public Label signInConfirm;
    public PasswordField password = new PasswordField();

    ArrayList<Image> images = new ArrayList();
    public TextField studentList;
    public Button imageList;
    public PasswordField passwordControl;


    public void initialize() throws FileNotFoundException {
        email.setVisible(false);
        infoList.setVisible(false);
        cteList.setVisible(false);
        gradeList.setVisible(false);
        imageList.setVisible(false);
        studentList.setVisible(false);
        FileChooser fileChooser = new FileChooser();

        Button button3 = new Button("Select File");
        button3.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog();
            Image studentImage = null;
            try {
                studentImage = new Image(new FileInputStream(selectedFile));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            images.add(studentImage);

        });


    }
    public PasswordField getPassword() {
        System.out.println(password.getAccessibleText());
        return password;

    }
}