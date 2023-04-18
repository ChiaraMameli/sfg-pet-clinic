package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.PetTypeDto;
import org.springframework.sfg.model.PetType;
import org.springframework.sfg.repositories.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public void savePetType(PetTypeDto dto){
        PetType petType = PetTypeDto.to(dto);
        petTypeRepository.save(petType);

    }

    public List<PetTypeDto> findAll(){
        List<PetType> petTypes =  petTypeRepository.findAll();
        List<PetTypeDto> petTypeDtos = petTypes.stream().map((pt)->{
            PetTypeDto ptd = PetTypeDto.from(pt);
            return ptd;
        }).collect(Collectors.toList());
        return petTypeDtos;
    };
}
