package com.codingart.mycompta.controller.client;

import com.codingart.mycompta.dto.ClientDto;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.service.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id){
        ClientDto clientDto = modelMapper.map(clientService.getClient(id),ClientDto.class);
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClient(){
        List<ClientDto> clientDtoList = clientService.getAllClient().stream().map(p -> modelMapper.map(p,ClientDto.class)).toList();
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client){
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client client){
        return new ResponseEntity<>(clientService.updateClient(id,client), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


    @GetMapping("par")
    public ResponseEntity<List<Client>> getAllClientPar(){
        return new ResponseEntity<>(clientService.getAllClientPar(), HttpStatus.OK);
    }
    @GetMapping("pro")
    public ResponseEntity<List<Client>> getAllClientPro(){
        return new ResponseEntity<>(clientService.getAllClientPro(), HttpStatus.OK);
    }

}
