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

    public Client save(Client cli){
       return clientRepository.save(cli);
    }

    public List<Client> saveAll(List<Client> clients){
        return clientRepository.saveAll(clients);
    }

    public Optional<Client> getOne(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client update(Client cli){
        return clientRepository.saveAndFlush(cli);
    }

    public void deleteOne(Long id){
        clientRepository.deleteById(id);
    }

    public void deleteAll(){
        clientRepository.deleteAll();
    }

    public void deleteMany(List<Client> clients){
        clientRepository.deleteAll(clients);
    }

    public long count(){
        return clientRepository.count();
    }

    public boolean existsById(Long id){
        return clientRepository.existsById(id);
    }

}
