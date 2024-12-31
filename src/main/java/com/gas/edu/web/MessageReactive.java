package com.gas.edu.web;

import com.gas.edu.qdbs.model.dto.IncomingMessageReply;
import com.gas.edu.service.reactor.MessageReactorService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestSseElementType;
import org.jboss.resteasy.reactive.RestStreamElementType;

@Path("/message/reactor")
@Produces(MediaType.SERVER_SENT_EVENTS)
@RestStreamElementType(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageReactive {
    private final MessageReactorService messageReactorService;

    public MessageReactive(MessageReactorService messageReactorService) {
        this.messageReactorService = messageReactorService;
    }

    @GET
    @Path("/uni")
    @Operation(description = "desc: Message reactor", summary = "summary: Message reactor")
    @APIResponse(responseCode = "200", description = "all OK")
    @APIResponse(responseCode = "500", description = "server error")
    public Uni<IncomingMessageReply> getReply(@RestQuery("message") String message) {
        return messageReactorService.produceUni("reply to: " + message);
    }

    @GET
    @Path("/multi")
    @Operation(description = "desc: Message reactor", summary = "summary: Message reactor")
    @APIResponse(responseCode = "200", description = "all OK")
    @APIResponse(responseCode = "500", description = "server error")
    public Multi<IncomingMessageReply> getMultiReply(@RestQuery("message") String message) {
        return messageReactorService.produceMulti("reply to: " + message);
    }
}
