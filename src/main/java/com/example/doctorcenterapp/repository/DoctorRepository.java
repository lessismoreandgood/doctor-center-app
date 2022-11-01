package com.example.doctorcenterapp.repository;

import com.example.doctorcenterapp.model.Department;
import com.example.doctorcenterapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
