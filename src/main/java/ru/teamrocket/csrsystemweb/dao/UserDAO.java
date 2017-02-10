package ru.teamrocket.csrsystemweb.dao;

import ru.teamrocket.csrsystemweb.model.User;
import java.util.List;

/**
 * Created by Kate on 07.02.2017.
 */

public interface UserDAO {
    User getUserById(int id);
    List<User> getUsers();
    void createUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
}
