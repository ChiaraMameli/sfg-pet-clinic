package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.repositories.OwnerRepository;
import org.springframework.sfg.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public Optional<Pet> findPetById(Long id){
        return petRepository.findById(id);
    }

    public List<Pet> findPetByOwnerId(Long id){
        List<Pet> pets = petRepository.findAll();
        List<Pet> ownersPet = new ArrayList<>();

        for(Pet pet : pets) {
            if (pet.getOwner().getId() == id) ownersPet.add(pet);
        }
        return ownersPet;
    };

    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }

    public void save(Pet pet){
        petRepository.save(pet);
    }
}
