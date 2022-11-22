package com.example.doctorcenterapp.kafka;

import com.example.doctorcenterapp.model.AppointmentMessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaRunner {
    private static KafkaProducer kafkaProducer;
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Autowired
    public KafkaRunner(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public static void start(AppointmentMessageDto messageDto){
        try {
            kafkaProducer.sendMessage(objectMapper.writeValueAsString(messageDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
