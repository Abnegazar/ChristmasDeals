package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.services.ClientService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientResources {

    private final ClientService clientService;

    public ClientResources(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/client")
    public ResponseEntity<Client> save(@RequestBody Client cli){
        return new ResponseEntity<>(clientService.save(cli), HttpStatus.CREATED);
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @PostMapping(value = "/clients")
    public ResponseEntity<List<Client>> saveAll(List<Client> clients){
        return new ResponseEntity<>(clientService.saveAll(clients), HttpStatus.CREATED);
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Optional<Client>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(clientService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @PutMapping("/client")
    public ResponseEntity<Client> update(Client cli){
        return new ResponseEntity<>(clientService.update(cli), HttpStatus.OK);
    }

    @DeleteMapping("/client/{id}")
    public void deleteOne(@PathVariable Long id){
        clientService.deleteOne(id);
    }

    @DeleteMapping("/client")
    public void deleteAll(){
        clientService.deleteAll();
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @DeleteMapping("/clients")
    public void deleteMany(List<Client> clients){
        clientService.deleteMany(clients);
    }

}
