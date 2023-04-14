package org.springframework.sfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sfg.model.Vet;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    Optional<Vet> findByLastName(String lastName);
}
