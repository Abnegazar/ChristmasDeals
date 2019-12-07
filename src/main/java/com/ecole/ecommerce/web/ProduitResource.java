package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Produit;
import com.ecole.ecommerce.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/produit-nom/{nomProduit}")
    public ResponseEntity<Produit> getProduit(@PathVariable("nomProduit") String nomProduit){
        if(existProduit(nomProduit)){
            return new ResponseEntity<>(produitService.getOne(nomProduit), HttpStatus.FOUND);
        }else{
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/produit")
    public ResponseEntity<List<Produit>> getAll(){
        return new ResponseEntity<>(produitService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/produit-marque/{marque}")
    public ResponseEntity<List<Produit>> getAllByMarque(@PathVariable("marque") String marque){
        return new ResponseEntity<>(produitService.getAllByMarque(marque), HttpStatus.OK);
    }

    @GetMapping("/countProduit")
    public Long count(){
        return produitService.count();
    }

    @GetMapping("/existProduit/{nomProduit}")
    public boolean existProduit(@PathVariable("nomProduit") String nomProduit){
        return produitService.existProduit(nomProduit);
    }

    @GetMapping("/existMarque/{marque}")
    public boolean existMarque(@PathVariable("marque") String marque){
        return produitService.existMarque(marque);
    }

    @PutMapping("/produit/{nomProduit}")
    public ResponseEntity<Produit> update(Produit produit, @PathVariable("nomProduit") String nomProduit){
        if(existProduit(nomProduit)){
            return new ResponseEntity<>(produitService.update(produit), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/produit/{nomProduit}")
    public void deleteById(@PathVariable String nomProduit){
        produitService.deleteOne(nomProduit);
    }

    @DeleteMapping("/produits")
    public void deleteAll(){
        produitService.deleteAll();
    }

    @DeleteMapping("/produits/{marque}")
    public void deleteAllByMarque(String marque){
        produitService.deleteAllByMarque(marque);
    }

}
