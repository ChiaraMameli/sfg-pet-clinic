package org.springframework.sfg.services;

import org.apache.tomcat.util.digester.ArrayStack;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.OwnerDto;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.net.HttpRetryException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public OwnerDto findOwnerById(Long id) throws Exception{
        Owner o = ownerRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));

        OwnerDto dto = OwnerDto.from(o);
        dto.setId(o.getId());
        dto.setFirstName(o.getFirstName());
        dto.setLastName(o.getLastName());
        dto.setAddress(o.getAddress());
        dto.setTelephone(o.getTelephone());
        dto.setCity(o.getCity());

        return dto;
    }

    public List<OwnerDto> findAllOwners(){
        List<Owner> owners = ownerRepository.findAll();
        List<OwnerDto> ownersDto = owners.stream().map((o) -> {
            OwnerDto ow = OwnerDto.from(o);
            return ow;
        }).collect(Collectors.toList());

        return ownersDto;
    }

    public void save(OwnerDto ownerDto){

        Owner owner = OwnerDto.to(ownerDto);

        ownerRepository.save(owner);
    }

    public void delete(OwnerDto ownerDto){
        Owner owner = OwnerDto.to(ownerDto);
        ownerRepository.delete(owner);

    }
}
