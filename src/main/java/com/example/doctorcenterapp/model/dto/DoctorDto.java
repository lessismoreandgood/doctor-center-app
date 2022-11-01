package com.example.doctorcenterapp.model.dto;

import com.example.doctorcenterapp.model.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDto {

    private String fullName;

    private String gender;

    private String departmentName;
}
