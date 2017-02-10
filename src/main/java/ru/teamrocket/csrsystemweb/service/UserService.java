package ru.teamrocket.csrsystemweb.service;

import ru.teamrocket.csrsystemweb.model.User;
import javax.ws.rs.core.Response;

/**
 * Created by Kate on 07.02.2017.
 */

public interface UserService {
    User getUserById(int id);
    Response getUsers();
    Response insertUser(User user);
    Response deleteUser(int id);
    Response updateUser(User user);
}
