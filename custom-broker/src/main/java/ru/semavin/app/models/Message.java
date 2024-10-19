package ru.semavin.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter @Setter @Jacksonized @Builder @AllArgsConstructor
public class Message {
    private String topic;
    private String message;

}
