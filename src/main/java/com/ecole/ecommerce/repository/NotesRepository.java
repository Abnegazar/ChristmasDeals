package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {

    public List<Notes> findAllByProduitConcerne(String nomProduit);

    public Notes findByAuteurAndProduitConcerne(String nomAuteur, String nomProduit);

    public boolean existsByAuteurAndProduitConcerne(String auteur, String produitConcerne);

    public boolean existsByProduitConcerne(String produitConcerne);

    public void deleteByAuteurAndProduitConcerne(String auteur, String produitConcerne);

    public void deleteAllByProduitConcerne(String produit);

    public Long countAllByProduitConcerne(String produitConcerne);

}
