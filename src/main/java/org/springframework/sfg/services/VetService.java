package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.model.Vet;
import org.springframework.sfg.repositories.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VetService {

    @Autowired
    private VetRepository vetRepository;

    public Optional<Vet> findVetById(Long id){
        return vetRepository.findById(id);
    }

    public List<Vet> findAllVets(){
        return vetRepository.findAll();
    }

    public void save(Vet vet){
        vetRepository.save(vet);
    }
}
