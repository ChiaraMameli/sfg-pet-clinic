package org.springframework.sfg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.dto.SpecialityDto;
import org.springframework.sfg.model.Speciality;
import org.springframework.sfg.repositories.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    public void save(SpecialityDto specialityDto){

        Speciality speciality = SpecialityDto.to(specialityDto);
        specialityRepository.save(speciality);
    }

    public List<SpecialityDto> findAll(){
        List<Speciality> specialities = specialityRepository.findAll();
        List<SpecialityDto> specialityDtos = specialities.stream().map((s)->{
            SpecialityDto specialityDto = SpecialityDto.from(s);
            return specialityDto;
        }).collect(Collectors.toList());

        return specialityDtos;
    }
}
