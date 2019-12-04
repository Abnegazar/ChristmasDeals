package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.LigneCommande;
import com.ecole.ecommerce.services.LigneCommandeService;
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
public class LigneCommandeResource {

    private final LigneCommandeService ligneCommandeService;

    public LigneCommandeResource(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @PostMapping(value = "/ligneCommande")
    public ResponseEntity<LigneCommande> save(@RequestBody LigneCommande ligneCommande){
        return new ResponseEntity<>(ligneCommandeService.save(ligneCommande), HttpStatus.CREATED);
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @PostMapping(value = "/ligneCommandes")
    public ResponseEntity<List<LigneCommande>> saveAll(@RequestBody List<LigneCommande> ligneCommandes){
        return new ResponseEntity<>(ligneCommandeService.saveAll(ligneCommandes), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ligneCommande/{id}")
    public ResponseEntity<Optional<LigneCommande>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(ligneCommandeService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping(value = "/ligneCommandes")
    public ResponseEntity<List<LigneCommande>> getAll(){
        return new ResponseEntity<>(ligneCommandeService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/ligneCommande/{id}")
    public ResponseEntity<LigneCommande> update(LigneCommande ligneCommande, @PathVariable Long id){
        if(exist(id)){
            return new ResponseEntity<>(ligneCommandeService.update(ligneCommande), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ligneCommande/{id}")
    public void deleteOne(@PathVariable Long id){
        ligneCommandeService.deleteOne(id);
    }

    @DeleteMapping("/ligneCommande")
    public void deleteAll(){
        ligneCommandeService.deleteAll();
    }

    /////////////////////////////
    ///////  A revoir  /////////
    ////////////////////////////
    @DeleteMapping("/ligneCommandes")
    public void deleteMany(List<LigneCommande> ligneCommandes){
        ligneCommandeService.deleteMany(ligneCommandes);
    }

    @GetMapping("/countLigneCommande")
    public Long count(){
        return ligneCommandeService.count();
    }

    @GetMapping("/existLigneCommande/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return ligneCommandeService.existsById(id);
    }
}
