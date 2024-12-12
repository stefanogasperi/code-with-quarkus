package com.gas.edu.qdbs.web;

import com.gas.edu.qdbs.model.dto.IncomingMessage;
import com.gas.edu.qdbs.model.dto.IncomingMessageReply;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;


@Path("/api/incoming-one")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncomingOne {

    @POST
    @Operation(summary = "send an incoming message")
    @APIResponse(responseCode = "200", description = "Ok")
    @APIResponse(responseCode = "500", description = "Internal Error")
    @Path("/mqtemporary")
    public Response createMessage (
            IncomingMessage incomingMessage) {
            String amqMessage = String.format("===> n:%s s:%s",incomingMessage.getName(),incomingMessage.getSurname());
            IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
            incomingMessageReply.setMessage(amqMessage);
            incomingMessageReply.setId(1L);
        return Response.ok().entity(incomingMessageReply).build();
    }
}
