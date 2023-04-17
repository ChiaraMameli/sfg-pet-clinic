package org.springframework.sfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sfg.model.PetType;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
