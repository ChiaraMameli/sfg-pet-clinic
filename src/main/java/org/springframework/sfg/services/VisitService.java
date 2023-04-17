package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Visit;
import org.springframework.sfg.repositories.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    public void saveVisit(Visit visit){
        visitRepository.save(visit);
    }
}
