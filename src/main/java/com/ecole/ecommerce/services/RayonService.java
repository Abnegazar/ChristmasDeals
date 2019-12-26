package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Rayon;
import com.ecole.ecommerce.repository.RayonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean exist(String nomRayon){
        return rayonRepository.existsByNomRayon(nomRayon);
    }

    public Rayon getOne(String nomRayon){
        return rayonRepository.findByNomRayon(nomRayon);
    }

    public List<Rayon> getAll(){
        return rayonRepository.findAll();
    }

    public Rayon update(Rayon rayon){
        return rayonRepository.saveAndFlush(rayon);
    }

    public void deleteOne(String nomRayon){
        rayonRepository.deleteByNomRayon(nomRayon);
    }

    public void deleteAll(){
        rayonRepository.deleteAll();
    }
}
