package com.codingart.mycompta.service.client;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.repository.client.ClientRepository;
import com.codingart.mycompta.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final String message = "Client not found for this id :: ";


    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);

    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient( Long id, Client client) {
        clientRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        client.setId(id);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        clientRepository.deleteById(id);
    }

}
