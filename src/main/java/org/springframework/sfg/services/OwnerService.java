package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.repositories.OwnerRepository;

import java.util.List;
import java.util.Optional;

public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Optional<Owner> findOwnerById(Long id){
        return ownerRepository.findById(id);
    }

    public List<Owner> findAllOwnsers(){
        return ownerRepository.findAll();
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }
}
