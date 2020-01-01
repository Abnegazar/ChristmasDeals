package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentairesRepository extends JpaRepository<Commentaires, Long> {
    public List<Commentaires> findAllByAuteur(String nomAuteur);

    public List<Commentaires> findAllByProduitConcerne(String nomProduit);

    public List<Commentaires> findAllByAuteurAndProduitConcerne(String nomAuteur, String nomProduit);

    public boolean existsByAuteurAndProduitConcerne(String auteur, String produitConcerne);

    public boolean existsByProduitConcerne(String produitConcerne);

    public boolean existsByAuteur(String auteur);

    public void deleteAllByAuteurAndProduitConcerne(String auteur, String produitConcerne);

    public Long countAllByProduitConcerne(String produitConcerne);

    public Long countAllByAuteurAndProduitConcerne(String auteur, String produitConcerne);
}
