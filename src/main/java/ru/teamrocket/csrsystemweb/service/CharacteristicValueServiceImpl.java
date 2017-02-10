package ru.teamrocket.csrsystemweb.service;

import com.sun.jersey.api.NotFoundException;
import ru.teamrocket.csrsystemweb.dao.CharacteristicValueDAOImpl;
import ru.teamrocket.csrsystemweb.model.CharacteristicValue;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

@Path("/values")
public class CharacteristicValueServiceImpl implements CharacteristicValueService{

    private CharacteristicValueDAOImpl characteristicValueDAO = new CharacteristicValueDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCharacteristicValues() {
        List<CharacteristicValue> characteristicValues = characteristicValueDAO.getCharacteristicValues();
        if (characteristicValues == null) {
            throw new NotFoundException("CharacteristicValues are not found");
        }
        GenericEntity<List<CharacteristicValue>> generic = new GenericEntity<List<CharacteristicValue>>(characteristicValues){};
        return Response.ok(generic).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CharacteristicValue getCharacteristicById(@PathParam("id") int id) {
        CharacteristicValue characteristicValue = characteristicValueDAO.getCharacteristicValueById(id);
        if (characteristicValue == null) {
            throw new NotFoundException("CharacteristicValue " + id + " is not found");
        }
        return characteristicValue;
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertCharacteristicValue(CharacteristicValue characteristicValue) {
        if (characteristicValue == null) {
            throw new NotFoundException("CharacteristicValue is null");
        }
        characteristicValueDAO.createCharacteristicValue(characteristicValue);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteCharacteristicValue(@PathParam("id") int id) {
        characteristicValueDAO.deleteCharacteristicValue(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateCharacteristicValue(CharacteristicValue characteristicValue) {
        characteristicValueDAO.updateCharacteristicValue(characteristicValue);
        if (characteristicValue == null) {
            throw new NotFoundException("CharacteristicValue " + characteristicValue.getCharacteristicValueId() + " is not found");
        }
        return Response.status(Response.Status.OK).build();
    }
}
