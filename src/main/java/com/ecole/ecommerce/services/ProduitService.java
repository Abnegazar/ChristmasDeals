package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Produit;
import com.ecole.ecommerce.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Produit getOne(String nomProduit){
        return produitRepository.findByNomProduit(nomProduit);
    }

    public List<Produit> getAll(){
        return produitRepository.findAll();
    }

    public List<Produit> getAllByMarque(String marque){
        return produitRepository.findAllByMarque(marque);
    }

    public Produit update(Produit produit){
        return produitRepository.saveAndFlush(produit);
    }

    public void deleteOne(String produit){
        produitRepository.deleteByNomProduit(produit);
    }

    public void deleteAll(){
        produitRepository.deleteAll();
    }

    public void deleteAllByMarque(String marque){
        produitRepository.deleteAllByMarque(marque);
    }

    public boolean existProduit(String nomProduit) {
        return produitRepository.existsByNomProduit(nomProduit);
    }

    public boolean existMarque(String marque) {
        return produitRepository.existsByMarque(marque);
    }
}
