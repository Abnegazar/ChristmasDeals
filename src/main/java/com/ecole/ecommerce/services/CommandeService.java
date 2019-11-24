package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Commande;
import com.ecole.ecommerce.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    /**
     * Ajouter un nouveau commande
     * @param commande
     * @return
     */
    public Commande save(Commande commande){
        return commandeRepository.save(commande);
    }

    /**
     * Ajouter plusieurs commandes è la fois
     * @param commandes
     * @return
     */
    public List<Commande> saveAll(List<Commande> commandes){
        return commandeRepository.saveAll(commandes);
    }

    /**
     * Récupérer les informations d'un commande
     * @param id
     * @return un ou zéro(dans le cas ou le commande n'existe pas) objets de type Commande
     */
    public Optional<Commande> getOne(Long id){
        return commandeRepository.findById(id);
    }

    /**
     * Récupérer les informations de tous les commandes
     * @return
     */
    public List<Commande> getAll(){
        return commandeRepository.findAll();
    }

    /**
     * Met à jour les informations d'un commande particulier
     * @param commande
     * @return
     */
    public Commande update(Commande commande){
        return commandeRepository.saveAndFlush(commande);
    }

    /**
     * Supprime un commande donné de la base de données
     * @param id
     */
    public void deleteOne(Long id){
        commandeRepository.deleteById(id);
    }

    /**
     * Supprime les informations de tous les commandes présent dans la base
     */
    public void deleteAll(){
        commandeRepository.deleteAll();
    }

    /***
     * Supprime les informations de plusieurs commandes à la fois
     * @param commandes
     */
    public void deleteMany(List<Commande> commandes){
        commandeRepository.deleteAll(commandes);
    }

    /**
     * Compte le nombre de commandes présent dans la base
     * @return
     */
    public long count(){
        return commandeRepository.count();
    }

    /**
     * Vérifie la présence ou non d'un commande dans la base
     * @param id
     * @return
     */
    public boolean existsById(Long id){
        return commandeRepository.existsById(id);
    }

}
