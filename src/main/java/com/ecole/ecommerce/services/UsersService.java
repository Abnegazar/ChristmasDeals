package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Users;
import com.ecole.ecommerce.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository ;


    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users save(Users users){
        return  usersRepository.save(users);
    }

    public Users getOne(String pseudo, String password){
        return usersRepository.findByPseudoAndPassword(pseudo, password);
    }

    public List<Users> getAllRole(String role){
        return usersRepository.findAllByRole(role);
    }

    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    public boolean exist(String pseudo, String password){
        return usersRepository.existsByPseudoAndPassword(pseudo, password);
    }

    public boolean existRole(String role){
        return usersRepository.existsByRole(role);
    }

    public Long count(){
        return usersRepository.count();
    }

    public Users update(Users users){
        return usersRepository.saveAndFlush(users);
    }

    public void deleteOne(String pseudo, String password){
        usersRepository.deleteByPseudoAndPassword(pseudo, password);
    }

    public void deleteRole(String role){
        usersRepository.deleteAllByRole(role);
    }

    public void deleteAll(){
        usersRepository.deleteAll();
    }
}
