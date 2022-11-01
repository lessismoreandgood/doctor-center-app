package com.example.doctorcenterapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Table(name = "doctor")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
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
}
