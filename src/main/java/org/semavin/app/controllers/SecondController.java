package org.semavin.app.controllers;


import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.semavin.app.config.MessageBroker;
import ru.semavin.app.models.Message;
import ru.semavin.app.models.Publisher;

@RestController
@RequiredArgsConstructor
public class SecondController {
    private final Publisher supportPublisher;

    @PostMapping("/api")
    public HttpStatus postRequest(@RequestBody Message message){
        supportPublisher.publish(message);
        return HttpStatus.OK;
    }
}
