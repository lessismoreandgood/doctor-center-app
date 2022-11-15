package com.example.doctorcenterapp.endpoint;

import com.example.doctorcenterapp.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class DoctorEndpoint {

    private final DoctorService service;
    private static final String NAMESPACE = "http://interfaces.soap.springboot.nnz.com";

    @PayloadRoot(namespace = NAMESPACE, localPart = "getDoctorByIdRequest")
    @ResponsePayload
    public GetDoctorResponse getDoctor(@RequestPayload GetDoctorByIdRequest request) {
        GetDoctorResponse response = new GetDoctorResponse();
        DoctorInfo doctor = new DoctorInfo();
        BeanUtils.copyProperties(service.getDoctorById(request.getDoctorId()), doctor);
        response.setDoctorInfo(doctor);
        return response;
    }

}
