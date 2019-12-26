package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByNomCategorie(String nomCategorie);

    void deleteByNomCategorie(String nomCategorie);

    boolean existsByNomCategorie(String nomCategorie);
}
