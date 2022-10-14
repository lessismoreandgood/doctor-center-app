package com.example.doctorcenterapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String userId;

    private String email;

    private String firstName;

    private String lastName;

    private String gender;
}
