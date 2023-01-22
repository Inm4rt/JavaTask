package com.example.task.dto;

import com.example.task.validator.NameConstraint;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonDto {
    private long id;
    @NotNull
    @Size(min = 2, max = 30)
    @NameConstraint
    private String firstName;
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    @NotNull
    @Min(1)
    @Max(150)
    private int age;
    @NotNull
    @Min(1)
    @Max(100)
    private double mark;
    @NotNull
    private boolean education;
    @NotNull
    private char category;
}
