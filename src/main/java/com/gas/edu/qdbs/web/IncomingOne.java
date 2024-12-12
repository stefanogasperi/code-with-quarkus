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
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

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
    @Path("/qppp/{xx}/{yy}")
    //public Response createMessage(@QueryParam("incomingMessage") IncomingMessage incomingMessage) {
    public Response createMessage(
            /*




             */
            @Parameter(name = "id-list", description = "la lista di id ?query", required = true)
            @RestQuery(value = "id1") List<String> listqp,
            //@Parameterserve solo a rseasy quarkusRest non lo rigetta! se lo metti non mostra il campo. Ci pensa lui a dare l'openapi descr.
            //@Parameter(name = "xx singolo", description = "singolo xx /path/", required = true)
            @RestPath String xx,
            //@Parameter(name = "yy singolo", description = "singolo yy /path/", required = true)
            @RestPath(value = "yy") String yy,

            //solo per restEasyserve requestBody! @RequestBody IncomingMessage incomingMessage) {
            IncomingMessage incomingMessage) {
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
