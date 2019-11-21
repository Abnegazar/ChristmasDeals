package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Produit;
import com.ecole.ecommerce.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProduitResource {

    private final ProduitService produitService;


    public ProduitResource(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/produit")
    public ResponseEntity<Produit> save(@RequestBody Produit produit){
        return new ResponseEntity<>(produitService.save(produit), HttpStatus.CREATED);
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<Optional<Produit>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(produitService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/produit")
    public ResponseEntity<List<Produit>> getAll(){
        return new ResponseEntity<>(produitService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/produit")
    public ResponseEntity<Produit> update(Produit produit){
        return new ResponseEntity<>(produitService.update(produit), HttpStatus.OK);
    }

    @DeleteMapping("/produit/{id}")
    public void deleteById(@PathVariable Long id){
        produitService.deleteOne(id);
    }

    @DeleteMapping("/produit")
    public void deleteMany(List<Produit> produits){
        produitService.deleteMany(produits);
    }

    @DeleteMapping("/produits")
    public void deleteAll(){
        produitService.deleteAll();
    }

    @GetMapping("/countProduit")
    public Long count(){
        return produitService.count();
    }

    @GetMapping("/existProduit/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return produitService.exist(id);
    }
}
