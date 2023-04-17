package org.springframework.sfg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sfg.model.Visit;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
