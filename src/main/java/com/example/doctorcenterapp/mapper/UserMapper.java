package com.example.doctorcenterapp.mapper;

import com.example.doctorcenterapp.model.User;
import com.example.doctorcenterapp.model.dto.UserDto;

public class UserMapper {

    private UserMapper() {
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
    }
}
