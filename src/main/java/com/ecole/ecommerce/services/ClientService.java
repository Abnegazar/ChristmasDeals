package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.repository.ClientRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Ajouter un nouveau client
     * @param cli
     * @return
     */
    public Client save(Client cli){
       return clientRepository.save(cli);
    }

    /**
     * Ajouter plusieurs clients è la fois
     * @param clients
     * @return
     */
    public List<Client> saveAll(List<Client> clients){
        return clientRepository.saveAll(clients);
    }

    /**
     * Récupérer les informations d'un client
     * @param id
     * @return un ou zéro(dans le cas ou le client n'existe pas) objets de type Client
     */
    public Optional<Client> getOne(Long id){
        return clientRepository.findById(id);
    }

    /**
     * Récupérer les informations de tous les clients
     * @return
     */
    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    /**
     * Met à jour les informations d'un client particulier
     * @param cli
     * @return
     */
    public Client update(Client cli){
        return clientRepository.saveAndFlush(cli);
    }

    /**
     * Supprime un client donné de la base de données
     * @param id
     */
    public void deleteOne(Long id){
        clientRepository.deleteById(id);
    }

    /**
     * Supprime les informations de tous les clients présent dans la base
     */
    public void deleteAll(){
        clientRepository.deleteAll();
    }

    /***
     * Supprime les informations de plusieurs clients à la fois
     * @param clients
     */
    public void deleteMany(List<Client> clients){
        clientRepository.deleteAll(clients);
    }

    /**
     * Compte le nombre de clients présent dans la base
     * @return
     */
    public long count(){
        return clientRepository.count();
    }

    /**
     * Vérifie la présence ou non d'un client dans la base
     * @param id
     * @return
     */
    public boolean existsById(Long id){
        return clientRepository.existsById(id);
    }

}
