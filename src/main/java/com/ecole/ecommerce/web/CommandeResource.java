package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Commande;
import com.ecole.ecommerce.services.CommandeService;
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
public class CommandeResource {

    private final CommandeService commandeService;

    public CommandeResource(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping(value = "/commande")
    public ResponseEntity<Commande> save(@RequestBody Commande commande){
        return new ResponseEntity<>(commandeService.save(commande), HttpStatus.CREATED);
    }

    @GetMapping(value = "/commande/{id}")
    public ResponseEntity<Optional<Commande>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(commandeService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping(value = "/commandes")
    public ResponseEntity<List<Commande>> getAll(){
        return new ResponseEntity<>(commandeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/countCommande")
    public Long count(){
        return commandeService.count();
    }

    @GetMapping("/existCommande/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return commandeService.existsById(id);
    }

    @PutMapping("/commande/{id}")
    public ResponseEntity<Commande> update(Commande commande, @PathVariable Long id){
        if(exist(id)){
            return new ResponseEntity<>(commandeService.update(commande), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/commande/{id}")
    public void deleteOne(@PathVariable Long id){
        commandeService.deleteOne(id);
    }

    @DeleteMapping("/commande")
    public void deleteAll(){
        commandeService.deleteAll();
    }

}
