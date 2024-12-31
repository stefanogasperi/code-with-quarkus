package com.gas.edu.web;

import com.gas.edu.conf.GroupConfVal;
import com.gas.edu.conf.GroupConfiguration;
import com.gas.edu.conf.GroupConfigurations;
import com.gas.edu.conf.ServerConfigMap;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/check")
@JBossLog
public class Check {

    @Inject
    GroupConfigurations group1;
    @Inject
    GroupConfigurations group2;

    @Inject
    ServerConfigMap server;

    @Inject
    GroupConfigurations groupOneConfigurations;

    @GET
    @Operation(summary = "Say Hello")
    @APIResponse(responseCode = "200", description = "Ok")
    @APIResponse(responseCode = "500", description = "Internal Error")
    public Response sayHello() {
        String s = "Hello world group1: " + group1.namedConfigs().toString();
        s+=" Hello world group2: " + group2.namedConfigs().toString();
        s+=" Hello world server: " + server.host() + ":" + server.port() + " desc:" + server.desc();
        GroupConfiguration gc1 = groupOneConfigurations.namedConfigs().get(GroupConfVal.groupOne);
        GroupConfiguration gc2 = groupOneConfigurations.namedConfigs().get(GroupConfVal.groupTwo);
        s+=" groupConfiguration1: " + gc1.uno() + " - " + gc1.due() + " - " + gc1.tre() + " - " + gc1.quattro();
        s+=" groupConfiguration2: " + gc2.uno() + " - " + gc2.due() + " - " + gc2.tre() + " - " + gc2.quattro();
        return Response.ok().entity(s).build();
    }
}
