package com.example.doctorcenterapp.mapper;

import com.example.doctorcenterapp.model.Appointment;
import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.User;
import com.example.doctorcenterapp.model.dto.AppointmentDto;

public class AppointmentMapper {

    private AppointmentMapper() {
    }

    public AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto.builder()
                .appointmentId(appointment.getAppointmentId())
                .email(appointment.getEmail())
                .userName(this.getNameOfAUser(appointment.getPatient()))
                .doctorName(this.getNameOfADoctor(appointment.getSubscribedDoctor()))
                .time(appointment.getTime())
                .dateOfRegistration(appointment.getDateOfRegistration())
                .build();
    }

    private String getNameOfADoctor(Doctor doctor) {
        return String.format("%s %s %s", doctor.getLastName(), doctor.getFirstName(), doctor.getMiddleName());
    }

    private String getNameOfAUser(User patient) {
        return String.format("%s %s %s", patient.getLastName(), patient.getFirstName(), patient.getMiddleName());
    }
}
