package org.semavin.app.models;


import org.springframework.stereotype.Component;
import ru.semavin.app.annotantions.Subscriber;
import ru.semavin.app.models.Message;


@Subscriber(topic = "TopicTest")
@Component
public class TestSubscriber {
    public void subscribe(Message message){
        System.out.println("Publish message " + message.getMessage());
    }
}
