package ru.semavin.app.config;


import lombok.NoArgsConstructor;

import ru.semavin.app.models.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

@NoArgsConstructor
public class MessageBroker {

    private final Map<String, List<Object>> subscribers = new HashMap<>();
    private final Map<String, Queue<Message>> messages = new HashMap<>();

    public void registerSubscriber(String topic, Object subscriber) {
        subscribers.computeIfAbsent(topic, k -> new LinkedList<>()).add(subscriber);
        messages.computeIfAbsent(topic, k -> new LinkedBlockingQueue<>());
        System.out.println("Subscriber reg for topic: " + topic);
    }
    public void publishMessage(Message message) {
        String topic = message.getTopic();
        Queue<Message> queue = messages.get(topic);
        if (queue != null) {
            queue.offer(message);
            System.out.println("Message published to topic: " + topic);
        } else {
            System.out.println("No queue for topic: " + topic);
        }
    }
    public void notifySubscribers(String topic, Message message) {
        List<Object> topicSubscribers = subscribers.get(topic);
        if (topicSubscribers.isEmpty()){
            System.out.println("No Subscribers for this topic:" + topic);
        }
        for (Object subscriber : topicSubscribers) {
            try {
                Method publish = subscriber.getClass().getMethod("subscribe", Message.class);
                publish.invoke(subscriber, message);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public List<Message> getMessagesForTopic(String topic){
        Queue<Message> message = messages.get(topic);
        return message.isEmpty() ? Collections.emptyList() : new ArrayList<>(message);
    }
}
