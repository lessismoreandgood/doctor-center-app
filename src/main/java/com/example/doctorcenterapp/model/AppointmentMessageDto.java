package com.example.doctorcenterapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentMessageDto {

    private String userEmail;
    private String doctorEmail;
    private String appointmentId;
    private String appointmentDate;
    private boolean isConfirmed;
}
