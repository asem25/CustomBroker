package org.semavin.app.controllers;

import java.util.*;
import lombok.RequiredArgsConstructor;
import org.semavin.app.services.KafkaConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
public class FirstController {
    private final KafkaConsumer kafkaConsumer;
    @GetMapping("/api")
    public List<String> returnPhrase(){
        return kafkaConsumer.getMess();
    }
}
