package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
