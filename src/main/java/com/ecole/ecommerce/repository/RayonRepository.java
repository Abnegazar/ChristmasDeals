package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RayonRepository extends JpaRepository<Rayon, Long> {

    Rayon findByNomRayon(String nomRayon);

    void deleteByNomRayon(String nomRayon);

    boolean existsByNomRayon(String nomRayon);
}
