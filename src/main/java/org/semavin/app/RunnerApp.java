package org.semavin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public  class RunnerApp {
    public static void main(String[] args) {
        SpringApplication.run(RunnerApp.class, args);
    }
}
