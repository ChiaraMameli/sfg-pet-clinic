package org.springframework.sfg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.sfg.model.Owner;
import org.springframework.sfg.model.Pet;
import org.springframework.sfg.model.PetType;
import org.springframework.sfg.model.Visit;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PetDto {
    private Long id;
    private String name;
    private Owner owner;
    private PetType petType;
    private Set<Visit> visits;

    public PetDto(Long id, String name, Owner owner, PetType petType, Set<Visit> visits) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.petType = petType;
        this.visits = visits;
    }

    public static PetDto from(Pet source){
        if(source == null) return null;
        return new PetDto(
                source.getId(),
                source.getName(),
                source.getOwner(),
                source.getPetType(),
                source.getVisits()
        );
    }

    public static Pet to(PetDto source){
        return new Pet(
                source.getId(),
                source.getName(),
                source.getOwner(),
                source.getPetType(),
                source.getVisits()
        );
    }
}
