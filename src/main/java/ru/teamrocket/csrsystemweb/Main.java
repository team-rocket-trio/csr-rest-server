package ru.teamrocket.csrsystemweb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kate on 25.01.2017.
 */

@Path("/")
public class Main {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMessage(){
        return Response.status(200).entity("hello hello").build();
    }
}
