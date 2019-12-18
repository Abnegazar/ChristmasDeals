package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Users;
import com.ecole.ecommerce.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersRessource {

    private final UsersService usersService;

    public UsersRessource(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/addusers")
    public ResponseEntity<Users> save(@RequestBody Users users){
        return new ResponseEntity<>(usersService.save(users), HttpStatus.CREATED);
    }
    
    @GetMapping("/users/{pseudo}/{password}")
    public ResponseEntity<Users> getOne(@PathVariable("pseudo") String pseudo, @PathVariable("password") String password){
        return new ResponseEntity<>(usersService.getOne(pseudo, password), HttpStatus.FOUND); 
    }

    @GetMapping("/users/{role}")
    public ResponseEntity<List<Users>> getRole(@PathVariable("role") String role){
        return new ResponseEntity<>(usersService.getAllRole(role), HttpStatus.OK);
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAll(){
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/existusers/{role}")
    public boolean exist(@PathVariable("role") String role){
        return usersService.existRole(role);
    }
    
    @GetMapping("/existusers/{pseudo}/{password}")
    public boolean exist(@PathVariable("pseudo") String pseudo, @PathVariable("password") String password){
        return usersService.exist(pseudo, password);
    }
    
    @GetMapping("/countusers")
    public Long count(){
        return usersService.count();
    }
    
    @PutMapping("/users/{pseudo}/{password}")
    public ResponseEntity<Users> update(@PathVariable("pseudo") String pseudo, @PathVariable("password") String password, @RequestBody Users users){
        if (exist(pseudo,password)){
            return new ResponseEntity<>(usersService.update(users), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{role}")
    public void deleteOne(@PathVariable("pseudo") String role){
        usersService.deleteRole(role);
    }
    
    @DeleteMapping("/users/{pseudo}/{password}")
    public void deleteOne(@PathVariable("pseudo") String pseudo, @PathVariable("password") String password){
        usersService.deleteOne(pseudo, password);
    }
    
    @DeleteMapping("/users")
    public void deleteAll(){
        usersService.deleteAll();
    }
    
}
