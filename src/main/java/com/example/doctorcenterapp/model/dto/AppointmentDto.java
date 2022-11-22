package com.example.doctorcenterapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {

    @JsonProperty("appointment_id")
    private String appointmentId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("date_of_registration")
    private String dateOfRegistration;

    @JsonProperty("time")
    private String time;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("doctor_name")
    private String doctorName;

    @JsonProperty("prim")
    private String prim;

    @JsonProperty("is_confirmed")
    private boolean isConfirmed;
}
