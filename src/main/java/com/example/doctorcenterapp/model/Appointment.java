package com.example.doctorcenterapp.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "appointment")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String appointmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "regtime")
    @Transient
    private String dateOfCreation;

    @Column(name = "date")
    private String dateOfRegistration;

    @Column(name = "time")
    private String time;

    @Column(name = "prim")
    private String prim;
}
