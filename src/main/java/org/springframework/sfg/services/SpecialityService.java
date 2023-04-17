package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Speciality;
import org.springframework.sfg.repositories.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    public void saveSpeciality(Speciality speciality){
        specialityRepository.save(speciality);
    }

    public List<Speciality> findAll(){
        return specialityRepository.findAll();
    }
}
