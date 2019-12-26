package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
