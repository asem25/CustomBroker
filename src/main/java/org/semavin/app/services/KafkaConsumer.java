package org.semavin.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.*;
import java.util.ArrayList;

@Service
@Slf4j
public class KafkaConsumer {
    private final List<String> mess = Collections.synchronizedList(new ArrayList<>());
    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listen(String messages){
        mess.add(messages);
        log.info("Message listen: " + messages);
    }
    public List<String> getMess(){
        return new ArrayList<>(mess);
    }
}
