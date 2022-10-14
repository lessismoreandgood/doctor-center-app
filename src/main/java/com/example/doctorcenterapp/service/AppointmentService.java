package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.model.Appointment;
import com.example.doctorcenterapp.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public Appointment getAppointmentById(String id) {
        return appointmentRepository.findByAppointmentId(id);
    }
}