package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.aspects.LogBefore;
import com.example.doctorcenterapp.model.Appointment;
import com.example.doctorcenterapp.model.Review;
import com.example.doctorcenterapp.model.dto.AppointmentDto;
import com.example.doctorcenterapp.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor
@LogBefore
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(summary = "getAppointmentById")
    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable String appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }

    @Operation(summary = "getAppointmentsByUserId")
    @GetMapping("/userId")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByUserId(userId), HttpStatus.OK);
    }

    @Operation(summary = "getAppointmentsByDoctorId")
    @GetMapping("/doctorId")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByDoctorId(@PathVariable String doctorId) {
        return new ResponseEntity<>(appointmentService.getAppointmentsByDoctorId(doctorId), HttpStatus.OK);
    }

    @Operation(summary = "saveAppointment")
    @PostMapping("/save")
    public ResponseEntity<AppointmentDto> saveAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.saveAppointment(appointment), HttpStatus.OK);
    }

    @Operation(summary = "confirmAppointment")
    @PostMapping("/confirm")
    public ResponseEntity<AppointmentDto> confirmAppointment(@RequestParam String appointmentId) {
        AppointmentDto appointmentDto = appointmentService.confirmAppointment(appointmentId);

        if (appointmentDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
    }

    @Operation(summary = "leaveAReview")
    @PostMapping("user/review")
    public ResponseEntity<Review> leaveAReview(@RequestBody Review review) {
        Review serviceReview = appointmentService.createReview(review);

        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(serviceReview, HttpStatus.OK);
    }
}
