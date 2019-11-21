package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Categorie;
import com.ecole.ecommerce.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public List<Categorie> saveAll(List<Categorie> categories){
        return categorieRepository.saveAll(categories);
    }

    public Optional<Categorie> getOne(Long id){
        return categorieRepository.findById(id);
    }

    public List<Categorie> getAll(){
        return categorieRepository.findAll();
    }

    public Categorie update(Categorie categorie){
        return categorieRepository.saveAndFlush(categorie);
    }

    public void deleteOne(Long id){
        categorieRepository.deleteById(id);
    }

    public void deleteMany(List<Categorie> categories){
        categorieRepository.deleteAll(categories);
    }

    public void deleteAll(){
        categorieRepository.deleteAll();
    }

    public Long count(){
        return categorieRepository.count();
    }

    public boolean exist(Long id){
        return categorieRepository.existsById(id);
    }
}

