package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Categorie;
import com.ecole.ecommerce.services.CategorieService;
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
public class CategorieResource {

    private final CategorieService categorieService;

    public CategorieResource(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping("/categorie")
    @ApiOperation(value = "Ajouter une nouvelle catégorie")
    public ResponseEntity<Categorie> save(@RequestBody Categorie categorie){
        return new ResponseEntity<>(categorieService.save(categorie), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Récupérer une catégorie")
    @GetMapping("/categorie/{nomCategorie}")
    public ResponseEntity<Categorie> getOne(@PathVariable("nomCategorie") String nomCategorie){
        return new ResponseEntity<>(categorieService.getOne(nomCategorie), HttpStatus.FOUND);
    }

    @ApiOperation(value = "Récupérer toutes les catégories")
    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAll(){
        return new ResponseEntity<>(categorieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/countCategorie")
    @ApiOperation(value = "Récupérer le nombre de catégories enregistrées")
    public Long count(){
        return categorieService.count();
    }

    @GetMapping("/existCategorie/{nomCategorie}")
    @ApiOperation(value = "Vérifie la présence ou non d'une catégorie en base")
    public boolean exist(@PathVariable("nomCategorie") String nomCategorie){
        return categorieService.exist(nomCategorie);
    }

    @ApiOperation(value = "Modifier les informations d'une catégorie")
    @PutMapping("/categorie/{nomCategorie}")
    public ResponseEntity<Categorie> update(Categorie categorie, @PathVariable("nomCategorie") String nomCategorie){
        if(exist(nomCategorie)){
            return new ResponseEntity<>(categorieService.update(categorie), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Supprimer une catégorie")
    @DeleteMapping("/categorie/{nomCategorie}")
    public void deleteOne(@PathVariable String nomCategorie){
        categorieService.deleteOne(nomCategorie);
    }

   @DeleteMapping("/categories")
   @ApiOperation(value = "Supprimer toutes les catégories enregistrées; A utiliser avec précaution car cette opération est irréversible.")
   public void deleteAll(){
        categorieService.deleteAll();
   }

}
