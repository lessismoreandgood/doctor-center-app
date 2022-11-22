package com.example.doctorcenterapp.kafka;

import com.example.doctorcenterapp.model.AppointmentMessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.doctorcenterapp.utils.SendEmailSSL.sendEmail;

@Log4j2
@Service
public class KafkaConsumer {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @KafkaListener(topics = "doctor_events", groupId = "group_id")
    public void handleEmailNotificationForAppointment(String message) throws JsonProcessingException {
        log.info("Message received -> %s" + message);
        AppointmentMessageDto messageDto = objectMapper.readValue(message, AppointmentMessageDto.class);

        if (!Optional.ofNullable(messageDto).isPresent()) {
            log.error("message is empty");
            return;
        }

        if (!messageDto.isConfirmed()) {
            sendEmail(messageDto.getDoctorEmail(), "Appointment created", "Dear doctor, appointment with id" + messageDto.getAppointmentId()
                    + " has been created, please, wait until our doctors confirm"
            );
            sendEmail(messageDto.getUserEmail(), "Appointment created", "Dear client, your appointment with id" + messageDto.getAppointmentId()
                    + " has been created, please, wait until our doctors confirm");
        } else {
            sendEmail(messageDto.getUserEmail(), "Appointment created", "Dear client, your appointment with id" + messageDto.getAppointmentId()
                    + " has been confirmed");
        }
    }

}
