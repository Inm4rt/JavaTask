package com.example.task.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;

import java.io.Serial;


public class Persen {
    @NotNull
    @Serial
    int id;
    @NotNull
    @Size(min=2,max=30)
    String firstName;

    @NotNull
    @Size(min=2,max=30)
    String lastName;

    @NotNull
    @Min(1)
    @Max(150)
    int age;

    @NotNull
    @Min(1)
    @Max(100)
    double mark;

    @NotNull
    boolean education;

    @NotNull
    char category;

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public Persen(){}
    public Persen(int id,String firstName, String lastName, int age, double mark, boolean education, char category){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mark = mark;
        this.education = education;
        this.category = category;
    }

    public int getId() {
        return id;
    }


    public boolean isEducation() {
        return education;
    }

    public void setEducation(boolean education) {
        this.education = education;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
