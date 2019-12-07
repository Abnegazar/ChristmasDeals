package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Categorie;
import com.ecole.ecommerce.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public Categorie getOne(String nomCategorie){
        return categorieRepository.findByNomCategorie(nomCategorie);
    }

    public List<Categorie> getAll(){
        return categorieRepository.findAll();
    }

    public Categorie update(Categorie categorie){
        return categorieRepository.saveAndFlush(categorie);
    }

    public void deleteOne(String nomCategorie){
        categorieRepository.deleteByNomCategorie(nomCategorie);
    }

    public void deleteAll(){
        categorieRepository.deleteAll();
    }

    public Long count(){
        return categorieRepository.count();
    }

    public boolean exist(String nomCategorie){
        return categorieRepository.existsByNomCategorie(nomCategorie);
    }
}

