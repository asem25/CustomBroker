package ru.semavin.app.util;



import ru.semavin.app.annotantions.Subscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.semavin.app.config.MessageBroker;
import java.util.*;

@RequiredArgsConstructor
public class SubscriberBeanPostProcessor implements BeanPostProcessor {
    private final MessageBroker messageBroker;
    protected final static List<String> topics = new ArrayList<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Subscriber.class)){
            Subscriber subscriber = bean.getClass().getAnnotation(Subscriber.class);

            String topic = subscriber.topic();
            topics.add(topic);
            messageBroker.registerSubscriber(topic, bean);

            System.out.println("Subsriber " + beanName + " been register");
        }
        return bean;
    }


}
