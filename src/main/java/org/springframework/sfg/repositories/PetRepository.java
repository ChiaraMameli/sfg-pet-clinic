package org.springframework.sfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sfg.model.Pet;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
