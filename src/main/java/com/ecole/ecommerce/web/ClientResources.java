package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientResources {

    private final ClientService clientService;

    public ClientResources(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<Client> save(@RequestBody Client cli){
        return new ResponseEntity<Client>(clientService.save(cli), HttpStatus.CREATED);
    }


}
