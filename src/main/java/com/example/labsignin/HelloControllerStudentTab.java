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
import java.util.ArrayList;

public class HelloControllerStudentTab extends HelloControllerTorianTab{
//ok
    public TextField nameField;
    public ComboBox bandList;
    public Button signIn = new Button("Sign In");
    public ImageView studentPortrait;
    public Label signInConfirm;
    public Button switchView;

    int currentIndex;


    ArrayList<StudentData> names = new ArrayList<>();

    Object selectedItem;


    public void initialize() throws FileNotFoundException {
        currentIndex = 0;


        bandList.getItems().add("X Band");
        bandList.getItems().add("Y Band");

    }

    public void comboBand() {
        int selectedIndex = bandList.getSelectionModel().getSelectedIndex();
        selectedItem = bandList.getSelectionModel().getSelectedItem();

        System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
        System.out.println("   ChoiceBox.getValue(): " + bandList.getValue());

    }


    public void signedIn() {
            String name = nameField.getText();
            for (StudentData eachStudent: StudentData.getAllStudents()) {
                if (eachStudent.getName().equalsIgnoreCase(name)) {
                    System.out.println("YAY! found: " + eachStudent.getName());
                    StudentData signedInStudent = new StudentData(eachStudent.getCte(), eachStudent.getGrade(), eachStudent.getName(), selectedItem.toString(), eachStudent.getImage());
                    names.add(signedInStudent);

                    // TODO: display eachStudent.getImage() once that works
                }
            }
        System.out.println("All students that have signed in: " + names + grade);

    }

    public void doTheSwitch() throws Exception {
        Stage stage = (Stage) nameField.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Torian-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
//commit
