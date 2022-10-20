package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.model.dto.UserDto;
import com.example.doctorcenterapp.service.AppointmentService;
import com.example.doctorcenterapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;
    private AppointmentService appointmentService;

    @GetMapping("/index")
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
}
