package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findAllByDateCommande(Date dateCommande);
}