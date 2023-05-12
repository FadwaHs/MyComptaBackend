package com.codingart.mycompta.service.client;

import com.codingart.mycompta.dto.ClientDto;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;

import java.util.List;
import java.util.Map;

public interface ClientService {
    Client addClient(Client client);
    ClientDto getClient(Long id);
    List<Client> getAllClient();
    Map<String,Object> getListClients(String data, int page, int size);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
    List<Client> getAllClientPar();
    List<Client> getAllClientPro();
    List<Client> getAllByIdAndFirstNameAndLastName();

    List<Opportunite> getOpportunitesForClient(Long id);

    List<Devis> getDevisForClient(Long id);
}
