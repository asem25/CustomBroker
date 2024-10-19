package org.semavin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public  class RunnerApp {
    public static void main(String[] args) {
        SpringApplication.run(RunnerApp.class, args);
    }
}
