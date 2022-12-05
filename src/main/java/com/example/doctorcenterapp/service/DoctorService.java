package com.example.doctorcenterapp.service;

import com.example.doctorcenterapp.mapper.DoctorMapper;
import com.example.doctorcenterapp.mapper.UserMapper;
import com.example.doctorcenterapp.model.Department;
import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.dto.DoctorDto;
import com.example.doctorcenterapp.model.dto.UserDto;
import com.example.doctorcenterapp.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public DoctorDto getDoctorById(String id) {
        return doctorRepository.findById(id)
                .map(DoctorMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    public List<DoctorDto> getAllDoctors() {
        List<DoctorDto> doctorDtos = doctorRepository.findAll().stream()
                .map(DoctorMapper::toDto)
                .toList();

        List<Doctor> all = doctorRepository.findAll();
        List<DoctorDto> allDto = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            allDto.add(DoctorMapper.toDto(all.get(i)));
        }

        return allDto;
    }

    public DoctorDto updateDoctor(Doctor doctor) {
        if(doctorRepository.findById(doctor.getDoctorId()).isPresent()) {
            Doctor savedDoctor = doctorRepository.save(doctor);

            return Optional.ofNullable(savedDoctor)
                    .map(DoctorMapper::toDto)
                    .orElseThrow(() -> new NoSuchElementException(""));
        } else {
            return null;
        }
    }


//    public DoctorDto getDoctorByDepartment(Department department) {
//        return doctorRepository.findDoctorByDepartment(department)
//                .map(doctorMapper::toDto)
//                .orElseThrow(() -> new NoSuchElementException(""));
//    }
}
