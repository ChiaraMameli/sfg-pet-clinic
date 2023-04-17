package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.PetType;
import org.springframework.sfg.repositories.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public void savePetType(PetType petType){
        petTypeRepository.save(petType);
    }

    public List<PetType> findAll(){
        return petTypeRepository.findAll();
    }
}
