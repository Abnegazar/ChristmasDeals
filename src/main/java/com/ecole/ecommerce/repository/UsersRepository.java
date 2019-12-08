package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByPseudoAndPassword(String password, String pseudo);

    List<Users> findAllByRole(String role);

    boolean existsByPseudoAndPassword(String password, String pseudo);

    boolean existsByRole(String role);

    void deleteByPseudoAndPassword(String password, String pseudo);

    void deleteAllByRole(String role);
}
