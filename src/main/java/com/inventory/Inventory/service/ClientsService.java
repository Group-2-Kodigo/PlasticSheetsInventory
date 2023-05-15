package com.inventory.Inventory.service;

import ch.qos.logback.core.net.server.Client;
import com.inventory.Inventory.model.Clients;
import com.inventory.Inventory.model.StatusU;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface ClientsService {

    String saveClients(Clients clients);

    public List<Clients> getAllClients();

    Clients getClientByID(Integer id_client);

    Clients updateClient(Clients newClient, Integer id_client);

    String deleteClient(Integer id_client);

    Clients findByEmail(String email);
}
