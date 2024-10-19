package org.semavin.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.semavin.app.config.MessageBroker;
import ru.semavin.app.models.Message;
import ru.semavin.app.models.Publisher;
import ru.semavin.app.util.SubscriberBeanPostProcessor;
import ru.semavin.app.util.SubscriberContainer;

@Configuration
public class AppConfig {
    @Bean
    public SubscriberBeanPostProcessor beanPostProcessor(MessageBroker messageBroker){
        return new SubscriberBeanPostProcessor(messageBroker);
    }
    @Bean
    public MessageBroker messageBroker(){
        return new MessageBroker();
    }
    @Bean
    public Publisher publisher(MessageBroker messageBroker){
        return new Publisher(messageBroker);
    }
    @Bean
    public SubscriberContainer subscriberContainer(MessageBroker messageBroker){
        return new SubscriberContainer(messageBroker);
    }
}
