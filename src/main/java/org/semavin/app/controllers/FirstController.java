package org.semavin.app.controllers;

import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import ru.semavin.app.models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.semavin.app.config.MessageBroker;

@RestController @RequiredArgsConstructor
public class FirstController {
    private final MessageBroker messageBroker;
    @GetMapping("/api")
    public List<Message> returnPhrase(@RequestBody Message message){
        return messageBroker.getMessagesForTopic(message.getTopic());
    }
}
