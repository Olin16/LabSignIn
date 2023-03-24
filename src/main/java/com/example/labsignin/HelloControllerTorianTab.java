package com.example.labsignin;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class HelloControllerTorianTab {
    //ok

    public TextField email;
    public TableView infoList;
    public ComboBox cteList;
    public ComboBox gradeList;
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