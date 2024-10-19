package ru.semavin.app.models;

import lombok.RequiredArgsConstructor;
import ru.semavin.app.config.MessageBroker;

import javax.print.attribute.standard.JobKOctets;

@RequiredArgsConstructor
public class Publisher {
    private final MessageBroker messageBroker;
    public void publish(Message message){
        messageBroker.publishMessage(message);
    }
}
