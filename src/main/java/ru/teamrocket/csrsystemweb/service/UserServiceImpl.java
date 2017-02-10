package ru.teamrocket.csrsystemweb.service;

import com.sun.jersey.api.NotFoundException;
import ru.teamrocket.csrsystemweb.dao.UserDAOImpl;
import ru.teamrocket.csrsystemweb.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kate on 07.02.2017.
 */

@Path("/users")
public class UserServiceImpl implements UserService{

    private UserDAOImpl userDAO = new UserDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {
        List<User> users = userDAO.getUsers();
        if (users == null) {
            throw new NotFoundException("Users are not found");
        }
        GenericEntity<List<User>> generic = new GenericEntity<List<User>>(users){};
        return Response.ok(generic).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getUserById(@PathParam("id") int id) {
        User user = userDAO.getUserById(id);
        if (user == null) {
            throw new NotFoundException("User " + id + " is not found");
        }
        return user;
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertUser(User user) {
        if (user == null) {
            throw new NotFoundException("User is null");
        }
        userDAO.createUser(user);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteUser(@PathParam("id") int id) {
        userDAO.deleteUser(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateUser(User user) {
        userDAO.updateUser(user);
        if (user == null) {
            throw new NotFoundException("User " + user.getUserId() + " is not found");
        }
        return Response.status(Response.Status.OK).build();
    }
}
