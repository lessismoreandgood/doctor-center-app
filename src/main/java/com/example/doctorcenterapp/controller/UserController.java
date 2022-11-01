package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.aspects.LogBefore;
import com.example.doctorcenterapp.model.User;
import com.example.doctorcenterapp.model.dto.UserDto;
import com.example.doctorcenterapp.service.AppointmentService;
import com.example.doctorcenterapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "/email")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/attached")
    public ResponseEntity<List<UserDto>> getAllAttachedUsers() {
        return new ResponseEntity<>(userService.getAllAttachedUsers(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<UserDto> removeUser(@RequestParam String userId) {
        userService.removeUser(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
