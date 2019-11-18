package com.ecole.ecommerce.repository;

import com.ecole.ecommerce.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
