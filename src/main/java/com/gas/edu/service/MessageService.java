package com.gas.edu.service;

import com.gas.edu.qdbs.model.dto.IncomingMessageReply;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class MessageService {
    public IncomingMessageReply getReply(String input) {
        return IncomingMessageReply.builder()
                .message(input)
                .id((new Random()).nextLong(90))
                .build();
    }
}
