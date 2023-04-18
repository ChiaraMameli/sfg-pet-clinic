package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.VetDto;
import org.springframework.sfg.model.Vet;
import org.springframework.sfg.repositories.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VetService {

    @Autowired
    private VetRepository vetRepository;

    public Optional<Vet> findVetById(Long id){
        return vetRepository.findById(id);
    }

    public List<VetDto> findAllVets(){
        List<Vet> vets = vetRepository.findAll();

        List<VetDto> vetsDto = vets.stream().map((v)->{
            VetDto vetDto = VetDto.from(v);
            return vetDto;
        }).collect(Collectors.toList());

        return vetsDto;
    }

    public void save(VetDto dto){

        Vet vet = VetDto.to(dto);
        vetRepository.save(vet);
    }
}
