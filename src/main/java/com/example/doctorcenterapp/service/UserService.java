package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.mapper.UserMapper;
import com.example.doctorcenterapp.model.dto.UserDto;
import com.example.doctorcenterapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserDto getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no user with email: %s", email)));
    }
}