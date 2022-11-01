package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.aspects.LogBefore;
import com.example.doctorcenterapp.model.dto.AppointmentDto;
import com.example.doctorcenterapp.service.AppointmentService;
import com.example.doctorcenterapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final UserService userService;
    private final AppointmentService appointmentService;

    @LogBefore
    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable String appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }
}
