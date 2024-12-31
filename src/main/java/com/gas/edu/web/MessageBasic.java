package com.gas.edu.web;

import com.gas.edu.qdbs.model.dto.IncomingMessageReply;
import com.gas.edu.service.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/message/basic")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageBasic {

    private final MessageService messageService;

    @Inject
    public MessageBasic(MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    @Operation(description = "desc: Message basic", summary = "summary: Message basic")
    @APIResponse(responseCode = "200", description = "all OK")
    @APIResponse(responseCode = "500", description = "server error")
    public IncomingMessageReply getReply(@RestQuery("message") String message) {
        return messageService.getReply("reply to: " + message);
    }

    @GET
    @Path("/r")
    @Operation(summary = "Message basic - jakarta Response")
    @APIResponse(responseCode = "200", description = "all OK")
    @APIResponse(responseCode = "500", description = "server error")
    public Response getReplyResponse(@RestQuery("message") String message) {
        return Response.ok().entity(
                messageService.getReply("reply to: " + message)
        ).build();
    }
}
