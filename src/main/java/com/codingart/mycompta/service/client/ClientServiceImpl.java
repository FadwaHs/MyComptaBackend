package com.codingart.mycompta.service.client;


import com.codingart.mycompta.dto.ClientDto;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.repository.client.ClientRepository;
import com.codingart.mycompta.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private static Client currentClient;
    private final String message = "Client not found for this id :: ";

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);

    }

    @Override
    public ClientDto getClient(Long id) {
        currentClient =  clientRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        return modelMapper.map(currentClient,ClientDto.class);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Map<String, Object> getListClients(String data, int page, int size) {
        List<Client> clients ;
        Pageable paging = PageRequest.of(page, size);

        Page<Client> pageTuts;
        if (data == null)
            pageTuts = clientRepository.findAll(paging);
        else {
            pageTuts = clientRepository.findByDataContaining(data, paging);
        }
        clients = pageTuts.getContent();
        List<ClientDto> clientDtoList = clients.stream().map(p -> modelMapper.map(p,ClientDto.class)).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("clients", clientDtoList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
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

    @Override
    public List<Client> getAllClientPar() {
        return clientRepository.selectAllClientPar();
    }

    @Override
    public List<Client> getAllClientPro() {
        return clientRepository.selectAllClientPro();
    }

    @Override
    public List<Client> getAllByIdAndFirstNameAndLastName() {
        return clientRepository.selectAllByIdAndFirstNameAndLastName();
    }

   @Override
    public List<Opportunite> getOpportunitesForClient(Long id) {

        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isPresent()  ){

            Client client = clientOptional.get();

            client.initializeCollections();
            return client.getOpportuniteList();
        }
        return Collections.emptyList();
    }

  @Override
    public List<Devis> getDevisForClient(Long id) {

        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()  ){

            Client client = clientOptional.get();

            client.initializeCollections();
            return client.getDevisList();
        }
        return Collections.emptyList();
    }

    //++
    @Override
    public Optional<Societe> getSocieteByClientId(Long clientId) {
        return clientRepository.findSocieteByClientId(clientId);
    }

    @Override
    public List<Facture> getAllFactureForClient(Long id) {
        List<Facture> allFactures = new ArrayList<>();

        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.initializeCollections();
            allFactures.addAll(client.getFactureSimpleList());
            allFactures.addAll(client.getFactureAvoirList());
        }

        return allFactures;
    }


}
