package com.example.doctorcenterapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "_user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String doctorId;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "password")
    @Transient
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "department")
    private String department;
}
