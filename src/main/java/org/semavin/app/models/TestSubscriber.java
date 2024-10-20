package org.semavin.app.models;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.semavin.app.annotantions.Subscriber;
import ru.semavin.app.models.Message;


@Subscriber(topic = "TopicTest")
@Component
@Slf4j
public class TestSubscriber {
    public void subscribe(Message message){
        log.info("Publish message " + message.getMessage());
    }
}
