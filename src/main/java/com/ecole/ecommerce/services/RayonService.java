package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Rayon;
import com.ecole.ecommerce.repository.RayonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RayonService {

    private final RayonRepository rayonRepository;

    public RayonService(RayonRepository rayonRepository) {
        this.rayonRepository = rayonRepository;
    }

    public Rayon save(Rayon rayon){
        return rayonRepository.save(rayon);
    }

    public Long count(){
        return rayonRepository.count();
    }

    public boolean exist(Long id){
        return rayonRepository.existsById(id);
    }

    public Optional<Rayon> getOne(Long id){
        return rayonRepository.findById(id);
    }

    public List<Rayon> getAll(){
        return rayonRepository.findAll();
    }

    public Rayon update(Rayon rayon){
        return rayonRepository.saveAndFlush(rayon);
    }

    public void deleteOne(Long id){
        rayonRepository.deleteById(id);
    }

    public void deleteMany(List<Rayon> rayons){
        rayonRepository.deleteAll(rayons);
    }

    public void deleteAll(){
        rayonRepository.deleteAll();
    }
}
