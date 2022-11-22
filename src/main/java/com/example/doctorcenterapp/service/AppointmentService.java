package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.kafka.KafkaRunner;
import com.example.doctorcenterapp.mapper.AppointmentMapper;
import com.example.doctorcenterapp.model.*;
import com.example.doctorcenterapp.model.dto.AppointmentDto;
import com.example.doctorcenterapp.repository.AppointmentRepository;
import com.example.doctorcenterapp.repository.DoctorRepository;
import com.example.doctorcenterapp.repository.ReviewRepository;
import com.example.doctorcenterapp.repository.UserRepository;
import com.example.doctorcenterapp.utils.SendEmailSSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.doctorcenterapp.utils.SendEmailSSL.sendEmail;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final ReviewRepository reviewRepository;

    public AppointmentDto getAppointmentById(String id) {
        return appointmentRepository.findByAppointmentId(id)
                .map(AppointmentMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no appointment with this appointmentId: %s", id)));
    }

    public AppointmentDto saveAppointment(Appointment appointment) {
        User user = userRepository.findById(appointment.getUserList().getUserId()).orElseGet(() -> userRepository.save(appointment.getUserList()));
        Doctor doctor = doctorRepository.findById(appointment.getDoctorList().getDoctorId()).orElseGet(() -> doctorRepository.save(appointment.getDoctorList()));

        appointment.setConfirmed(false);
        Appointment savedAppointment = appointmentRepository.save(appointment);

        AppointmentDto response = Optional.of(savedAppointment)
                .map(AppointmentMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(""));

        String userList = user.getEmail();
        String doctorList = doctor.getEmail();

        AppointmentMessageDto messageDto = AppointmentMessageDto.builder()
                .userEmail(userList)
                .doctorEmail(doctorList)
                .appointmentId(appointment.getAppointmentId())
                .isConfirmed(false)
                .build();

        KafkaRunner.start(messageDto);
        return response;
    }

    public List<AppointmentDto> getAppointmentsByUserId(String id) {
        return appointmentRepository.findAppointmentByUserList(id).stream()
                .map(AppointmentMapper::toDto)
                .collect(Collectors.toList());

    }

    public List<AppointmentDto> getAppointmentsByDoctorId(String doctorId) {
        return appointmentRepository.findAppointmentByDoctorList(doctorId).stream()
                .map(AppointmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public AppointmentDto confirmAppointment(String appointmentId) {
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId)
                .orElse(null);
        if (Optional.ofNullable(appointment).isPresent()) {
            appointment.setConfirmed(true);
            appointmentRepository.save(appointment);
            User userList = appointment.getUserList();
            if (userList != null) {
                sendEmail(userList.getEmail(), "Appointment confirmed", "Dear client, your appointment with id" + appointment.getAppointmentId()
                        + " has been confirmed");
            }
            return Optional.of(appointment)
                    .map(AppointmentMapper::toDto)
                    .orElseThrow(() -> new IllegalStateException());
        }

        return null;
    }

    public Review createReview(Review review) {
        Review savedReview;
        if (review != null) {
            savedReview = reviewRepository.save(review);
        } else {
            savedReview = null;
        }

        return savedReview;
    }
}