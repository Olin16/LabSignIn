package com.example.labsignin;

import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;


public class StudentData implements Serializable {
    static ArrayList<StudentData> allStudents = new ArrayList<>();
    private String cte;
    private String grade;
    private String name;
    private transient Image image;

    public StudentData(String cte, String grade, String name, Image image) {
        this.cte = cte;
        this.grade = grade;
        this.name = name;
        this.image = image;
        allStudents.add(this);
    }

    static public ArrayList<StudentData> getAllStudents() {
        return allStudents;
    }

    static public void setAllStudents(ArrayList<StudentData> allStudentsNew) {
        allStudents = allStudentsNew;
    }

    public String getCte() {
        return cte;
    }

    public void setCte(String cte) {
        this.cte = cte;
    }

    public String getGrade() {return grade;}

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {return image;}

    public void setImage(Image image) {
        this.image = image;
    }

    public String toString() {
        return name + " " + grade + " " + cte;
    }

    static public void saveData() {
        try {
            // throw IOException?
            FileOutputStream fileOut = new FileOutputStream("Save");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            System.out.println(StudentData.getAllStudents());
            out.writeObject(StudentData.getAllStudents());
            out.close();
            fileOut.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static public void restoreData() {
        try {
            FileInputStream fileIn = new FileInputStream("Save");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // Restored saved objects into Film's arrayList of all films\
            ArrayList tempList = (ArrayList<StudentData>) in.readObject();
            StudentData.setAllStudents(tempList);
            System.out.println(StudentData.getAllStudents());

            in.close();

            /*
            FileInputStream fileIn = new FileInputStream("Save");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // Restored saved objects into Film's arrayList of all films\
            ArrayList<String> temporaryList = (ArrayList<String>) in.readObject();
            ObservableList<String> temporaryObservableList = FXCollections.observableArrayList(temporaryList);
            infoList.setItems(temporaryObservableList);
            in.close();
             */
            fileIn.close();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }


}
