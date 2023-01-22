package com.example.task.model;

import com.example.task.validator.NameConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
