package com.example.doctorcenterapp.repository;

import com.example.doctorcenterapp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    Optional<Appointment> findByAppointmentId(String id);

    List<Appointment> findAppointmentByUserList(String id);

    List<Appointment> findAppointmentByDoctorList(String id);
}