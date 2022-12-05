package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.dto.DoctorDto;
import com.example.doctorcenterapp.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/")
    public ResponseEntity<DoctorDto> createUser(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.OK);
    }


    @GetMapping("/")
    public String getDoctorByIdV2(@RequestParam(value = "id") String id,
                                  Model model) {
        DoctorDto doctorById = doctorService.getDoctorById(id);
        model.addAttribute("doctorById", doctorById);

        return "doctor";
    }
}
