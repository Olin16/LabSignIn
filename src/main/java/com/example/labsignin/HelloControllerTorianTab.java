package com.example.labsignin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HelloControllerTorianTab {
    //ok
    public Button studentTab;
    public TextField email;
    public TableView infoList;
    public TableColumn cteColumn;
    public TableColumn gradeColumn;
    public TableColumn studentFullNameColumn;
    public TableColumn studentImageColumn;
    public Button submitButton;

    public ComboBox cteList;
    public boolean cteListBoolean;
    public ComboBox gradeList;
    public boolean gradeListBoolean;
    ArrayList<Image> images = new ArrayList();
    public TextField studentList;
    public boolean studentListBoolean;
    public Button imageList;
    public boolean imageListBoolean;
    public PasswordField passwordControl;
    public Label cteProgram;
    public Label grade;
    public Label studentFullName;
    public Label studentImage;



    public void initialize() throws FileNotFoundException {

        email.setVisible(false);
        infoList.setVisible(false);
        cteList.setVisible(false);
        gradeList.setVisible(false);
        imageList.setVisible(false);
        studentList.setVisible(false);
        cteProgram.setVisible(false);
        grade.setVisible(false);
        studentFullName.setVisible(false);
        studentImage.setVisible(false);
        passwordControl.setVisible(true);

        gradeList.getItems().add("11th");
        gradeList.getItems().add("12th");

        cteList.getItems().add("Engineering");
        cteList.getItems().add("Digital Video");

       /* cteList.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        gradeList.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        studentList.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        imageList.setCellValueFactory(new PropertyValueFactory<>("Ranking"));


       */

        //Window projectNameTextField = null;
        //Window window = projectNameTextField.getScene().getWindow();


        imageList  = new Button("Select File");
        imageList.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            Stage stage = (Stage) email.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(stage);
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
                cteProgram.setVisible(true);
                grade.setVisible(true);
                studentFullName.setVisible(true);
                studentImage.setVisible(true);
                passwordControl.setVisible(false);
            }
        });
        //StudentData newStudent = new StudentData(cteList.getSelectionModel().getSelectedItem().toString(),"11th","farhad",null);

        submitButton.setOnAction(event -> {
            if (gradeListBoolean && cteListBoolean && studentListBoolean && imageListBoolean);
            cteList.getSelectionModel().getSelectedItem().toString();
        });

        cteList.setOnAction(event ->  {
            cteListBoolean = true;

        });

        gradeList.setOnAction(event ->  {
            gradeListBoolean = true;
        });

        studentList.setOnAction(event ->  {
            studentListBoolean = true;
        });
        imageList.setOnAction(event ->  {
        imageListBoolean = true;
        });

    }
    public void doTheSwitch() throws Exception {
        Stage stage = (Stage) studentTab.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Student-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}