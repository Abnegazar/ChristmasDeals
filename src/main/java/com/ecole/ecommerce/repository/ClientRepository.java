package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findByNomAndMail(String nom, String Mail);

    public Client findByNom(String nom);

    public Client findByMail(String mail);

    public void deleteByNomAndMail(String nom, String Mail);

    public void deleteByNom(String nom);

    public void deleteByMail(String mail);

    public boolean existsByNomAndMail(String nom, String Mail);

    public boolean existsByNom(String nom);

    public boolean existsByMail(String mail);
}
