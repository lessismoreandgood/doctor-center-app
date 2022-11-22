package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.dto.DoctorDto;
import com.example.doctorcenterapp.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @Operation(summary = "createUser")
    @PostMapping("/")
    public ResponseEntity<DoctorDto> createUser(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.OK);
    }

    @Operation(summary = "getDoctorById")
    @GetMapping("/doctorId")
    public ResponseEntity<DoctorDto> getDoctorById(@RequestParam String doctorId) {
        return new ResponseEntity<>(doctorService.getDoctorById(doctorId), HttpStatus.OK);
    }
}
