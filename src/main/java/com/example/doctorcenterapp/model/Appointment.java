package com.example.doctorcenterapp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "appointment")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String appointmentId;

    @Column(name = "time")
    private String time;

    @Column(name = "prim")
    private String prim;

    @ManyToOne
    @JoinColumn(name = "user_appointment_id")
    private User userList;

    @ManyToOne
    @JoinColumn(name = "doctor_appointment_id")
    private Doctor doctorList;

    @Column(name = "is_confirmed")
    private boolean confirmed;
}
