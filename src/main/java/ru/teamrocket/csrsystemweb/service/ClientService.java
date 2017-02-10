package ru.teamrocket.csrsystemweb.service;

import ru.teamrocket.csrsystemweb.model.Client;

import javax.ws.rs.core.Response;

/**
 * Created by Kate on 26.01.2017.
 */
public interface ClientService {
    Client getClientById(int id);
    Response getClients();
    Response insertClient(Client client);
    Response deleteClient(int id);
    Response updateClient(Client client);
}
