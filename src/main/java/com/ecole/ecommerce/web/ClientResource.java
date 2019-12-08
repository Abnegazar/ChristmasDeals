package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.services.ClientService;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping(value = "/client/{nom}/{mail}")
    public ResponseEntity<Client> getOneByNomAndMail(@PathVariable("nom") String nom, @PathVariable("mail") String mail){
        return new ResponseEntity<>(clientService.getOneByNomAndMail(nom, mail), HttpStatus.FOUND);
    }

    @GetMapping(value = "/client-nom/{nom}")
    public ResponseEntity<Client> getOneByNom(@PathVariable("nom") String nom){
        return new ResponseEntity<>(clientService.getOneByNom(nom), HttpStatus.FOUND);
    }

    @GetMapping(value = "/client-mail/{mail}")
    public ResponseEntity<Client> getOne(@PathVariable("mail") String mail){
        if(existByMail(mail)){
            return new ResponseEntity<>(clientService.getOneByMail(mail), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/countClient")
    public Long count(){
        return clientService.count();
    }

    @GetMapping("/existClient/{nom}/{mail}")
    public boolean exist(@PathVariable("nom") String nom, @PathVariable("mail") String mail){
        return clientService.exists(nom, mail);
    }

    @GetMapping("/existClient-nom/{nom}")
    public boolean existByNom(@PathVariable("nom") String nom){
        return clientService.existsByNom(nom);
    }

    @GetMapping("/existClient-mail/{mail}")
    public boolean existByMail(@PathVariable("mail") String mail){
        return clientService.existsByMail(mail);
    }

    @PutMapping("/client/{nom_mail}")
    public ResponseEntity<Client> update(Client client, @PathVariable("nom_mail") String nom_mail){
        if(existByMail(nom_mail) || existByNom(nom_mail)){
            return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/client-mail/{mail}")
    public void deleteOneMail(@PathVariable("mail") String mail){
        clientService.deleteOneByMail(mail);
    }

    @DeleteMapping("/client-nom/{nom}")
    public void deleteOneByNom(@PathVariable("nom") String nom){
        clientService.deleteOneByNom(nom);
    }

    @DeleteMapping("/client")
    @ApiOperation(value = "Supprime tous les clients enregistrés; A utiliser avec précaution car cette opération est irréversible.")
    public void deleteAll(){
        clientService.deleteAll();
    }

}
