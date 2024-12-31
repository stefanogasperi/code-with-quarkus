package com.gas.edu.service.reactor;

import com.gas.edu.qdbs.model.dto.IncomingMessageReply;
import com.gas.edu.service.MessageService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.stream.IntStream;

@ApplicationScoped
public class MessageReactorService {
    private final MessageService messageService;

    @Inject
    public MessageReactorService(MessageService messageService) {
        this.messageService = messageService;
    }

    public Uni<IncomingMessageReply> produceUni(final String input) {
        return Uni.createFrom()
                .item(IncomingMessageReply::new)
                .map(m -> {
                    m.setMessage(input);
                    m.setId((new Random()).nextLong(90));
                    return m;
                });
    }

    /**
     * si legge con
     * curl -N http://localhost:8080/message/reactor/multi?message=provaaareact
     * da cmd. Con console intellij e powershell non funziona
     */
    public Multi<IncomingMessageReply> produceMulti(final String input) {
        return Multi.createFrom()
//                .items(IntStream.range(0,10))
//                .map(i -> {
//                    IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
//                    incomingMessageReply.setMessage(input+" - "+i);
//                    incomingMessageReply.setId((new Random()).nextLong(90));
//                    return incomingMessageReply;
//                });
                .ticks().every(Duration.ofSeconds(1))
                .map(i -> {
                    IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
                    incomingMessageReply.setMessage(input+" - "+i);
                    incomingMessageReply.setId((new Random()).nextLong(90));
                    if (i==10) throw new RuntimeException("10 tick! esco");
                    return incomingMessageReply;
                });
    }
}
