package com.example.task.dto;

import lombok.Data;

@Data
public class PersonDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private double mark;
    private boolean education;
    private char category;
}
