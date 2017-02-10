package ru.teamrocket.csrsystemweb.service;

import com.sun.jersey.api.NotFoundException;
import ru.teamrocket.csrsystemweb.dao.CharacteristicDAOImpl;
import ru.teamrocket.csrsystemweb.model.Characteristic;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

@Path("/characteristics")
public class CharacteristicServiceImpl implements CharacteristicService{

    private CharacteristicDAOImpl characteristicDAO = new CharacteristicDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCharacteristics() {
        List<Characteristic> characteristics = characteristicDAO.getCharacteristics();
        if (characteristics == null ) {
            throw new NotFoundException("Characteristics are not found");
        }
        GenericEntity<List<Characteristic>> generic = new GenericEntity<List<Characteristic>>(characteristics){};
        return Response.ok(generic).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Characteristic getCharacteristicById(@PathParam("id") int id) {
        Characteristic characteristic = characteristicDAO.getCharacteristicById(id);
        if (characteristic == null) {
            throw new NotFoundException("Characteristic " + id + " is not found");
        }
        return characteristic;
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertCharacteristic(Characteristic characteristic) {
        if (characteristic == null) {
            throw new NotFoundException("Characteristic is null");
        }
        characteristicDAO.createCharacteristic(characteristic);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCharacteristic(@PathParam("id") int id) {
        characteristicDAO.deleteCharacteristic(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateCharacteristic(Characteristic characteristic) {
        characteristicDAO.updateCharacteristic(characteristic);
        if (characteristic == null) {
            throw new NotFoundException("Characteristic " + characteristic.getCharacteristicId() + " is not found");
        }
        return Response.status(Response.Status.OK).build();
    }
}
