package com.example.doctorcenterapp.controller;

import com.example.doctorcenterapp.model.Doctor;
import com.example.doctorcenterapp.model.dto.DoctorDto;
import com.example.doctorcenterapp.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Component
@Path("/doctors")
@RequiredArgsConstructor
public class DoctorControllerV2 {
    private final DoctorService doctorService;

    @Path("/all")
    @GET
    @Produces(APPLICATION_JSON)
    public List<DoctorDto> getDoctorByIdV2() {
        return doctorService.getAllDoctors();
    }

    @Path("/")
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public DoctorDto getDoctorByIdV2(Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
}
