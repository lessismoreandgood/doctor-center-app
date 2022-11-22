package com.example.doctorcenterapp.repository;

import com.example.doctorcenterapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
