package org.springframework.sfg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.sfg.model.PetType;

@Getter
@Setter
@NoArgsConstructor
public class PetTypeDto {
    private Long id;
    private String name;

    public PetTypeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PetTypeDto from(PetType source){
        return new PetTypeDto(
                source.getId(),
                source.getName()
        );
    }

    public static PetType to(PetTypeDto source){
        return new PetType(
                source.getId(),
                source.getName()
        );
    }
}
