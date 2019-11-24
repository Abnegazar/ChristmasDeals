package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.LigneCommande;
import com.ecole.ecommerce.repository.LigneCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    /**
     * Ajouter un nouveau ligneCommande
     * @param ligneCommande
     * @return
     */
    public LigneCommande save(LigneCommande ligneCommande){
        return ligneCommandeRepository.save(ligneCommande);
    }

    /**
     * Ajouter plusieurs ligneCommandes è la fois
     * @param ligneCommandes
     * @return
     */
    public List<LigneCommande> saveAll(List<LigneCommande> ligneCommandes){
        return ligneCommandeRepository.saveAll(ligneCommandes);
    }

    /**
     * Récupérer les informations d'un ligneCommande
     * @param id
     * @return un ou zéro(dans le cas ou le ligneCommande n'existe pas) objets de type LigneCommande
     */
    public Optional<LigneCommande> getOne(Long id){
        return ligneCommandeRepository.findById(id);
    }

    /**
     * Récupérer les informations de tous les ligneCommandes
     * @return
     */
    public List<LigneCommande> getAll(){
        return ligneCommandeRepository.findAll();
    }

    /**
     * Met à jour les informations d'un ligneCommande particulier
     * @param ligneCommande
     * @return
     */
    public LigneCommande update(LigneCommande ligneCommande){
        return ligneCommandeRepository.saveAndFlush(ligneCommande);
    }

    /**
     * Supprime un ligneCommande donné de la base de données
     * @param id
     */
    public void deleteOne(Long id){
        ligneCommandeRepository.deleteById(id);
    }

    /**
     * Supprime les informations de tous les ligneCommandes présent dans la base
     */
    public void deleteAll(){
        ligneCommandeRepository.deleteAll();
    }

    /***
     * Supprime les informations de plusieurs ligneCommandes à la fois
     * @param ligneCommandes
     */
    public void deleteMany(List<LigneCommande> ligneCommandes){
        ligneCommandeRepository.deleteAll(ligneCommandes);
    }

    /**
     * Compte le nombre de ligneCommandes présent dans la base
     * @return
     */
    public long count(){
        return ligneCommandeRepository.count();
    }

    /**
     * Vérifie la présence ou non d'un ligneCommande dans la base
     * @param id
     * @return
     */
    public boolean existsById(Long id){
        return ligneCommandeRepository.existsById(id);
    }
}
