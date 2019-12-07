package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RayonRepository extends JpaRepository<Rayon, Long> {

    public Rayon findByNomRayon(String nomRayon);

    public void deleteByNomRayon(String nomRayon);

    public boolean existsByNomRayon(String nomRayon);
}
