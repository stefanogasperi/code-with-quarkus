package com.gas.edu.qdbs.service;

import io.smallrye.common.annotation.Identifier;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;

@ApplicationScoped
public class Serv {

    @Inject
    ConnectionFactory connectionFactory1;

    void init1(@Observes @Initialized(ApplicationScoped.class) Object init) {
        connectionFactory1.hashCode();
        System.out.println("init1111");
    }
    @PostConstruct
    void init(){
        connectionFactory1.hashCode();
        System.out.println("postcont111");
    }
}
