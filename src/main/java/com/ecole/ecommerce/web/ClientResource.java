package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
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

    @GetMapping("/countClient")
    public Long count(){
        return clientService.count();
    }

    @GetMapping("/existClient/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return clientService.existsById(id);
    }
}
