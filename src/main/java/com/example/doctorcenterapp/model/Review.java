package com.example.doctorcenterapp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "reviews")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String reviewId;

    @Size(max = 10)
    private Integer star;

    private String reviewText;

    @OneToOne
    private Appointment appointment;
}
