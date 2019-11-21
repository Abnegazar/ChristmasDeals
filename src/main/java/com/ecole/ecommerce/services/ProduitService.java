package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Produit;
import com.ecole.ecommerce.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit save(Produit produit){
        return produitRepository.save(produit);
    }

    public Long count(){
        return produitRepository.count();
    }

    public boolean exist(Long id){
        return produitRepository.existsById(id);
    }

    public Optional<Produit> getOne(Long id){
        return produitRepository.findById(id);
    }

    public List<Produit> getAll(){
        return produitRepository.findAll();
    }

    public Produit update(Produit produit){
        return produitRepository.saveAndFlush(produit);
    }

    public void deleteOne(Long id){
        produitRepository.deleteById(id);
    }

    public void deleteMany(List<Produit> produits){
        produitRepository.deleteAll(produits);
    }

    public void deleteAll(){
        produitRepository.deleteAll();
    }
}
