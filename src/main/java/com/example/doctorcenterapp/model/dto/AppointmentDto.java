package com.example.doctorcenterapp.model.dto;

import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {

    private String appointmentId;

    private String email;

    private String dateOfRegistration;

    private String time;

    private String userName;

    private String doctorName;
}
