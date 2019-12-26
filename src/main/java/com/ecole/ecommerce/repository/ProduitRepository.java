package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findAllByMarque(String marque);

    Produit findByNomProduit(String nomProduitOrMarque);

    void deleteAllByMarque(String Marque);

    void deleteByNomProduit(String nomProduitOrMarque);

    boolean existsByNomProduit(String nomProduit);

    boolean existsByMarque(String marque);
}
