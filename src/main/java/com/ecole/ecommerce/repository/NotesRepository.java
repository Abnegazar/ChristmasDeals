package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findAllByProduitConcerné(String nomProduit);
}
