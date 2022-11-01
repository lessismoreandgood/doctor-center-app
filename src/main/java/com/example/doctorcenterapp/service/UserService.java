package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.mapper.UserMapper;
import com.example.doctorcenterapp.model.User;
import com.example.doctorcenterapp.model.dto.UserDto;
import com.example.doctorcenterapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto saveUser(User user) {
        user.setUserId(String.valueOf(System.currentTimeMillis()));
        User savedUser = userRepository.save(user);
        return Optional.ofNullable(savedUser)
                .map(UserMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    public UserDto getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no user with email: %s", email)));
    }

    public List<UserDto> getAllAttachedUsers() {
        return userRepository.findAll().stream()
                .filter(User::getIsAttached)
                .map(UserMapper::toDto)
                .toList();
    }

    public void removeUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDto)
                .toList();
    }
}