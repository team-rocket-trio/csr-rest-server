package ru.teamrocket.csrsystemweb.service;

import com.sun.jersey.api.NotFoundException;
import ru.teamrocket.csrsystemweb.dao.ClientDAOImpl;
import ru.teamrocket.csrsystemweb.model.Client;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kate on 26.01.2017.
 */

@Path("/clients")
public class ClientServiceImpl implements ClientService {

    private ClientDAOImpl clientDAO = new ClientDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getClients() {
        List<Client> clients = clientDAO.getClients();
        if (clients == null) {
            throw new NotFoundException("Clients are not found");
        }
        GenericEntity<List<Client>> generic = new GenericEntity<List<Client>>(clients){};
        return Response.ok(generic).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Client getClientById(@PathParam("id") int id) {
        Client client = clientDAO.getClientById(id);
        if (client == null) {
            throw new NotFoundException("Client " + id + " is not found");
        }
        return client;
    }


    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertClient(Client client) {
        if (client == null) {
            throw new NotFoundException("Client is null");
        }
        clientDAO.createClient(client);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteClient(@PathParam("id") int id) {
        clientDAO.deleteClient(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateClient(Client client){
        clientDAO.updateClient(client);
        if (client == null) {
            throw new NotFoundException("Client " + client.getClientId() + " is not found");
        }
        return Response.status(Response.Status.OK).build();
    }

}
