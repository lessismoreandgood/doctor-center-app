package com.example.doctorcenterapp.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    @Column(name = "username", nullable = false, unique = true)
    @NonNull()
    private String email;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "password")
    @Transient
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_active")
    private boolean isActive;
}
