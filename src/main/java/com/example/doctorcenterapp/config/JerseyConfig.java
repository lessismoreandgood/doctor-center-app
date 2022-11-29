package com.example.doctorcenterapp.config;

import com.example.doctorcenterapp.controller.DoctorControllerV2;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    public void init(){

        register(DoctorControllerV2.class);
    }
}