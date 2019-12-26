package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByNomAndMail(String nom, String Mail);

    Client findByNom(String nom);

    Client findByMail(String mail);

    void deleteByNomAndMail(String nom, String Mail);

    void deleteByNom(String nom);

    void deleteByMail(String mail);

    boolean existsByNomAndMail(String nom, String Mail);

    boolean existsByNom(String nom);

    boolean existsByMail(String mail);
}
