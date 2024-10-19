package ru.semavin.app.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.semavin.app.config.MessageBroker;
import ru.semavin.app.models.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@RequiredArgsConstructor
public class SubscriberContainer {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final MessageBroker messageBroker;

    @PostConstruct
    private void init(){
        executorService.submit(()->{
            for (String topic : SubscriberBeanPostProcessor.topics) {
                for (Message message : messageBroker.getMessagesForTopic(topic)) {
                    messageBroker.notifySubscribers(topic, message);
                }
            }
        });
    }
}
