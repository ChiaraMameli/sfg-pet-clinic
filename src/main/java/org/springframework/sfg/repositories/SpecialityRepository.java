package org.springframework.sfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sfg.model.Speciality;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
