package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.PetDto;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.repositories.OwnerRepository;
import org.springframework.sfg.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public PetDto findPetById(Long id) throws Exception{

        Pet pet = petRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
        PetDto petDto = PetDto.from(pet);
        return petDto;
    }

    public List<PetDto> findPetByOwnerId(Long id){
        List<Pet> pets = petRepository.findAll();
        List<Pet> ownersPet = new ArrayList<>();

        for(Pet pet : pets) {
            if (pet.getOwner().getId() == id) ownersPet.add(pet);
        }

        List<PetDto> ownersPetDto = ownersPet.stream().map((pet)->{
            PetDto pdto = PetDto.from(pet);
            return pdto;
        }).collect(Collectors.toList());

        return ownersPetDto;
    };

    public void save(PetDto petDto){
        Pet pet = PetDto.to(petDto);
        petRepository.save(pet);
    }

    public void delete(PetDto petDto){
        Pet pet = PetDto.to(petDto);
        petRepository.delete(pet);
    }
}
