package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.net.HttpRetryException;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner findOwnerById(Long id){

        Owner owner = ownerRepository.findById(id).get();
        return owner;
    }

    public List<Owner> findAllOwnsers(){
        return ownerRepository.findAll();
    }

    public void save(Owner owner){
        ownerRepository.save(owner);
    }
}
