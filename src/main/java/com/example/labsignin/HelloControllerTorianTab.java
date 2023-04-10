package com.example.labsignin;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

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
        Window projectNameTextField = null;
        Window window = projectNameTextField.getScene().getWindow();


        imageList  = new Button("Select File");
        imageList.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(window);
            Image studentImage = null;
            try {
                studentImage = new Image(new FileInputStream(selectedFile));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        passwordControl.setOnAction(event ->  {
            if (passwordControl.getText().equals("torianpassword")) {
                email.setVisible(true);
                infoList.setVisible(true);
                cteList.setVisible(true);
                gradeList.setVisible(true);
                imageList.setVisible(true);
                studentList.setVisible(true);
            }
        });

    }

}