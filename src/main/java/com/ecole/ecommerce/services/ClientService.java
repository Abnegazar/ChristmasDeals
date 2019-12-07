package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.repository.ClientRepository;
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
     * @param client
     * @return
     */
    public Client save(Client client){
       return clientRepository.save(client);
    }

    /**
     *
     * @param nom
     * @param Mail
     * @return
     */
    public Client getOneByNomAndMail(String nom, String Mail){
        return clientRepository.findByNomAndMail(nom, Mail);
    }

    public Client getOneByNom(String nom){
        return clientRepository.findByNom(nom);
    }

    public Client getOneByMail(String mail){
        return clientRepository.findByMail(mail);
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
     * @param client
     * @return
     */
    public Client update(Client client){
        return clientRepository.saveAndFlush(client);
    }

    /**
     *
     * @param nom
     * @param mail
     */
    public void deleteOne(String nom, String mail){
        clientRepository.deleteByNomAndMail(nom, mail);
    }

    public void deleteOneByNom(String nom){
        clientRepository.deleteByNom(nom);
    }

    public void deleteOneByMail(String mail){
        clientRepository.deleteByMail(mail);
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
     *
     * @param nom
     * @param mail
     * @return
     */
    public boolean exists(String nom, String mail){
        return clientRepository.existsByNomAndMail(nom, mail);
    }

    public boolean existsByNom(String nom){
        return clientRepository.existsByNom(nom);
    }

    public boolean existsByMail(String mail){
        return clientRepository.existsByMail(mail);
    }

}
