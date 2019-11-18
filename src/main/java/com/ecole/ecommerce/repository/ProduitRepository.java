package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
