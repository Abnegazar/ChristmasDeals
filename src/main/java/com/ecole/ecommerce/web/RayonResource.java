package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Rayon;
import com.ecole.ecommerce.services.RayonService;
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
public class RayonResource {

    private final RayonService rayonService;


    public RayonResource(RayonService rayonService) {
        this.rayonService = rayonService;
    }

    @PostMapping("/rayon")
    public ResponseEntity<Rayon> save(@RequestBody Rayon rayon){
        return new ResponseEntity<>(rayonService.save(rayon), HttpStatus.CREATED);
    }

    @GetMapping("/rayon/{nomRayon}")
    public ResponseEntity<Rayon> getOne(@PathVariable("nomRayon") String nomRayon){
        return new ResponseEntity<>(rayonService.getOne(nomRayon), HttpStatus.FOUND);
    }

    @GetMapping("/rayon")
    public ResponseEntity<List<Rayon>> getAll(){
        return new ResponseEntity<>(rayonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/countRayon")
    public Long count(){
        return rayonService.count();
    }

    @GetMapping("/existRayon/{nomRayon}")
    public boolean exist(@PathVariable("nomRayon") String nomRayon){
        return rayonService.exist(nomRayon);
    }

    @PutMapping("/rayon/{id}")
    public ResponseEntity<Rayon> update(Rayon rayon, @PathVariable String nomRayon){
        if(exist(nomRayon)){
            return new ResponseEntity<>(rayonService.update(rayon), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/rayon/{nomRayon}")
    public void deleteById(@PathVariable String nomRayon){
        rayonService.deleteOne(nomRayon);
    }

    @DeleteMapping("/rayons")
    public void deleteAll(){
        rayonService.deleteAll();
    }

}
