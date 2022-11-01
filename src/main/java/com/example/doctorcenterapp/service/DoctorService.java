package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.mapper.DoctorMapper;
import com.example.doctorcenterapp.model.Department;
import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.dto.DoctorDto;
import com.example.doctorcenterapp.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorDto saveDoctor(Doctor doctor) {
        doctor.setDoctorId(String.valueOf(System.currentTimeMillis()));
        Doctor savedDoctor = doctorRepository.save(doctor);
        return Optional.ofNullable(savedDoctor)
                .map(DoctorMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

//    public DoctorDto getDoctorByDepartment(Department department) {
//        return doctorRepository.findDoctorByDepartment(department)
//                .map(doctorMapper::toDto)
//                .orElseThrow(() -> new NoSuchElementException(""));
//    }
}
