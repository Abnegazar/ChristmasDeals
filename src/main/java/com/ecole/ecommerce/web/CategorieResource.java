package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Categorie;
import com.ecole.ecommerce.services.CategorieService;
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
public class CategorieResource {

    private final CategorieService categorieService;

    public CategorieResource(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping("/categorie")
    public ResponseEntity<Categorie> save(@RequestBody Categorie categorie){
        return new ResponseEntity<>(categorieService.save(categorie), HttpStatus.CREATED);
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Optional<Categorie>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(categorieService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAll(){
        return new ResponseEntity<>(categorieService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/categorie/{id}")
    public ResponseEntity<Categorie> update(Categorie categorie, @PathVariable Long id){
        if(exist(id)){
            return new ResponseEntity<>(categorieService.update(categorie), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categorie/{id}")
    public void deleteById(@PathVariable Long id){
        categorieService.deleteOne(id);
    }

    @DeleteMapping("/categorie")
    public void deleteMany(List<Categorie> categories){
        categorieService.deleteMany(categories);
    }

    @DeleteMapping("/categories")
    public void deleteAll(){
        categorieService.deleteAll();
    }

    @GetMapping("/countCategorie")
    public Long count(){
        return categorieService.count();
    }

    @GetMapping("/existCategorie/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return categorieService.exist(id);
    }
}
