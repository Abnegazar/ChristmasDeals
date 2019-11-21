package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Rayon;
import com.ecole.ecommerce.services.RayonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/rayon")
    public ResponseEntity<Rayon> update(Rayon rayon){
        return new ResponseEntity<>(rayonService.update(rayon), HttpStatus.OK);
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
