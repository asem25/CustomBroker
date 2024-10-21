package org.semavin.app.controllers;


import lombok.RequiredArgsConstructor;

import org.semavin.app.services.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecondController {
    private final KafkaProducer kafkaProducer;

    @PostMapping("/api")
    public HttpStatus postRequest(@RequestBody String message){
        kafkaProducer.send(message);
        return HttpStatus.OK;
    }
}
