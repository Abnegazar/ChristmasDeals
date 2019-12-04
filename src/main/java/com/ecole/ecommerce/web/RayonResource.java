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
import java.util.Optional;

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

    @GetMapping("/rayon/{id}")
    public ResponseEntity<Optional<Rayon>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(rayonService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/rayon")
    public ResponseEntity<List<Rayon>> getAll(){
        return new ResponseEntity<>(rayonService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/rayon/{id}")
    public ResponseEntity<Rayon> update(Rayon rayon, @PathVariable Long id){
        if(exist(id)){
            return new ResponseEntity<>(rayonService.update(rayon), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/rayon/{id}")
    public void deleteById(@PathVariable Long id){
        rayonService.deleteOne(id);
    }

    @DeleteMapping("/rayon")
    public void deleteMany(List<Rayon> rayons){
        rayonService.deleteMany(rayons);
    }

    @DeleteMapping("/rayons")
    public void deleteAll(){
        rayonService.deleteAll();
    }

    @GetMapping("/countRayon")
    public Long count(){
        return rayonService.count();
    }

    @GetMapping("/existRayon/{id}")
    public boolean exist(@PathVariable("id") Long id){
        return rayonService.exist(id);
    }
}
