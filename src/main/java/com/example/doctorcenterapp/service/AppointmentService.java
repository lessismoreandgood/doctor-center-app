package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.mapper.AppointmentMapper;
import com.example.doctorcenterapp.model.Appointment;
import com.example.doctorcenterapp.model.dto.AppointmentDto;
import com.example.doctorcenterapp.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;

    public AppointmentDto getAppointmentById(String id) {
        return appointmentRepository.findByAppointmentId(id)
                .map(appointmentMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no appointment with this appointmentId: %s", id)));
    }
}