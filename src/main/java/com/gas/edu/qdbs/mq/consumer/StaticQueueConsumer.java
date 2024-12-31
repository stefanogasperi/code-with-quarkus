package com.gas.edu.qdbs.mq.consumer;

import com.gas.edu.conf.GroupConfVal;
import com.gas.edu.conf.GroupConfigurations;
import com.gas.edu.qdbs.service.Serv;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.MutinyEmitter;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
@JBossLog
public class StaticQueueConsumer {
    @ConfigProperty(name = "com.gas.edu.project")
    String envFileProp;

    @Inject
    GroupConfigurations group;

    private final MutinyEmitter<String> emitter;
    private final Serv serv;

    private final ConnectionFactory connectionFactory10;
    @Inject
    public StaticQueueConsumer(@Channel("static_queue2") MutinyEmitter<String> emitter, Serv serv, ConnectionFactory connectionFactory10) {
        this.emitter = emitter;
        this.serv = serv;
        this.connectionFactory10 = connectionFactory10;
    }

    @Blocking(value = "static_queue1", ordered = false)
    @ActivateRequestContext //serve per dare al consumer lo scope requeest altrimenti nn vedrebbe i bean in quell oscope!
                            // (ma non basterebbe mettere @RequestScoped? e no perchè la classe è @ApplicationScoped per il consumer è uno! mica uno ad ogni richiesta!
    @Incoming("requestchnnl")
    @Transactional
    //public CompletionStage<String> consume(final Message<String> in) {
    public Uni<Void> consume(final Message<String> in) {
        String pl = in.getPayload();
        log.info("PL: " + pl);
        log.info("connectionFactory10.hashCode()>"+connectionFactory10.hashCode());
        Uni<Void> uni = emitter.send(in.getPayload());

        log.info("envFileProp:{}"+envFileProp);
        log.info("1.1:"+group.namedConfigs().get(GroupConfVal.groupOne).uno());
        log.info("1.2:"+group.namedConfigs().get(GroupConfVal.groupOne).due());
        log.info("1.3:"+group.namedConfigs().get(GroupConfVal.groupOne).tre());
        log.info("1.4:"+group.namedConfigs().get(GroupConfVal.groupOne).quattro());
        log.info("2.1:"+group.namedConfigs().get(GroupConfVal.groupTwo).uno());
        log.info("2.2:"+group.namedConfigs().get(GroupConfVal.groupTwo).due());
        log.info("2.3:"+group.namedConfigs().get(GroupConfVal.groupTwo).tre());
        log.info("2.4:"+group.namedConfigs().get(GroupConfVal.groupTwo).quattro());
        return uni;
    }
}
