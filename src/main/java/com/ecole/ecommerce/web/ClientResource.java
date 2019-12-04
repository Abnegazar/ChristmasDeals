package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/client")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @PostMapping(value = "/clients")
    public ResponseEntity<List<Client>> saveAll(@RequestBody List<Client> clients){
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

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> update(Client client, @PathVariable Long id){
        if(exist(id)){
            return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/countClient")
    public Long count(){
        return clientService.count();
    }

    @GetMapping("/existClient/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return clientService.existsById(id);
    }
}
