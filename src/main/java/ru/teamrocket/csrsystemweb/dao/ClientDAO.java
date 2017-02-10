package ru.teamrocket.csrsystemweb.dao;

import ru.teamrocket.csrsystemweb.model.Client;

import java.util.List;

/**
 * Created by Kate on 27.01.2017.
 */

public interface ClientDAO {
    Client getClientById(int id);
    List<Client> getClients();
    void createClient(Client client);
    void deleteClient(int id);
    void updateClient(Client client);
}
