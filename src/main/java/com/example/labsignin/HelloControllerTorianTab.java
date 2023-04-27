package com.example.labsignin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
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
    Image studentImageSelected;
    public Label passwordWrong;


    public void initialize() throws Exception {
        StudentData.restoreData();
        System.out.println(StudentData.getAllStudents());
        ArrayList<StudentData> temporaryList = StudentData.getAllStudents();
        // Turn the read data's ArrayList into an ObservableList
        ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
        // Make that ObservableList the list for my TableView
        infoList.setItems(temporaryObservableList);
        cteColumn.setCellValueFactory(new PropertyValueFactory<>("cte"));
        studentFullNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        studentImageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));

        infoList.setEditable(true);
        cteColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        gradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        studentFullNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // sets the table view editable
        infoList.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                String selectedItem = infoList.getSelectionModel().getSelectedItem().toString();
                infoList.getItems().remove(selectedItem);

            }
        });
        // allows you to delete rows
        passwordWrong.setVisible(false);
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
        submitButton.setVisible(false);

        gradeList.getItems().add("11th");
        gradeList.getItems().add("12th");

        cteList.getItems().add("Engineering");
        cteList.getItems().add("Digital Video");

        imageList = new Button("Select File");
        imageList.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            Stage stage = (Stage) email.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(stage);
            try {
                studentImageSelected = new Image(new FileInputStream(selectedFile));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        passwordControl.setOnAction(event -> {
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
                submitButton.setVisible(true);
                passwordWrong.setVisible(false);
            } else {
                passwordWrong.setVisible(true);
                passwordWrong.setText("Incorrect Password");

            }
        });

        submitButton.setOnAction(event -> {
            if (gradeListBoolean && cteListBoolean && studentListBoolean) { //&& imageListBoolean) {
                String cteSubmit = cteList.getSelectionModel().getSelectedItem().toString();
                String gradeSubmit = gradeList.getSelectionModel().getSelectedItem().toString();
                String studentNameSubmit = studentList.getText();
                StudentData newStudent = new StudentData(cteSubmit, gradeSubmit, studentNameSubmit, studentImageSelected);
                System.out.println(StudentData.getAllStudents());
                infoList.getItems().add(newStudent);
            }
        });

        cteList.setOnAction(event -> {
            cteListBoolean = true;
        });

        gradeList.setOnAction(event -> {
            gradeListBoolean = true;
        });

        studentList.setOnKeyTyped(event -> {
            studentListBoolean = true;
        });

        imageList.setOnAction(event -> {
            imageListBoolean = true;
        });

    }

    public void doTheSwitch() throws Exception {
        Stage stage = (Stage) studentTab.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Student-view.fxml"));
        Scene scene = new Scene(root, 1440, 900);
        stage.setScene(scene);
        stage.show();

    }
}
//commit
