package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Commande;
import com.ecole.ecommerce.services.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @PostMapping(value = "/commandes")
    public ResponseEntity<List<Commande>> saveAll(@RequestBody List<Commande> commandes){
        return new ResponseEntity<>(commandeService.saveAll(commandes), HttpStatus.CREATED);
    }

    @GetMapping(value = "/commande/{id}")
    public ResponseEntity<Optional<Commande>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(commandeService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping(value = "/commandes")
    public ResponseEntity<List<Commande>> getAll(){
        return new ResponseEntity<>(commandeService.getAll(), HttpStatus.OK);
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @PutMapping("/commande")
    public ResponseEntity<Commande> update(Commande commande){
        return new ResponseEntity<>(commandeService.update(commande), HttpStatus.OK);
    }

    @DeleteMapping("/commande/{id}")
    public void deleteOne(@PathVariable Long id){
        commandeService.deleteOne(id);
    }

    @DeleteMapping("/commande")
    public void deleteAll(){
        commandeService.deleteAll();
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @DeleteMapping("/commandes")
    public void deleteMany(List<Commande> commandes){
        commandeService.deleteMany(commandes);
    }

    @GetMapping("/countCommande")
    public Long count(){
        return commandeService.count();
    }

    @GetMapping("/existCommande/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return commandeService.existsById(id);
    }
}
