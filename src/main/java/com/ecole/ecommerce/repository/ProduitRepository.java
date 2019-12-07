package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    public List<Produit> findAllByMarque(String marque);

    public Produit findByNomProduit(String nomProduitOrMarque);

    public void deleteAllByMarque(String Marque);

    public void deleteByNomProduit(String nomProduitOrMarque);

    public boolean existsByNomProduit(String nomProduit);

    public boolean existsByMarque(String marque);
}
