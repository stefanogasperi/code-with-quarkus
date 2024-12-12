package com.gas.edu.qdbs.web;

import com.gas.edu.qdbs.model.dto.IncomingMessage;
import com.gas.edu.qdbs.model.dto.IncomingMessageReply;
import com.gas.edu.qdbs.model.dto.IncomingMessageReplyList;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.ArrayList;
import java.util.List;

@Path("/api/incoming-one")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncomingOne {

    @POST
    @Operation(summary = "send an incoming message")
    @APIResponse(responseCode = "200", description = "Ok")
    @APIResponse(responseCode = "500", description = "Internal Error")
    @Path("/qppp/{pp}")
    //public Response createMessage(@QueryParam("incomingMessage") IncomingMessage incomingMessage) {
    public Response createMessage(
            @Parameter(name = "incomingMessage", description = "il messaggio in input", required = true)
            @QueryParam(value = "id") List<String> listqp,
            @PathParam(value = "pp") String singlepp,
            @RequestBody IncomingMessage incomingMessage) {
    //    IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
//        incomingMessageReply.setMessage(String.format("===> n:%s s:%s",incomingMessage.getName(),incomingMessage.getSurname()));
        List<IncomingMessageReply> retv = new ArrayList<>();
        IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage("sg3");
        incomingMessageReply.setId(3L);
        retv.add(incomingMessageReply);
        incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage(incomingMessage.getName()+incomingMessage.getSurname());
        incomingMessageReply.setId(1L);
        retv.add(incomingMessageReply);

        return Response.ok().entity(retv).build();
        //return incomingMessageReply;
    }
    /*
    @PUT
    public Response resendMessage(@QueryParam("incomingMessage") IncomingMessage incomingMessage) {
        IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage(String.format("===> n:%s s:%s",incomingMessage.getName(),incomingMessage.getSurname()));
        return Response.ok().build();
    }

    @PATCH
    public Response updateMessage(@QueryParam("incomingMessage") IncomingMessage incomingMessage) {
        IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage(String.format("===> n:%s s:%s",incomingMessage.getName(),incomingMessage.getSurname()));
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public IncomingMessageReply updateMessage(@RestPath Integer id) {
        IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage(String.format("===> n:%s s:%s","nome"+id, "cognome1"+id));
        return incomingMessageReply;
    }

    @GET
    public IncomingMessageReplyList queryUser(@QueryParam String search) {
        IncomingMessageReplyList incomingMessageReplyList = new IncomingMessageReplyList();

        IncomingMessageReply incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage(String.format("===> n:%s s:%s","nome"+1, "cognome"+1));
        List<IncomingMessageReply> l = new ArrayList<>();
        l.add(incomingMessageReply);
        incomingMessageReply = new IncomingMessageReply();
        incomingMessageReply.setMessage(String.format("===> n:%s s:%s","nome"+2, "cognome"+2));
        l.add(incomingMessageReply);

        incomingMessageReplyList.setItems(l);
        return incomingMessageReplyList;
    }
    */
}
