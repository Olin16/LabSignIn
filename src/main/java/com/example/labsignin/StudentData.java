package com.example.labsignin;

import javafx.scene.image.Image;

import java.util.ArrayList;


public class StudentData {
    ArrayList<StudentData> allStudents = new ArrayList<StudentData>();
    private String cte;
    private Integer grade;
    private String name;
    private Image image;

    public StudentData(String cte, Integer grade, String name, Image image) {
        this.cte = cte;
        this.grade = grade;
        this.name = name;
        this.image = image;
        allStudents.add(this);
    }

    public ArrayList<StudentData> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(ArrayList<StudentData> allStudents) {
        this.allStudents = allStudents;
    }

    public String getCte() {
        return cte;
    }

    public void setCte(String cte) {
        this.cte = cte;
    }

    public Integer getGrade() {return grade;}

    public void setGrade(Integer grade) {
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
}
