package com.example.doctorcenterapp.mapper;

import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.dto.DoctorDto;

public class DoctorMapper {

    private DoctorMapper() {
    }

    public static DoctorDto toDto(Doctor doctor) {
        return DoctorDto.builder()
                .fullName(String.format("%s %s %s", doctor.getLastName(), doctor.getFirstName(), doctor.getMiddleName()))
                .gender(doctor.getGender())
//                .departmentName(doctor.getDepartment().getDepartmentName())
                .build();
    }
}
