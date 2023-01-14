package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    Client getClient(Long id);
    List<Client> getAllClient();
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
