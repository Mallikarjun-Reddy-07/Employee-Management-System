package com.tcs.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @Email(message = "enter valid email id")
    @NotBlank(message = "it cannot be null,empty,space")
    private String email;

    @NotBlank(message = "it cannot be null,empty,space")
    private String name;

    @Positive(message = "salary should >=0")
    private double salary;

    @NotBlank(message = "it cannot be null,empty,space")
    private String department;
}
